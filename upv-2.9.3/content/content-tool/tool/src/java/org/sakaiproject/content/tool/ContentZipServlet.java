package org.sakaiproject.content.tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;

import java.util.zip.ZipException;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.text.Normalizer;
import java.util.Hashtable;
import java.util.Enumeration;

import org.sakaiproject.exception.ServerOverloadException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.site.cover.SiteService;
import org.sakaiproject.site.api.Site;
import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.content.cover.ContentHostingService;
import org.sakaiproject.content.api.ContentCollection;
import org.sakaiproject.content.api.ContentResource;
import org.sakaiproject.content.api.ContentEntity;
import org.sakaiproject.content.api.ResourceType;
import org.sakaiproject.entity.api.Entity;
import org.sakaiproject.entity.api.ResourceProperties;
import org.sakaiproject.entity.api.Reference;
import org.sakaiproject.entity.cover.EntityManager;
import org.sakaiproject.tool.cover.SessionManager;
import org.sakaiproject.exception.PermissionException;
import org.sakaiproject.util.ResourceLoader;
import org.sakaiproject.citation.api.CitationService;
import org.sakaiproject.citation.api.Citation;
import org.sakaiproject.citation.api.CitationCollection;
import org.sakaiproject.citation.api.CitationIterator;
import org.sakaiproject.user.cover.UserDirectoryService;
import org.sakaiproject.event.cover.EventTrackingService;
import org.apache.commons.io.FilenameUtils;


public class ContentZipServlet extends HttpServlet {
		
	private static Log log = LogFactory.getLog(ContentZipServlet.class);
	
