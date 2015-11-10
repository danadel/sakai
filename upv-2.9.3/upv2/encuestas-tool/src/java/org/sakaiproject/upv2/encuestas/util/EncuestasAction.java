/**********************************************************************************
 *
 * Copyright (c) 2006 The Regents of the Technical University of Valencia
 * 
 * Licensed under the Educational Community License Version 1.0 (the "License");
 * By obtaining, using and/or copying this Original Work, you agree that you have read,
 * understand, and will comply with the terms and conditions of the Educational Community License.
 * You may obtain a copy of the License at:
 * 
 *      http://cvs.sakaiproject.org/licenses/license_1_0.html
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 **********************************************************************************/

package org.sakaiproject.upv2.encuestas.util;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.upv2.logic.SakaiUpvService;
import cfp.sakai.castor.EncPase;
import cfp.sakai.util.EncuestaUnMarshal;
import org.sakaiproject.tool.cover.ToolManager;
import org.sakaiproject.authz.cover.SecurityService;
import org.sakaiproject.user.api.User;
import org.sakaiproject.user.cover.UserDirectoryService;
import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.util.ResourceLoader;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.Iterator;
import org.sakaiproject.upv2.model.Encuestas;
import org.sakaiproject.upv2.model.Sitio;
import org.sakaiproject.site.api.SiteService.SelectionType;
import org.sakaiproject.site.api.SiteService.SortType;
import org.sakaiproject.site.cover.SiteService;
import org.sakaiproject.site.api.Site;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;
import org.sakaiproject.tool.api.Tool;
import org.sakaiproject.site.api.ToolConfiguration;

/**
 * <p>
 * Sakai Servlet to use for all JSF tools. 
 * </p>
 * 
 * @author Technical University of Valencia
 * @version $Revision: 1 $
 */
public class EncuestasAction
{

  private static final Log LOG = LogFactory.getLog(EncuestasAction.class);
  private SakaiUpvService sakaiUpvService;
  
  private List encAlumno = null;
  private List encProf = null;
  
  private Vector pasesAlumno = null;
  private Vector pasesProf = null;
  
  private String context = null;
  private String codigo_user = null;
  private User usuario = null;  

  public EncuestasAction(){
//	  System.out.println(" ---------- EncuestasAction ----------");
   	  setSakaiUpvService();	
   	  try{
   		  init();
   	  }catch(Exception e){
   		  e.printStackTrace();
   	  }
  }
  
  public boolean getHayEncuestasAlumno() throws Exception {
	  //init();
	  if(encAlumno!=null && encAlumno.size()>0) {
		  return true;
	  }
	  return false;
  }
  
  public boolean getHayEncuestasProf() throws Exception {
	  //init();
	  if(encProf!=null && encProf.size()>0) {
		  return true;
	  }
	  return false;
  }
  
  /*boolean haycontest = false;
  public boolean getHayContestacion() {
	  return haycontest;
  }*/

  
  public void init() throws Exception{
//	  System.out.println(" ------------- EncuestasAction.init -------------");
	  if(context==null) {
		  if(assignmentAlumnoSortColumn==null) {
			  assignmentAlumnoSortAscending = false;
			  assignmentAlumnoSortColumn = SORT_BY_DESCRIPCION;			  
		  }
		  if(assignmentProfSortColumn==null) {
			  assignmentProfSortAscending = false;
			  assignmentProfSortColumn = SORT_BY_DESCRIPCION;			  
		  }
//	      System.out.println(" 		> context(1): " + context);
	      context = getCurrentSiteId();		
//	      System.out.println(" 		> context(2): " + context);
		  usuario = UserDirectoryService.getCurrentUser();
		  codigo_user = usuario.getId();
//	      System.out.println(" 		> codigo_user: " + codigo_user);
		  if(SiteService.isUserSite(context)) {
			  Vector vSiteAlumno = new Vector();
			  Vector vSiteProf = new Vector();			  
			  List listsites = SiteService.getSites(SelectionType.ACCESS,null,null,null,SortType.NONE,null);
			  if(listsites!=null) {
				  LOG.info("Listado de mis sites: " + listsites.size());
				  for(int i=0;i<listsites.size();i++) {
					  Site siteTemp = (Site) listsites.get(i);
					  LOG.info("El site " + siteTemp.getDescription() +" es: " + siteTemp.getId());
					  if(siteTemp!=null) {
						  if(isInstructor(usuario,siteTemp.getId())) {
							  vSiteProf.addElement(siteTemp.getId());
						  }else{
							  vSiteAlumno.addElement(siteTemp.getId());
						  }
					  }
				  }
				  if(vSiteAlumno.size()>0) {
					  encAlumno = sakaiUpvService.loadEncuestasByCodigoSites(vSiteAlumno);
					  pasesAlumno = rellenarEncuestasXML();
				  }
				  if(vSiteProf.size()>0) {
					  encProf = sakaiUpvService.loadEncuestasByCodigoSites(vSiteProf);
					  pasesProf = rellenarEncuestasProfXML();
				  }
			  }			  
		  }else{			  
			  if(isInstructor(usuario,context)) {
				  encProf = sakaiUpvService.loadEncuestasByCodigoSite(context);		
				  pasesProf = rellenarEncuestasProfXML();
			  }else{
				  encAlumno = sakaiUpvService.loadEncuestasByCodigoSite(context);				  
				  pasesAlumno = rellenarEncuestasXML();
			  }
		  }
	  }	  
//      System.out.println(" 		> context(3): " + context);
  } 
  
