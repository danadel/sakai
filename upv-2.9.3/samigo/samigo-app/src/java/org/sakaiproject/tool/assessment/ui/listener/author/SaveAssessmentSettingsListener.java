/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/msub/upv.es/PoliformaT/upv-2.9.3/samigo/samigo-app/src/java/org/sakaiproject/tool/assessment/ui/listener/author/SaveAssessmentSettingsListener.java $
 * $Id: SaveAssessmentSettingsListener.java 321328 2015-09-25 07:50:37Z anueda@asic.upv.es $
 ***********************************************************************************
 *
 * Copyright (c) 2004, 2005, 2006, 2007, 2008 The Sakai Foundation
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.tool.assessment.api.SamigoApiFactory;
import org.sakaiproject.tool.assessment.data.dao.assessment.AssessmentAccessControl;
import org.sakaiproject.tool.assessment.data.ifc.assessment.AssessmentAccessControlIfc;
import org.sakaiproject.tool.assessment.data.ifc.assessment.EvaluationModelIfc;
import org.sakaiproject.tool.assessment.facade.AssessmentFacade;
import org.sakaiproject.tool.assessment.services.assessment.AssessmentService;
import org.sakaiproject.tool.assessment.shared.api.assessment.SecureDeliveryServiceAPI;
import org.sakaiproject.tool.assessment.ui.bean.author.AssessmentSettingsBean;
import org.sakaiproject.tool.assessment.ui.bean.author.AuthorBean;
import org.sakaiproject.tool.assessment.ui.listener.util.ContextUtil;
import org.sakaiproject.tool.assessment.util.TextFormat;
import org.sakaiproject.util.FormattedText;
import org.sakaiproject.util.ResourceLoader;

/**
 * <p>Title: Samigo</p>2
 * <p>Description: Sakai Assessment Manager</p>
 * @author Ed Smiley
 * @version $Id: SaveAssessmentSettingsListener.java 321328 2015-09-25 07:50:37Z anueda@asic.upv.es $
 */