	public void init() throws ServletException {

	}
	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doGet(req,res);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String collectionId = (String) req.getParameter("collectionId");
		String siteId = (String)req.getParameter("siteId");
		ZipOutputStream zipOut = null;
		Hashtable<String,String> urls = new Hashtable<String,String>();
		Hashtable<String,String> citations = new Hashtable<String,String>();
		List<String> titles = new ArrayList<String>();
		EventTrackingService.post(EventTrackingService.newEvent("content.zip.download.begin", 
				"siteId=" + siteId + ", collectionId=" + collectionId + ", userId=" + UserDirectoryService.getCurrentUser().getId(), 
				true));
		try{
			ContentCollection collection = ContentHostingService.getCollection(collectionId);
			boolean get = ContentHostingService.allowGetResource(collectionId);
			if (get){
				Site s = SiteService.getSite(siteId);
				List<String> members = collection.getMembers();
				titles.add(escapeCharsNotWindowsAllowed(s.getTitle()));
				if (members.size()>0) {
					//Empezamos a comprimir
					res.setContentType("application/zip;charset=UTF-8");
					res.setHeader("Content-Disposition",
							"attachment; filename = resources_download.zip");
					zipOut = new ZipOutputStream(res.getOutputStream());
					
					for (String resourceId : members){
							get = ContentHostingService.allowGetResource(resourceId);
							if (get){
								compressResource(zipOut,resourceId,urls, citations,titles);
								titles.clear();
								titles.add(escapeCharsNotWindowsAllowed(s.getTitle()));
							}
					}
					
					String[] parts = collectionId.split("/");
					parts[2] = titles.get(0);
					StringBuffer sbName = new StringBuffer();
					for (int i=0;i<parts.length;i++)
						sbName.append(parts[i]).append("/");
					
					if (urls.size()>0){
						//Creamos el fichero con las URL, solamente si hay alguna
						ZipEntry urlEntry = new ZipEntry(escapeInvalidCharsEntry(titles.get(0) + "/urls.txt"));
						zipOut.putNextEntry(urlEntry);
						
						Enumeration keys = urls.keys();
						StringBuffer sb = new StringBuffer();
						while (keys.hasMoreElements()){
							String key = (String)keys.nextElement();
							sb.append(key).append(",").append(urls.get(key)).append("\r\n").append("\r\n");
						}
						byte[] b = (sb.toString()).getBytes();			
						zipOut.write(b);
						urlEntry.setSize(b.length);
						zipOut.closeEntry();
					}
					
					if (citations.size()>0){
						//Creamos el fichero con las citations, solamente si hay alguna
						ZipEntry citationsEntry = new ZipEntry(escapeInvalidCharsEntry(titles.get(0) + "/citations.txt"));
						zipOut.putNextEntry(citationsEntry);
						
						Enumeration keys = citations.keys();
						StringBuffer sb = new StringBuffer();
						while (keys.hasMoreElements()){
							String key = (String)keys.nextElement();
							sb.append(key).append(",").append(citations.get(key)).append("\r\n").append("\r\n");
						}
						byte[] b = (sb.toString()).getBytes();			
						zipOut.write(b);
						citationsEntry.setSize(b.length);
						zipOut.closeEntry();
					}
					
					if (zipOut != null) {
						try {
							zipOut.flush();
							zipOut.close();
						} catch (Throwable ignore) {
							ignore.printStackTrace();
						}
					}
				}else{
					//No hay recursos en el site
					PrintWriter out = res.getWriter();
					out.println("<html><body><h1>" + new ResourceLoader("content").getString("zip.no_resource") + "</h1></body></html>");
				}
			}
			EventTrackingService.post(EventTrackingService.newEvent("content.zip.download", 
					"siteId=" + siteId + ", collectionId=" + collectionId + ", userId=" + UserDirectoryService.getCurrentUser().getId(), 
					true));
		} catch (PermissionException pe){
			res.sendError(res.SC_FORBIDDEN);
		}catch (Throwable ignore) {
			log.warn("Error generando zip de recursos en site "+siteId+" por el usuario "+UserDirectoryService.getCurrentUser().getId());
			ignore.printStackTrace();
			if (zipOut != null) {
				try {
					zipOut.flush();
					zipOut.close();
				} catch (Throwable i) {
				}
			}
		}		
	}

	protected void compressResource(ZipOutputStream zipOut, String resourceId, Hashtable<String,String> urls, Hashtable<String,String> citations,List<String> titles)throws Exception{
		Reference reference = EntityManager.newReference(ContentHostingService.getReference(resourceId));
		ContentEntity entity = (ContentEntity) reference.getEntity();
		//Comprobamos la disponibilidad del Recurso
			if (entity.isCollection()){
				//Es una carpeta
				ContentCollection collection = (ContentCollection)entity;
				ResourceProperties props = collection.getProperties();
				boolean get = ContentHostingService.allowGetResource(collection.getId());
				if (get){			
					titles.add(props.getPropertyFormatted(props.getNamePropDisplayName()));
					List<String> children = collection.getMembers();
					if(children != null)
					{
						for(int i = children.size() - 1; i >= 0; i--)
						{
							String child = children.get(i);
							get = ContentHostingService.allowGetResource(child);
							if (get)
								compressResource(zipOut,child,urls,citations,titles);
						}
					}
					titles.remove(props.getPropertyFormatted(props.getNamePropDisplayName()));
				}
			}else{
				try{
					//Es un fichero
					//1 - Ruta de la carpeta
					//2 - Metemos el fichero en la ruta anterior
					ContentResource resource = (ContentResource)entity;
					ResourceProperties props = resource.getProperties();
					if (resource.getResourceType().equals(CitationService.CITATION_LIST_ID)){
						CitationService cs = (CitationService) ComponentManager.get(CitationService.class);
						CitationCollection cc  = cs.getCollection(new String(resource.getContent()));
						CitationIterator it = cc.iterator();
						while (it.hasNext()){
							Citation cit = (Citation)it.next();
							String key = props.getPropertyFormatted(props.getNamePropDisplayName()) + "/" + cit.getDisplayName();
							String value;
							if (cit.hasPreferredUrl()){
								value = cit.getCustomUrl(cit.getPreferredUrlId()).toString();
							}else{
								value = cit.getOpenurl();
							}
							citations.put(escapeInvalidCharsEntry(key),value);
						}
						
					}else{
						ResourceProperties rootProps = ((Entity)resource.getContainingCollection()).getProperties();
						String rootId = resource.getContainingCollection().getId();
						StringBuffer sbName = new StringBuffer();						 
						for (String title:titles)
							sbName.append(title).append("/");
						String displayName = props.getPropertyFormatted(props.getNamePropDisplayName());
	
						if (resource.getResourceType().equals(ResourceType.TYPE_URL)){
							urls.put(escapeInvalidCharsEntry((sbName.toString() + displayName)),new String(resource.getContent()));
							return;
						}
						if (resource.getResourceType().equals(ResourceType.TYPE_TEXT)){
							displayName = displayName + ".txt";
						}else if (resource.getResourceType().equals(ResourceType.TYPE_HTML)){
							displayName = displayName + ".html";						
						}else{
							String ext = FilenameUtils.getExtension(resourceId);
							if (displayName.indexOf(ext)==-1)
								displayName = displayName + "." + ext;
						}
						displayName = displayName.replace("/","_");
						String firstEntryName = (sbName.toString() + displayName);
						firstEntryName = escapeInvalidCharsEntry(firstEntryName);
						String entryName = firstEntryName;
						// buffered stream input
						InputStream content = resource.streamContent();
						byte data[] = new byte[1024 * 10];
						BufferedInputStream bContent = null;				
						try {
							bContent = new BufferedInputStream(content, data.length);		
			
							boolean resourceAdded = false;
							int cont = 1;
							while (!resourceAdded) {
								try {
									ZipEntry resourceEntry = new ZipEntry(entryName);
									zipOut.putNextEntry(resourceEntry);
									resourceAdded = true;
								} catch (ZipException e) {
									//Nombre duplicado, añadimos numero al final, permitimos maximo 5
									if (cont<5){
										String newEntryName = sbName.toString() 
												+ FilenameUtils.getBaseName(firstEntryName)
												+ "-" + (cont++)
												+ "." + FilenameUtils.getExtension(firstEntryName);
										entryName = newEntryName;
									}else throw e;
								}
							}
							
							int bCount = -1;
							while ((bCount = bContent.read(data, 0, data.length)) != -1) {
								zipOut.write(data, 0, bCount);
							}
						} 
						catch (IOException ioException) {
							log.warn(": failed to compress resource: " + resourceId + ". Msg=" + ioException.getMessage());
						}
						finally {
							try {
								zipOut.closeEntry(); // The zip entry need to be closed
							} catch (IOException ioException) {
								ioException.printStackTrace();
							} finally{
								if (bContent != null) {
									try {
										bContent.close(); // The BufferedInputStream needs
															// to be closed
									} catch (IOException ioException) {
										log.warn(": failed to compress resource: " + resourceId + ". Msg=" + ioException.getMessage());
									}
								}

							}
						}
					}
				}catch(ServerOverloadException e){
					//cuando no existe un fichero fisico, DbContentService devuelve esta excepción
					log.warn(": failed to compress resource: "+resourceId);
				}catch(Exception e){throw e;}
			}
	}
	private String escapeInvalidCharsEntry(String accentedString) {
		String decomposed = Normalizer.normalize(accentedString,
				Normalizer.Form.NFD);
		String cleanString = decomposed.replaceAll(
				"\\p{InCombiningDiacriticalMarks}+", "");
		return cleanString;
	}	
	private String escapeCharsNotWindowsAllowed(String title) {
		String cleanTitle = title.replace("/", "_");
		cleanTitle = cleanTitle.replace("\\", "_");
		cleanTitle = cleanTitle.replace(":", "_");
		cleanTitle = cleanTitle.replace("*", "_");
		cleanTitle = cleanTitle.replace("?", "_");
		cleanTitle = cleanTitle.replace("\"", "_");
		cleanTitle = cleanTitle.replace("<", "_");
		cleanTitle = cleanTitle.replace(">", "_");
		cleanTitle = cleanTitle.replace("|", "_");
		return cleanTitle;
	}
}