  public Vector rellenarEncuestasXML() throws Exception {
	  LOG.info("VICTOR_ENCUESTAS: saca el listado de EncPase para el alumno");	  
	  Vector vpases = new Vector();
	  if(encAlumno!=null && encAlumno.size()>0) {
		  int[] idPases = new int[encAlumno.size()];
		  for(int i=0;i<encAlumno.size();i++) {
			  Encuestas encTemp = (Encuestas) encAlumno.get(i);
			  idPases[i] = encTemp.getIdPase();
		  }	
		  vpases = EncuestaUnMarshal.getXMLToEncuestas(idPases,codigo_user,new ResourceLoader().getLocale().getLanguage(),"alumn");	
		  LOG.info("VICTOR_ENCUESTAS: ENTRA EncPase para el alumno");
	  }
	  //pasesAlumno = vpases;
	  return vpases;
  }
  
  public Vector getEncuestasXML() throws Exception { 
	      //init();	
	      Vector vpases = new Vector();
		  if(pasesAlumno!=null && pasesAlumno.size()>0) {
			  LOG.info("ENCUESTAS DEL ALUMNO: " +pasesAlumno.size());
			  Collections.sort(pasesAlumno, (Comparator)columnSortMap.get(assignmentAlumnoSortColumn));
			  if(!assignmentAlumnoSortAscending) {
	                Collections.reverse(pasesAlumno);
	          }
			  return pasesAlumno;
		  }
		  //LOG.info("ENCUESTAS DEL ALUMNO + COMPARATOR: " + pasesAlumno.size() + " ORDENA POR: " + assignmentAlumnoSortColumn);
		  //return vpases;
		  //return EncuestaUnMarshal.getXMLToEncuestas(idPases,codigo_user,"es","alumn");
		  /*EncPase[] pases =  EncuestaUnMarshal.getXMLToEncuestas(idPases,codigo_user,"es","alumn");
		  for(int i=0;i<pases.length;i++) {
			  if(pases[i]!=null && pases[i].getTipo()!=null && (pases[i].getTipo().equals("ONLINE UNICO") || pases[i].getTipo().equals("ONLINE RETOCABLE")) ) {
				  haycontest = true;
				  break;
			  }
		  }
		  if(haycontest) LOG.info("VICTOR_ENCUESTAS: hay contestacion para EncPase para el alumno");
		  return pases;*/
		  //Si devuelve un vector null de un error de myfaces.
		  return vpases;
  }
  
  public Vector rellenarEncuestasProfXML() throws Exception {
	  LOG.info("VICTOR_ENCUESTAS: saca el listado de EncPase para el profesor");
	  Vector vpases = new Vector();
	  if(encProf!=null && encProf.size()>0) {
		  int[] idPases = new int[encProf.size()];
		  for(int i=0;i<encProf.size();i++) {
			  Encuestas encTemp = (Encuestas) encProf.get(i);
			  idPases[i] = encTemp.getIdPase();
		  }		  
		  vpases = EncuestaUnMarshal.getXMLToEncuestas(idPases,codigo_user,new ResourceLoader().getLocale().getLanguage(),"prof");
		  LOG.info("VICTOR_ENCUESTAS: SACA Y ENTRA EncPase para el profesor" + vpases.size());
	  }
	  //pasesProf = vpases;
	  return vpases;
  }
  
