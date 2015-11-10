package org.sakaiproject.tool.assessment.ui.listener.author;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.event.cover.EventTrackingService;
import org.sakaiproject.tool.assessment.data.ifc.assessment.PublishedAssessmentIfc;
import org.sakaiproject.tool.assessment.facade.AgentFacade;
import org.sakaiproject.tool.assessment.facade.PublishedAssessmentFacade;
import org.sakaiproject.tool.assessment.services.GradingService;
import org.sakaiproject.tool.assessment.services.assessment.PublishedAssessmentService;
import org.sakaiproject.tool.assessment.ui.bean.author.AuthorBean;
import org.sakaiproject.tool.assessment.ui.bean.author.PublishedAssessmentBean;
import org.sakaiproject.tool.assessment.ui.bean.authz.AuthorizationBean;
import org.sakaiproject.tool.assessment.ui.listener.util.ContextUtil;

/**
 * <p>Title: Samigo</p>
 * <p>Description: Sakai Assessment Manager</p>
 * @author Angel Nueda
 * @version $Id: RestorePublishedAssessmentListener.java 16926 2006-10-09 23:19:51Z anueda@asic.upv.es $
 */

public class RestorePublishedAssessmentListener implements ActionListener
{
  private static Log log = LogFactory.getLog(RestorePublishedAssessmentListener.class);

  public RestorePublishedAssessmentListener()
  {
  }

  public void processAction(ActionEvent ae) throws AbortProcessingException
  {
    FacesContext context = FacesContext.getCurrentInstance();

    // #1 - read the assessmentId from the form
    String publishedAssessmentId = (String) FacesContext.getCurrentInstance().
        getExternalContext().getRequestParameterMap().get("publishedAssessmentId");
    log.debug("publishedAssessmentId = " + publishedAssessmentId);
    
    // #2 -  and use it to set author bean, goto removeAssessment.jsp
    PublishedAssessmentBean publishedAssessmentBean = (PublishedAssessmentBean) ContextUtil.lookupBean("publishedassessment");
    
    PublishedAssessmentService publishedAssessmentService = new PublishedAssessmentService();
    PublishedAssessmentFacade publishedAssessment = publishedAssessmentService.getPublishedAssessmentInfoForRemove(Long.valueOf(publishedAssessmentId));
    
    AuthorBean author = (AuthorBean) ContextUtil.lookupBean("author");
    
    if (publishedAssessment != null) {
    	// #3 - permission checking before proceeding - daisyf
    	if (!passAuthz(context, publishedAssessment.getCreatedBy())){
    		return;
    	}
    	
    	ArrayList publishedAssessmentList = author.getPublishedAssessments();
    	String title = publishedAssessment.getTitle();
    	StringBuffer newTitle = new StringBuffer(title);
    	String sufix = ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.AuthorMessages",
			     "append_restore_title");
    	int number = 1;
    	boolean titleIsNotUnique = true;
    	
    	while (titleIsNotUnique) {
    		titleIsNotUnique = false;
	        for (int i=0; i<publishedAssessmentList.size();i++){
	      	  	PublishedAssessmentFacade pa = (PublishedAssessmentFacade) publishedAssessmentList.get(i);
	      	  	if (newTitle.toString().equals(pa.getTitle()) && !pa.getStatus().equals(PublishedAssessmentIfc.DEAD_STATUS)) {
	      	  		newTitle = new StringBuffer(title);
	      	  		newTitle.append(sufix);
	      	  		newTitle.append(number++);
	      	  		titleIsNotUnique = true;
	      	  		break;
	      	  	}
	        }
    	}
    	
    	PublishedAssessmentFacade restored = 
    			publishedAssessmentService.restorePublishedAssessment(Long.valueOf(publishedAssessmentId), newTitle.toString());
    	restored.setRemovedForDisplay(false);
    	restored.setLastModifiedBy(AgentFacade.getDisplayNameByAgentId(restored.getLastModifiedBy()));
        
        EventTrackingService.post(EventTrackingService.newEvent("sam.pubAssessment.restore", "siteId=" + AgentFacade.getCurrentSiteId() + ", publisedAssessmentId=" + publishedAssessmentId, true));
            
        publishedAssessmentList = author.getPublishedAssessments();
        ArrayList list = new ArrayList();
        for (int i=0; i<publishedAssessmentList.size();i++){
      	  	PublishedAssessmentFacade pa = (PublishedAssessmentFacade) publishedAssessmentList.get(i);
      	  	if (!(publishedAssessmentId).equals(pa.getPublishedAssessmentId().toString())) {
      	  		list.add(pa);
      	  	}
      	  	else {
      	  		list.add(restored);
      	  	}
        }
        AuthorActionListener authorActionListener = new AuthorActionListener();
		GradingService gradingService = new GradingService();
		
		authorActionListener.prepareAllPublishedAssessmentsList(author, gradingService, list);
        
    }
    else {
    	log.warn("publishedAssessment is null");
    }
    
  }

  public boolean passAuthz(FacesContext context, String ownerId){
    AuthorizationBean authzBean = (AuthorizationBean) ContextUtil.lookupBean("authorization");
    boolean hasPrivilege_any = authzBean.getDeleteAnyAssessment();
    boolean hasPrivilege_own0 = authzBean.getDeleteOwnAssessment();
    boolean hasPrivilege_own = (hasPrivilege_own0 && isOwner(ownerId));
    boolean hasPrivilege = (hasPrivilege_any || hasPrivilege_own);
    if (!hasPrivilege){
      String err=(String)ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.AuthorMessages",
				     "denied_restore_other_members_assessment_error");
      context.addMessage(null,new FacesMessage(err));
    }
    return hasPrivilege;
  }

  public boolean isOwner(String ownerId){
    boolean isOwner = false;
    String agentId = AgentFacade.getAgentString();
    isOwner = agentId.equals(ownerId);
    return isOwner;
  }

}
