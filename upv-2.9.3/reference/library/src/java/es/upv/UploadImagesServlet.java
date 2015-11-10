package es.upv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.authz.api.SecurityService;
import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.content.api.ContentHostingService;
import org.sakaiproject.content.api.ContentResource;
import org.sakaiproject.entity.api.ResourceProperties;
import org.sakaiproject.entity.api.ResourcePropertiesEdit;
import org.sakaiproject.event.api.NotificationService;
import org.sakaiproject.exception.IdUsedException;
import org.sakaiproject.site.api.SiteService;
import org.sakaiproject.tool.api.Session;
import org.sakaiproject.tool.api.SessionManager;

/**
 * 
 * 
 */

public class UploadImagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Log M_log = LogFactory.getLog(UploadImagesServlet.class);
	
	private ContentHostingService contentHostingService = null;
    private SecurityService securityService = null;
    private SessionManager sessionManager = null;
    private SiteService siteService = null;

    
    /**
     * Ensures all necessary dependencies are loaded.
     */
    public void init() throws ServletException {
    	super.init();
    	if (contentHostingService == null) {
     		contentHostingService = (ContentHostingService) ComponentManager.get("org.sakaiproject.content.api.ContentHostingService");
     	}
     	if (securityService == null) {
     		securityService = (SecurityService) ComponentManager.get("org.sakaiproject.authz.api.SecurityService");
     	}
     	if (sessionManager == null) {
     		sessionManager = (SessionManager) ComponentManager.get("org.sakaiproject.tool.api.SessionManager");
     	}
     	if (siteService == null) {
     		siteService = (SiteService) ComponentManager.get("org.sakaiproject.site.api.SiteService");
     	}
    }
    
	/**
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		M_log.info("Entrando en doPost..............................");
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		Session session = sessionManager.getCurrentSession();
		
		String currentSiteId = (String)session.getAttribute("sakai.portal.currentSite");
		String currentFolder = "/group/" + currentSiteId + "/";
		String userId = sessionManager.getCurrentSessionUserId();
		String reference = siteService.siteReference(currentSiteId);
		
		boolean allow = securityService.unlock(userId, "content.new", reference);
		
		if (!allow) {
			throw new ServletException("You don't have permissions to add new content to the site: " + currentSiteId);
		}
		
		String fileName = request.getHeader("name");
		
		ContentResource resource = null;
		int number=0;
		
		try {
			do {
				try {
					ResourcePropertiesEdit resourceProperties = contentHostingService.newResourceProperties();
					resourceProperties.addProperty(ResourceProperties.PROP_DISPLAY_NAME, fileName);
					
					resourceProperties.addProperty(ContentHostingService.PROP_ALTERNATE_REFERENCE, "/");
		
					resource = contentHostingService.addResource(currentFolder + fileName,
							request.getHeader("CONTENT-TYPE"), request.getInputStream(), resourceProperties, NotificationService.NOTI_NONE);
					
				} catch (IdUsedException e) {
					
					fileName = request.getHeader("name")
							.substring(0, request.getHeader("name").indexOf("."))
							.concat("-" + ++number)
							.concat(request.getHeader("name").substring(request.getHeader("name").indexOf(".")));
				}  
				
			} while (resource == null);
			
		} catch (Exception ex) {
			// this user can't write where they are trying to write.
			ex.printStackTrace();
		}
		
		response.getOutputStream().println(resource == null ? "" : resource.getUrl());
	}
	
}