  //
  public Vector getEncuestasProfXML() throws Exception{
	    //LOG.info("ENCUESTAS DEL PROFESOR: ENTRA");
	  	//init();	
	  	//LOG.info("ENCUESTAS DEL PROFESOR: sale del init");
	  	Vector vpases = new Vector();
		if(pasesProf!=null && pasesProf.size()>0) {
			  LOG.info("ENCUESTAS DEL PROFESOR + COMPARATOR: " + pasesProf.size() + " ORDENA POR: " + assignmentProfSortColumn);
			  Collections.sort(pasesProf, (Comparator)columnSortMap.get(assignmentProfSortColumn));
			  if(!assignmentProfSortAscending) {
	                Collections.reverse(pasesProf);
	          }
			  
			  Iterator it = pasesProf.iterator();
			  while (it.hasNext()){
				  EncPase p = (EncPase) it.next();
//				  System.out.println(EncPaseToString(p));
			  }
			  
			  return pasesProf;
		 }
		  
/*		  if(vpases.size()>0) {
			  Object o = columnSortMap.get(assignmentProfSortColumn);
				  Comparator comp = null;
				  if (o instanceof Comparator) { 
					comp = (Comparator) o;
				  	Collections.sort(vpases, comp);	
				  	if(!assignmentProfSortAscending) {
		                Collections.reverse(vpases);
		            }		            
				  }
				  
		  }
		  //if(vpases.size()>0) Collections.sort(vpases, descripcionComparator);	
*/		  LOG.info("FUNCIONA COMPARATOR: ");		  
		  return vpases;			  
		  //return EncuestaUnMarshal.getXMLToEncuestas(idPases,codigo_user,"es","prof");
  }
	  
			 
  
  /*
   * Este sirve para mirar de un usuario y un site mirar si es instructor o no.
   * 
   */
  private boolean isInstructor(User user, String context_site)
  {
    LOG.info("isInstructor(User " + user + ")");
    if (user != null)
      return SecurityService.unlock(user, "site.upd", "/site/" + context_site);
    else
      return false;
  } 
  
  /*
   * Lo usamos para sacar la barra de arriba para generar nuevos pases.
   * 
   */
  public boolean getIsInstructorUser() throws Exception {
    LOG.info("isInstructor(User " + usuario + ")");
    //init();
    if (usuario != null && !SiteService.isUserSite(context))
      return SecurityService.unlock(usuario, "site.upd", "/site/" + context);
    else
      return false;
  } 
  
  public String nuevaEncuesta() throws Exception {
	  //Lo hago asi ya que si saco el context despu�s no sacara el listado.
	  //Y si hago el init sacara antes los listados y no estar� la nueva encuesta.
//	  System.out.println(" ------------ EncuestasAction.nuevaEncuesta ----------------");	  
	  String contextTemp = getCurrentSiteId();	
	  usuario = UserDirectoryService.getCurrentUser();
	  Site site = SiteService.getSite(contextTemp);	  
	  if(contextTemp!=null && usuario!=null && site!=null) {
		  //Con el codigo del site de sakai: contextTemp, acceder al repositorio UPV y sacar datos de nuestros sites.
		  List listSitio = sakaiUpvService.loadSitiosBySakaiCodigo(contextTemp);
		  Sitio sit = null;
		  String edicion_caca = null;
		  if(listSitio!=null && listSitio.size()>0) {
			  sit = (Sitio) listSitio.get(0);
			  if(sit!=null) edicion_caca = sit.getEdicion_caca();  //Falta poner que cuando sea el propietario el CFP ponga el edicion_caca.
		  }
		  long begin_1 = System.currentTimeMillis();
		  String sIdPase = EncuestaUnMarshal.getIdPaseEncuesta(contextTemp,usuario.getId(),site.getTitle(),edicion_caca);
		  long end_1 = System.currentTimeMillis();
//		  System.out.println("    > Tiempo que tarda en dar un idPase: " + (end_1-begin_1));
//		  System.out.println("    > idPase: " + sIdPase);
		  if((sIdPase!=null) && (sIdPase.indexOf("YA")==-1)){
			  int idPase = -1;
			  try {
				  idPase = Integer.parseInt(sIdPase);
				  long begin_2 = System.currentTimeMillis();
				  sakaiUpvService.insertEncuesta(idPase,contextTemp,usuario.getId(),null);
				  //insertEncuesta(idPase,contextTemp,usuario.getId(),null);
				  long end_2 = System.currentTimeMillis();
//				  System.out.println("    > Tiempo que tarda en insertar la encuesta: " + (end_2-begin_2));
			  }catch(Exception ex) {
				  LOG.info("NO HA SACADO BIEN EL ID PASE. " + sIdPase );
				  ex.printStackTrace();
				  return "error";
			  }			  
		  }else if (sIdPase.indexOf("YA")!=-1){
			  return "pase";
		  }else{
			  return "error";
		  }
	  }
	  return "success";
  }
  //PARA LA ORDENACION.
  public static String SORT_BY_FECHA_INICIO = "fechaInicio";
  public static String SORT_BY_FECHA_FIN = "fechaFin";
  public static String SORT_BY_DESCRIPCION = "descripcion";
  public static String SORT_BY_ID = "idPase";
  public static String DEFAULT_SORT = SORT_BY_DESCRIPCION;
  
