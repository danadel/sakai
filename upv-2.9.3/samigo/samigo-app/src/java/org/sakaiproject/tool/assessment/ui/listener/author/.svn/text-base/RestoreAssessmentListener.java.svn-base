/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/msub/upv.es/PoliformaT/upv-2.9.3/samigo/samigo-app/src/java/org/sakaiproject/tool/assessment/ui/listener/author/ConfirmRemoveAssessmentListener.java $
 * $Id: ConfirmRemoveAssessmentListener.java 67326 2009-10-07 17:54:01Z ktsao@stanford.edu $
 ***********************************************************************************
 *
 * Copyright (c) 2004, 2005, 2006, 2008 The Sakai Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **********************************************************************************/



package org.sakaiproject.tool.assessment.ui.listener.author;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.event.cover.EventTrackingService;
import org.sakaiproject.tool.assessment.data.ifc.assessment.AssessmentBaseIfc;
import org.sakaiproject.tool.assessment.facade.AgentFacade;
import org.sakaiproject.tool.assessment.facade.AssessmentFacade;
import org.sakaiproject.tool.assessment.services.assessment.AssessmentService;
import org.sakaiproject.tool.assessment.ui.bean.author.AssessmentBean;
import org.sakaiproject.tool.assessment.ui.bean.author.AuthorBean;
import org.sakaiproject.tool.assessment.ui.bean.authz.AuthorizationBean;
import org.sakaiproject.tool.assessment.ui.listener.util.ContextUtil;
import org.sakaiproject.tool.assessment.ui.listener.util.TimeUtil;
import org.sakaiproject.util.ResourceLoader;

/**
 * <p>Title: Samigo</p>
 * <p>Description: Sakai Assessment Manager</p>
 * @author Ed Smiley
 * @version $Id: RestoreAssessmentListener.java 67326 2009-10-07 17:54:01Z ktsao@stanford.edu $
 */

public class RestoreAssessmentListener implements ActionListener
{
  private static Log log = LogFactory.getLog(RestoreAssessmentListener.class);
  private TimeUtil tu = new TimeUtil();
  private String display_dateFormat= ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.GeneralMessages","output_data_picker_w_sec");
  private SimpleDateFormat displayFormat = new SimpleDateFormat(display_dateFormat, new ResourceLoader().getLocale());

  public RestoreAssessmentListener()
  {
  }

  public void processAction(ActionEvent ae) throws AbortProcessingException
  {
    FacesContext context = FacesContext.getCurrentInstance();

    // #1 - read the assessmentId from the form
    String assessmentId = (String) FacesContext.getCurrentInstance().
        getExternalContext().getRequestParameterMap().get("assessmentId");

    // #2 -  and use it to set author bean, goto removeAssessment.jsp
    AssessmentBean assessmentBean = (AssessmentBean) ContextUtil.lookupBean(
                                                           "assessmentBean");
    AssessmentService assessmentService = new AssessmentService();
    AssessmentFacade assessment = assessmentService.getBasicInfoOfAnAssessment(assessmentId);

    // #3 - permission checking before proceeding - daisyf
    AuthorBean author = (AuthorBean) ContextUtil.lookupBean("author");
    
    if (!passAuthz(context, assessment.getCreatedBy())){
    	return;
    }
    
    ArrayList assessmentList = author.getAssessments();
	String title = assessment.getTitle();
	StringBuffer newTitle = new StringBuffer(title);
	String sufix = ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.AuthorMessages",
		     "append_restore_title");
	int number = 1;
	boolean titleIsNotUnique = true;
	
	while (titleIsNotUnique) {
		titleIsNotUnique = false;
        for (int i=0; i<assessmentList.size();i++){
      	  	AssessmentFacade a = (AssessmentFacade) assessmentList.get(i);
      	  	if (newTitle.toString().equals(a.getTitle()) && !a.getStatus().equals(AssessmentBaseIfc.DEAD_STATUS)) {
      	  		newTitle = new StringBuffer(title);
      	  		newTitle.append(sufix);
      	  		newTitle.append(number++);
      	  		titleIsNotUnique = true;
      	  		break;
      	  	}
        }
	}
    
    AssessmentFacade restored = assessmentService.restoreAssessment(Long.parseLong(assessmentId), newTitle.toString());
    try {
		String lastModifiedDateDisplay = tu.getDisplayDateTime(displayFormat, restored.getLastModifiedDate());
		restored.setLastModifiedDateForDisplay(lastModifiedDateDisplay);  
	}
	catch (Exception ex) {
		log.warn("Unable to format date: " + ex.getMessage());
	}
    restored.setRemovedForDisplay(false);
    restored.setQuestionSize(assessmentService.getQuestionSize(assessmentId));
    restored.setLastModifiedBy(AgentFacade.getDisplayNameByAgentId(restored.getLastModifiedBy()));
    
    EventTrackingService.post(EventTrackingService.newEvent("sam.assessment.restore", "siteId=" + AgentFacade.getCurrentSiteId() + ", assessmentId=" + assessmentId, true));
        
    ArrayList list = new ArrayList();
    for (int i=0; i<assessmentList.size();i++){
  	  	AssessmentFacade pa = (AssessmentFacade) assessmentList.get(i);
  	  	if (!(assessmentId).equals(pa.getAssessmentBaseId().toString())) {
  	  		list.add(pa);
  	  	}
  	  	else {
  	  		list.add(restored);
  	  	}
    }
    author.setAssessments(list);

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