public class SaveAssessmentSettingsListener
    implements ActionListener
{
  private static Log log = LogFactory.getLog(SaveAssessmentSettingsListener.class);
  //private static final GradebookServiceHelper gbsHelper = IntegrationContextFactory.getInstance().getGradebookServiceHelper();
  //private static final boolean integrated = IntegrationContextFactory.getInstance().isIntegrated();

  public SaveAssessmentSettingsListener()
  {
  }

  public void processAction(ActionEvent ae) throws AbortProcessingException
  {
    FacesContext context = FacesContext.getCurrentInstance();

    AssessmentSettingsBean assessmentSettings = (AssessmentSettingsBean) ContextUtil.
        lookupBean("assessmentSettings");
    boolean error=false;
    String assessmentId=String.valueOf(assessmentSettings.getAssessmentId()); 
    AssessmentService assessmentService = new AssessmentService();
    SaveAssessmentSettings s = new SaveAssessmentSettings();
    String assessmentName = TextFormat.convertPlaintextToFormattedTextNoHighUnicode(log, assessmentSettings.getTitle());
 
    // check if name is empty
    if(assessmentName!=null &&(assessmentName.trim()).equals("")){
     	String nameEmpty_err=ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.AssessmentSettingsMessages","assessmentName_empty");
	context.addMessage(null,new FacesMessage(nameEmpty_err));
	error=true;
    }

    // check if name is unique 
    if(!assessmentService.assessmentTitleIsUnique(assessmentId,assessmentName,false)){
	String nameUnique_err=ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.AssessmentSettingsMessages","assessmentName_error");
	context.addMessage(null,new FacesMessage(nameUnique_err));
	error=true;
    }
    
    // check if start date is valid
    if(!assessmentSettings.getIsValidStartDate()){
    	String startDateErr = ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.GeneralMessages","invalid_start_date");
    	context.addMessage(null,new FacesMessage(startDateErr));
    	error=true;
    }
    // check if due date is valid
    if(!assessmentSettings.getIsValidDueDate()){
    	String dueDateErr = ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.GeneralMessages","invalid_due_date");
    	context.addMessage(null,new FacesMessage(dueDateErr));
    	error=true;
    }
    // check if retract date is valid
    if(!assessmentSettings.getIsValidRetractDate()){
    	String retractDateErr = ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.GeneralMessages","invalid_retrack_date");
    	context.addMessage(null,new FacesMessage(retractDateErr));
    	error=true;
    }
    
    // check if there is a time limit period specified then accept late handing must be selected
    if ("2".equals(assessmentSettings.getLateHandling())) {
    	Date retractDate = assessmentSettings.getRetractDate();
    	Date dueDate = assessmentSettings.getDueDate();
    	if (retractDate != null && dueDate != null && 
    			retractDate.getTime() - dueDate.getTime() >= 1000) 
    	{
    		String notAcceptLateSubErr = ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.AssessmentSettingsMessages","notAcceptLateSubmission_error");
    		context.addMessage(null,new FacesMessage(notAcceptLateSubErr));
    		error=true;
    	}
    }
    
    if (assessmentSettings.getReleaseTo().equals(AssessmentAccessControl.RELEASE_TO_SELECTED_STUDENTS)) {
    	List groupList = assessmentSettings.getSerialized_groupList().equals("") ? new ArrayList<String>() : Arrays.asList(assessmentSettings.getSerialized_groupList().split(","));
    	List userList = assessmentSettings.getSerialized_userList().equals("") ? new ArrayList<String>() : Arrays.asList(assessmentSettings.getSerialized_userList().split(","));
    	if (groupList.isEmpty() && userList.isEmpty()) {
    		String releaseGroupError = ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.GeneralMessages","choose_one_group");
        	context.addMessage(null,new FacesMessage(releaseGroupError));
        	error=true;
        	assessmentSettings.setNoGroupSelectedError(true);
    	}
    	else {
    		assessmentSettings.setNoGroupSelectedError(false);
    	}
    }
    
    //  if timed assessment, does it has value for time
    Object time=assessmentSettings.getValueMap().get("hasTimeAssessment");
    boolean isTime=false;
    try
    {
      if (time != null)
      {
        isTime = ( (Boolean) time).booleanValue();
      }
    }
    catch (Exception ex)
    {
      // keep default
      log.warn("Expecting Boolean hasTimeAssessment, got: " + time);

    }
    if((isTime) &&((assessmentSettings.getTimeLimit().intValue())==0)){
	String time_err=ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.AssessmentSettingsMessages","timeSelect_error");
	context.addMessage(null,new FacesMessage(time_err));
        error=true;
    }
    
    String ipString = assessmentSettings.getIpAddresses().trim();  
     String[]arraysIp=(ipString.split("\n"));
     boolean ipErr=false;
     for(int a=0;a<arraysIp.length;a++){
	 String currentString=arraysIp[a];
	 if(!currentString.trim().equals("")){
	     if(a<(arraysIp.length-1))
		 currentString=currentString.substring(0,currentString.length()-1);           
	     if(!s.isIpValid(currentString)){
		 ipErr=true;
		 break;
	     }
	 }
	
     }
	if(ipErr){
	    error=true;
	    String  ip_err=ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.AssessmentSettingsMessages","ip_error");
	    context.addMessage(null,new FacesMessage(ip_err));

	}

	String unlimitedSubmissions = assessmentSettings.getUnlimitedSubmissions();
	if (unlimitedSubmissions != null && unlimitedSubmissions.equals(AssessmentAccessControlIfc.LIMITED_SUBMISSIONS.toString())) {
		try {
			String submissionsAllowed = assessmentSettings.getSubmissionsAllowed().trim();
			int submissionAllowed = Integer.parseInt(submissionsAllowed);
			if (submissionAllowed < 1) {
				throw new RuntimeException();
			}
		}
		catch (RuntimeException e){
			error=true;
			String  submission_err = ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.AssessmentSettingsMessages","submissions_allowed_error");
			context.addMessage(null,new FacesMessage(submission_err));
		}
	}
	
	//String unlimitedSubmissions = assessmentSettings.getUnlimitedSubmissions();
	String scoringType=assessmentSettings.getScoringType();
	if ((scoringType).equals(EvaluationModelIfc.AVERAGE_SCORE.toString()) && "0".equals(assessmentSettings.getUnlimitedSubmissions())) {
		try {
			String submissionsAllowed = assessmentSettings.getSubmissionsAllowed().trim();
			int submissionAllowed = Integer.parseInt(submissionsAllowed);
			if (submissionAllowed < 2) {
				throw new RuntimeException();
			}
		}
		catch (RuntimeException e){
			error=true;
			String  submission_err = ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.AssessmentSettingsMessages","averag_grading_single_submission");
			context.addMessage(null,new FacesMessage(submission_err));
		}
	}
		
    //check feedback - if at specific time then time should be defined.
    if((assessmentSettings.getFeedbackDelivery()).equals("2")) {
    	if (assessmentSettings.getFeedbackDateString()==null || assessmentSettings.getFeedbackDateString().equals("")) {
    		error=true;
    		String  date_err=ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.AssessmentSettingsMessages","date_error");
    		context.addMessage(null,new FacesMessage(date_err));
    	}
    	else if(!assessmentSettings.getIsValidFeedbackDate()){
        	String feedbackDateErr = ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.GeneralMessages","invalid_feedback_date");
        	context.addMessage(null,new FacesMessage(feedbackDateErr));
        	error=true;
        }
    }
    
    // check secure delivery exit password
    SecureDeliveryServiceAPI secureDeliveryService = SamigoApiFactory.getInstance().getSecureDeliveryServiceAPI();
    if ( secureDeliveryService.isSecureDeliveryAvaliable() ) {
    	
    	String moduleId = assessmentSettings.getSecureDeliveryModule();
    	if ( ! SecureDeliveryServiceAPI.NONE_ID.equals( moduleId ) ) {
		
    		String exitPassword = assessmentSettings.getSecureDeliveryModuleExitPassword(); 
    		if ( exitPassword != null && exitPassword.length() > 0 ) {
   				
    			for ( int i = 0; i < exitPassword.length(); i++ ) {
					
    				char c = exitPassword.charAt(i);
    				if ( ! (( c >= 'a' && c <= 'z' ) || ( c >= 'A' && c <= 'Z' ) || ( c >= '0' && c <= '9' )) ) {
    					error = true;
    					String  submission_err = ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.AssessmentSettingsMessages","exit_password_error");
    					context.addMessage(null,new FacesMessage(submission_err));
    					break;
    				}
    			}					
    		}
    	}			
    }
    
    // CR
    String gradebookItem = assessmentSettings.getGradebookItem();
    String[] conditionTokens = gradebookItem.split("/");
    String conditionalOptionSelected = assessmentSettings.getConditionalOptionSelected();
    String[] optionTokens = conditionalOptionSelected.split("\\|");
    boolean checkConditionalRelease = assessmentSettings.getCheckConditionalRelease();
    String conditionArgument = assessmentSettings.getConditionArgument();
    
    if (checkConditionalRelease) {
	    if ("9".equals(optionTokens[0]) || "10".equals(optionTokens[0])) {
	    	Double argument;
	    	try {
				argument = Double.valueOf(conditionArgument);
			} catch (NumberFormatException e) {
				String feedbackDateErr = ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.AssessmentSettingsMessages", "conditions_invalid_condition_argument");
				log.info("Error: " + feedbackDateErr);
				context.addMessage(null,new FacesMessage(feedbackDateErr));
				return;
			}
			double assignmentPoints = 0;
			try {
				assignmentPoints = new Double(conditionTokens[4]);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				return;
			}
			if (argument < 0 || argument > assignmentPoints) {
				ResourceLoader rb = new ResourceLoader("org.sakaiproject.tool.assessment.bundle.AssessmentSettingsMessages");
				String feedbackDateErr = rb.getFormattedMessage("conditions_condition_argument_outofrange", new String[] {conditionTokens[4]});
				log.info("Error: " + feedbackDateErr);
				context.addMessage(null,new FacesMessage(feedbackDateErr));
				return;
			}
		}
    }
    	
    if (error){
      String blockDivs = ContextUtil.lookupParam("assessmentSettingsAction:blockDivs");
      assessmentSettings.setBlockDivs(blockDivs);
      assessmentSettings.setOutcomeSave("editAssessmentSettings");
      return;
    }
 
    // Set the outcome once Save button is clicked
    AuthorBean author = (AuthorBean) ContextUtil.lookupBean("author");
    assessmentSettings.setOutcomeSave(author.getFromPage());

    s.save(assessmentSettings, false);

    // reset the core listing in case assessment title changes
    ArrayList assessmentList = assessmentService.getBasicInfoOfAllActiveAssessments(
    		author.getCoreAssessmentOrderBy(),author.isCoreAscending());
    Iterator iter = assessmentList.iterator();
	while (iter.hasNext()) {
		AssessmentFacade assessmentFacade= (AssessmentFacade) iter.next();
		assessmentFacade.setTitle(FormattedText.convertFormattedTextToPlaintext(assessmentFacade.getTitle()));
	}
    // get the managed bean, author and set the list
    author.setAssessments(assessmentList);

    // goto Question Authoring page
    EditAssessmentListener editA= new EditAssessmentListener();
    editA.setPropertiesForAssessment(author);
  }
}