  public static Comparator fechainicioComparator;
  public static Comparator fechafinComparator;
  public static Comparator descripcionComparator;
  public static Comparator idPaseComparator;
  
  private static final Map columnSortMap;
  
  static {
	  
	  idPaseComparator = new Comparator() {
          public int compare(Object o1, Object o2) {
              if(LOG.isDebugEnabled()) LOG.debug("Comparing + " + o1 + " to " + o2 + " by idPase");
              EncPase one = (EncPase)o1;
              EncPase two = (EncPase)o2;               
              
              if(one.getIdPase()<two.getIdPase()) return -1;
              if(one.getIdPase()>two.getIdPase()) return 1;
              return 0;
             
          }
      };
      descripcionComparator = new Comparator() {
			public int compare(Object o1, Object o2) {				
				EncPase one = (EncPase)o1;
	            EncPase two = (EncPase)o2;
	            if(one==null && two==null) return 0;
	            if(one==null) return -1;
	            if(two==null) return 1; 
	            if(LOG.isDebugEnabled()) LOG.debug("Comparing + " + one.getDescripcion() + " to " + two.getDescripcion() + " by descripcion");
              return one.getDescripcion().toLowerCase().compareTo(two.getDescripcion().toLowerCase());
			}
      };
      fechainicioComparator = new Comparator() {
          public int compare(Object o1, Object o2) {
              if(LOG.isDebugEnabled()) LOG.debug("Comparing + " + o1 + " to " + o2 + " by Fecha Inicio");
              EncPase one = (EncPase)o1;
              EncPase two = (EncPase)o2;

              if(one.getFechaInicio()==null && two.getFechaInicio()==null) return 0;
              if(one.getFechaInicio()==null) return -1;
              if(two.getFechaInicio()==null) return 1;
              return one.getFechaInicio().compareTo(two.getFechaInicio());             
          }
      };
      fechafinComparator = new Comparator() {
    	  public int compare(Object o1, Object o2) {
              if(LOG.isDebugEnabled()) LOG.debug("Comparing + " + o1 + " to " + o2 + " by Fecha Fin");
              EncPase one = (EncPase)o1;
              EncPase two = (EncPase)o2;

              if(one.getFechaFin()==null && two.getFechaFin()==null) return 0;
              if(one.getFechaFin()==null) return -1;
              if(two.getFechaFin()==null) return 1;
              return one.getFechaFin().compareTo(two.getFechaFin());             
          }
      };  
	  
      columnSortMap = new HashMap();
      columnSortMap.put(SORT_BY_ID, idPaseComparator);
      columnSortMap.put(SORT_BY_DESCRIPCION, descripcionComparator);
      columnSortMap.put(SORT_BY_FECHA_INICIO, fechainicioComparator);
      columnSortMap.put(SORT_BY_FECHA_FIN, fechafinComparator);
  }
  
  private String assignmentAlumnoSortColumn;
  private boolean assignmentAlumnoSortAscending;

  public boolean isAssignmentAlumnoSortAscending() {
      return assignmentAlumnoSortAscending;
  }
  public void setAssignmentAlumnoSortAscending(boolean assignmentAlumnoSortAscending) {
      this.assignmentAlumnoSortAscending = assignmentAlumnoSortAscending;
  }
  public String getAssignmentAlumnoSortColumn() {
      return assignmentAlumnoSortColumn;
  }
  public void setAssignmentAlumnoSortColumn(String assignmentAlumnoSortColumn) {
      this.assignmentAlumnoSortColumn = assignmentAlumnoSortColumn;     
  }
  
  private String assignmentProfSortColumn;
  private boolean assignmentProfSortAscending;

  public boolean isAssignmentProfSortAscending() {
      return assignmentProfSortAscending;
  }
  public void setAssignmentProfSortAscending(boolean assignmentProfSortAscending) {
      this.assignmentProfSortAscending = assignmentProfSortAscending;
  }
  public String getAssignmentProfSortColumn() {
      return assignmentProfSortColumn;
  }
  public void setAssignmentProfSortColumn(String assignmentProfSortColumn) {
      this.assignmentProfSortColumn = assignmentProfSortColumn;     
  } 
  
  
  
  ////  
   
  public String getRowStylesProf() {
	  StringBuffer sb = new StringBuffer();
	  LOG.info("ENTRA EN LOS ESTILOS");
	  if(pasesProf!=null && pasesProf.size()>0) {
		  Collections.sort(pasesProf, (Comparator)columnSortMap.get(assignmentProfSortColumn));
		  if(!assignmentProfSortAscending) {
                Collections.reverse(pasesProf);
          }  
		  for(int i=0;i<pasesProf.size();i++) {
			  EncPase paseTemp = (EncPase) pasesProf.get(i);
			  if(paseTemp!=null && paseTemp.getAnulado()) {
				  sb.append("external");
			  }else{ sb.append("internal"); }
			  if(i<(pasesProf.size()-1)) sb.append(",");
		  }
	  }
	  LOG.info("SACO EL TEMPSTYLES: " + sb.toString());	   
      return sb.toString();
  }
  
  
  
  
  private static String textoDescrip = "Nuevo pase de encuestas de Poliformat."; 
  public boolean getYaHayNuevaEncuesta() {
	  if(pasesProf!=null && pasesProf.size()>0) {
		  LOG.info("ENTRA POR AQUI... YA HAY NUEVA ENCUESTA. ");
		  for(int i=0;i<pasesProf.size();i++) {
			  EncPase paseTemp = (EncPase) pasesProf.get(i);
			  if(paseTemp!=null && !paseTemp.getAnulado() && paseTemp.getDescripcion()!=null && paseTemp.getDescripcion().equals(textoDescrip)) {
				  LOG.info("ENTRA Y VE QUE HAY UNA NUEVA ENCUESTA.");
				  return true;
			  }
		  }
	  }	  
	  return false;
  }
  

  public SakaiUpvService getSakaiUpvService() {
	return sakaiUpvService;
  }

  private void setSakaiUpvService(){
	LOG.info("VICTOR_ENCUESTAS: setSakaiUpvService");
    this.sakaiUpvService = (SakaiUpvService) ComponentManager.get("org.sakaiproject.upv2.logic.SakaiUpvService");
  }
  public void setSakaiUpvService(SakaiUpvService sakaiUpvService) {
	LOG.info("VICTOR_ENCUESTAS: setSakaiUpvService");
	this.sakaiUpvService = sakaiUpvService;	
  }

  public String processCancel()
  {
	  LOG.debug("processCancel()");  
	  return "encuestas";
  }

	private String EncPaseToString(EncPase p){
		String str = " 		> EncPase\n"
			 + " 			> idPase: " + p.getIdPase() + "\n"
			 + " 			> descripción: " + p.getDescripcion() + "\n"
			 + " 			> NumRespuestas: " + p.getNumRespuestas() + "\n"
			 + " 			> Tipo: " + p.getTipo() + "\n";
		return str;
	}
	
	private String getCurrentSiteId(){
		if(ToolManager.getCurrentPlacement()!=null){
			return ToolManager.getCurrentPlacement().getContext();
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
			String placementId = (String) req.getAttribute(Tool.PLACEMENT_ID);
			ToolConfiguration toolConfig = SiteService.findTool(placementId);
			return toolConfig.getSiteId();
		}
	}
	
	public String getStylesheetData(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
		return req.getAttribute("sakai.html.head.css.base") + "<br>"
			+ req.getAttribute("sakai.html.head.css.skin") + "<br>"
			+ req.getAttribute("sakai.html.head.js");
		
	}
	
}



