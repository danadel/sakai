package org.sakaiproject.tool.assessment.conditionalrelease;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.component.cover.ServerConfigurationService;
import org.sakaiproject.conditions.api.Condition;
import org.sakaiproject.conditions.api.ConditionService;
import org.sakaiproject.conditions.api.Rule;
import org.sakaiproject.entity.api.Entity;
import org.sakaiproject.event.api.Notification;
import org.sakaiproject.event.api.NotificationEdit;
import org.sakaiproject.event.api.NotificationLockedException;
import org.sakaiproject.event.api.NotificationNotDefinedException;
import org.sakaiproject.event.api.NotificationService;
import org.sakaiproject.event.cover.EventTrackingService;
import org.sakaiproject.tool.cover.ToolManager;
import org.sakaiproject.util.ResourceLoader;
import org.sakaiproject.tool.api.ToolSession;

import javax.faces.model.SelectItem;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class AssessmentConditionsHelper {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3875137390687224551L;

	static final Log logger = LogFactory.getLog(AssessmentConditionsHelper.class);
	
	static final ConditionService conditionService = (ConditionService)ComponentManager.get("org.sakaiproject.tool.assessment.conditionalrelease.AssessmentConditionService");
	
	static final NotificationService notificationService = (NotificationService)ComponentManager.get("org.sakaiproject.event.api.NotificationService");
	
	/** Resource bundle using current language locale */
    private static ResourceLoader rb = new ResourceLoader("org.sakaiproject.tool.assessment.bundle.AssessmentSettingsMessages");
    
    public static final String DOT = "_";
	
	public Boolean conditionsEnabled = false;
	public Boolean noGradebookItems = false;
	
	
	public static String saveCondition(String assessmentId, String assessmentName, boolean checkConditionalRelease, String gradebookItem, String conditionalOptionSelected, String conditionArgument, String oldNotificationId, String siteId) {
		if (! conditionsEnabled()) {
			return null;
		}
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		if (oldNotificationId!=null) {
			logger.debug("Previous condition exists. Removing related notification");
			removeExistingNotification(oldNotificationId);
		}
		
		if (checkConditionalRelease) {
			if (conditionalOptionSelected == null){ 
				return null;
			}
			
			//The selectCondition value must be broken up so we can get at the values
			//that make up the index, submittedFunctionName, missingTermQuery, and operatorValue in that order
			String[] conditionTokens = conditionalOptionSelected.split("\\|");
			int selectedIndex = Integer.valueOf(conditionTokens[0]);
			String submittedFunctionName = conditionTokens[1];
			String missingTermQuery = conditionTokens[2];
			String operatorValue = conditionTokens[3];
			
			// the number of grade points are tagging along for the ride. chop this off.
			String[] resourceTokens = gradebookItem.split("/");
			String assignmentPointsString = resourceTokens[4];
			gradebookItem = "/" + resourceTokens[1] + "/" + resourceTokens[2] + "/" + resourceTokens[3];
			String additionalAssignmentInfo = "/" + resourceTokens[4] + "/" + resourceTokens[5] + "/" + resourceTokens[6] + "/" + resourceTokens[7];
			
			String eventDataClass = conditionService.getClassNameForEvent(submittedFunctionName);
			Object argument = null;
			if ((selectedIndex == 1) || (selectedIndex == 2)) {
				argument = "dateMillis:"+resourceTokens[5];
			}
			if ((selectedIndex == 9) || (selectedIndex == 10)) {
				try {
					argument = Double.valueOf(conditionArgument);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					String feedbackDateErr = rb.getString("conditions_invalid_condition_argument");
					logger.info("Error: " + feedbackDateErr);
					
					context.addMessage(null,new FacesMessage(feedbackDateErr));
					return null;
				}
				double assignmentPoints = 0;
				try {
					assignmentPoints = new Double(assignmentPointsString);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					return null;
				}
				if (((Double)argument < 0) || ((Double)argument > assignmentPoints)) {
					String feedbackDateErr = rb.getFormattedMessage("conditions_condition_argument_outofrange", new String[] {assignmentPointsString});
					logger.info("Error: " + feedbackDateErr);
					
					context.addMessage(null,new FacesMessage(feedbackDateErr));
					return null;
				}
			}
						
			List<Condition> predicates = new ArrayList<Condition>();
			Condition resourcePredicate = conditionService.makeBooleanExpression(eventDataClass, missingTermQuery, operatorValue, argument);
			
			predicates.add(resourcePredicate);
			
			Rule resourceConditionRule = conditionService.makeRule(assessmentId, predicates, Rule.Conjunction.OR);
			NotificationEdit notification = notificationService.addNotification();
			
			notification.getProperties().addProperty("AssociatedTool","sakai.samigo");
			notification.getProperties().addProperty("AssociatedItem", rb.getString("notification_pubassess") + ": " + assessmentName);
			notification.getProperties().addProperty("AssociatedSite",siteId);
			
			notification.addFunction(submittedFunctionName);
			notification.addFunction("cond+" + submittedFunctionName);
			notification.setResourceFilter(gradebookItem);
			if (missingTermQuery.contains("Date")) {
				notification.addFunction("datetime.update");
				notification.setResourceFilter(null);
			}
			notification.setAction(resourceConditionRule);
			notification.getProperties().addProperty(ConditionService.PROP_SUBMITTED_FUNCTION_NAME, submittedFunctionName);
			notification.getProperties().addProperty(ConditionService.PROP_SUBMITTED_RESOURCE_FILTER, gradebookItem);
			notification.getProperties().addProperty(ConditionService.PROP_SELECTED_CONDITION_KEY, conditionalOptionSelected);
			notification.getProperties().addProperty(ConditionService.PROP_CONDITIONAL_RELEASE_ARGUMENT, conditionArgument);
			notification.getProperties().addProperty(ConditionService.PROP_CONDITIONAL_NOTIFICATION_ID, notification.getId());
			notification.getProperties().addProperty("SAKAI:conditionEventState", additionalAssignmentInfo);
			notificationService.commitEdit(notification);
			
			return notification.getId();
		} 
		
		return null;
	}
	
	private static boolean conditionsEnabled() {
		return ServerConfigurationService.getBoolean("conditions.service.enabled", Boolean.FALSE)
			&& conditionService != null && !conditionService.getRegisteredServiceNames().isEmpty();
	}

	public Map<String,String> loadConditionData(ToolSession state, String notificationId) {
		conditionsEnabled = conditionsEnabled();
		if (!conditionsEnabled ) {
			logger.debug("Conditional Release not enabled!!!!");
			return null;
		}
		
		Map<String,String> valuesForBean = new LinkedHashMap<String,String>();
		
		Notification notification = null;
		
		try {
			if (notificationId != null) {
				notification = notificationService.getNotification(notificationId);
			}
				
			if (notification != null) {
				valuesForBean.put("submittedFunctionName",notification.getProperties().getProperty(ConditionService.PROP_SUBMITTED_FUNCTION_NAME));
				String s1 = notification.getProperties().getProperty(ConditionService.PROP_SUBMITTED_RESOURCE_FILTER);
				String s2 = notification.getProperties().getProperty("SAKAI:conditionEventState");
				valuesForBean.put("gradebookItem",s1+s2);
				valuesForBean.put("conditionalOptionSelected",notification.getProperties().getProperty(ConditionService.PROP_SELECTED_CONDITION_KEY));
				valuesForBean.put("conditionArgument",notification.getProperties().getProperty(ConditionService.PROP_CONDITIONAL_RELEASE_ARGUMENT));
			} 
		} catch (NotificationNotDefinedException e) {
			e.printStackTrace();
			logger.info("Error:" + rb.getString("notification_load_error"));
			valuesForBean = null;
		}					
		
		Map<String,String> resourceSelections = conditionService.getEntitiesForServiceAndContext("gradebook", ToolManager.getCurrentPlacement().getContext());

		List<SelectItem> resourceSelectionsSelectItems = new ArrayList<SelectItem>();
		Set<String> keys = resourceSelections.keySet();
		Iterator<String> it = keys.iterator();
		int i=0;
		String key = "";
		String value = "";
		SelectItem option = null;
		
		while(it.hasNext()){

			key = it.next();
			value = resourceSelections.get(key);
		
		    option = new SelectItem(key, value);
			resourceSelectionsSelectItems.add(option);

			i++;
		}
		
		if(i==0)
			noGradebookItems = true;
		else
			noGradebookItems = false;
			
		//TODO look this data up
		//Using LinkedHashMap to maintain order
		Map<String,String> conditionSelections = new LinkedHashMap<String,String>();
		/*conditionSelections.put("1|gradebook.updateAssignment|dueDateHasPassed|no_operator",rb.getString("cr_duedate_passed"));
		conditionSelections.put("2|gradebook.updateAssignment|dueDateHasNotPassed|no_operator",rb.getString("cr_duedate_notpassed"));
		conditionSelections.put("3|gradebook.updateAssignment|isReleasedToStudents|no_operator",rb.getString("cr_released_to_students"));
		conditionSelections.put("4|gradebook.updateAssignment|isNotReleasedToStudents|no_operator",rb.getString("cr_not_released_to_students"));
		conditionSelections.put("5|gradebook.updateAssignment|isIncludedInCourseGrade|no_operator",rb.getString("cr_included_in_course_grade"));
		conditionSelections.put("6|gradebook.updateAssignment|isNotIncludedInCourseGrade|no_operator",rb.getString("cr_not_included_in_course_grade"));*/
		conditionSelections.put("7|gradebook.updateItemScore|isScoreBlank|no_operator", rb.getString("cr_grade_blank"));
		conditionSelections.put("8|gradebook.updateItemScore|isScoreNonBlank|no_operator", rb.getString("cr_grade_non_blank"));
		conditionSelections.put("9|gradebook.updateItemScore|getScore|less_than",rb.getString("cr_grade_less_than"));
		conditionSelections.put("10|gradebook.updateItemScore|getScore|greater_than_equal_to",rb.getString("cr_grade_greather_or_equal"));	
		
		List<SelectItem> conditionSelectionsSelectItems = new ArrayList<SelectItem>();
		keys = conditionSelections.keySet();
		it = keys.iterator();
		while(it.hasNext()){
			key = (String) it.next();
			value = (String) conditionSelections.get(key);
			option = new SelectItem(key, value);
			conditionSelectionsSelectItems.add(option);
		}
		
		//This isn't the final resting place for this data..see the buildReviseMetadataContext method in this class
		state.setAttribute("resourceSelections", resourceSelections);
		state.setAttribute("conditionSelections", conditionSelections);
		state.setAttribute("resourceSelectionsSelectItems", resourceSelectionsSelectItems);
		state.setAttribute("conditionSelectionsSelectItems", conditionSelectionsSelectItems);
		
		state.setAttribute("noGradebookItems",noGradebookItems);
		state.setAttribute("conditionsEnabled",conditionsEnabled);
		if (notification != null) 
			state.setAttribute("conditionArgument", valuesForBean.get("conditionArgument"));
		
		return valuesForBean;
		
	}

	public static void removeExistingNotification(String oldNotificationId) {
		if (! conditionsEnabled()) {
			return;
		}
		logger.debug("Removing condition");	
		try {
			NotificationEdit notificationToRemove = notificationService.editNotification(oldNotificationId);
			notificationService.removeNotification(notificationToRemove);
		} catch (NotificationLockedException e) {
			logger.info("Notificacion bloqueada.");
		} catch (NotificationNotDefinedException e) {
			logger.info("Notificacion no definida.");
		}		
	}
	
	public void buildConditionContext(ToolSession state) {
		conditionsEnabled = conditionsEnabled();
		if (! conditionsEnabled) {
			state.setAttribute("conditionsenabled", Boolean.FALSE);
			return;
		} else if(state.getAttribute("conditionsEnabled")==null){
			loadConditionData(state,null);
			//state.setAttribute("conditionsEnabled",conditionsEnabled);
		}
	}
	
	static void notifyCondition(Entity entity) {
		if (! conditionsEnabled()) {
			return;
		}
		Notification resourceNotification = null;
		String notificationId = entity.getProperties().getProperty(ConditionService.PROP_CONDITIONAL_NOTIFICATION_ID);
		if (notificationId != null && !"".equals(notificationId)) {
			try {
				resourceNotification = notificationService.getNotification(notificationId);
			} catch (NotificationNotDefinedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		if (resourceNotification != null) {
			String eventDataString = resourceNotification.getProperties().getProperty("SAKAI:conditionEventState");
			// event resource of the form: /gradebook/[gradebook id]/[assignment name]/[points possible]/[due date millis]/[is released]/[is included in course grade]/[has authz]
			String resource = resourceNotification.getResourceFilter();
			if (resource == null) resource = "/gradebook/null/null";
			EventTrackingService.post(EventTrackingService.newEvent("cond+" + resourceNotification.getFunction(), resource + eventDataString, true));
		}
		
	}
	
	public static void notifyCondition(String notificationId) {
		
		if (! conditionsEnabled()) {
			return;
		}
		Notification assessmentNotification = null;
		if (notificationId != null && !"".equals(notificationId)) {
			try {
				assessmentNotification = notificationService.getNotification(notificationId);
			} catch (NotificationNotDefinedException e) {
				e.printStackTrace();
			}
		}
			
		if (assessmentNotification != null) {
			String eventDataString = assessmentNotification.getProperties().getProperty("SAKAI:conditionEventState");
			// event resource of the form: /gradebook/[gradebook id]/[assignment name]/[points possible]/[due date millis]/[is released]/[is included in course grade]/[has authz]
			String assessment = assessmentNotification.getResourceFilter();
			if (assessment == null) assessment = "/gradebook/null/null";
			EventTrackingService.post(EventTrackingService.newEvent("cond+" + assessmentNotification.getFunction(), assessment + eventDataString, true));
		}
		
	}
	
	public String cloneNotification(String notificationId, String assessmentId, String assessmentName, String siteId){
		NotificationEdit newNotification = null;
		
		try{
			Notification notification = notificationService.getNotification(notificationId);
			if (notification != null) {
				
				String gradebookItem = notification.getProperties().getProperty(ConditionService.PROP_SUBMITTED_RESOURCE_FILTER);
				String submittedFunctionName = notification.getProperties().getProperty(ConditionService.PROP_SUBMITTED_FUNCTION_NAME);
				String conditionEventState = notification.getProperties().getProperty("SAKAI:conditionEventState");
				String conditionalOptionSelected = notification.getProperties().getProperty(ConditionService.PROP_SELECTED_CONDITION_KEY);
				String[] conditionTokens = (conditionalOptionSelected).split("\\|");//a lo mejor esto hace que hayan cosas replicadas innecesarias
				int selectedIndex = Integer.valueOf(conditionTokens[0]);

				String missingTermQuery = conditionTokens[2];
				String operatorValue = conditionTokens[3];

				// the number of grade points are tagging along for the ride. chop this off.
				String[] resourceTokens = (gradebookItem+conditionEventState).split("/");
				String assignmentPointsString = resourceTokens[4];
				gradebookItem = "/" + resourceTokens[1] + "/" + resourceTokens[2] + "/" + resourceTokens[3];
				String additionalAssignmentInfo = "/" + resourceTokens[4] + "/" + resourceTokens[5] + "/" + resourceTokens[6] + "/" + resourceTokens[7];
					
				String conditionArgument = notification.getProperties().getProperty(ConditionService.PROP_CONDITIONAL_RELEASE_ARGUMENT);
					
				String eventDataClass = conditionService.getClassNameForEvent(submittedFunctionName);
					
				Object argument = null;
				if ((selectedIndex == 1) || (selectedIndex == 2)) {
					argument = "dateMillis:"+resourceTokens[5];
				}
				if ((selectedIndex == 9) || (selectedIndex == 10)) {
					try {
						argument = Double.valueOf(conditionArgument);
					} catch (NumberFormatException e) {
						return null;
					}
					
				}
					
				List<Condition> predicates = new ArrayList<Condition>();
				Condition resourcePredicate = conditionService.makeBooleanExpression(eventDataClass, missingTermQuery, operatorValue, argument);
					
				predicates.add(resourcePredicate);
		
				Rule resourceConditionRule = conditionService.makeRule(assessmentId, predicates, Rule.Conjunction.OR);
					
					
				newNotification = notificationService.addNotification();
					
				newNotification.addFunction(submittedFunctionName);
				newNotification.addFunction("cond+" + submittedFunctionName);

				newNotification.setResourceFilter(gradebookItem);
					
				if (missingTermQuery.contains("Date")) {
					newNotification.addFunction("datetime.update");
					newNotification.setResourceFilter(null);
				}	
					
				newNotification.setAction(resourceConditionRule);
					
				newNotification.getProperties().addProperty(ConditionService.PROP_SUBMITTED_FUNCTION_NAME, submittedFunctionName);
				newNotification.getProperties().addProperty(ConditionService.PROP_SUBMITTED_RESOURCE_FILTER, gradebookItem);
				newNotification.getProperties().addProperty("SAKAI:conditionEventState",conditionEventState);
				newNotification.getProperties().addProperty(ConditionService.PROP_SELECTED_CONDITION_KEY, conditionalOptionSelected);
				newNotification.getProperties().addProperty(ConditionService.PROP_CONDITIONAL_RELEASE_ARGUMENT, conditionArgument);
				newNotification.getProperties().addProperty(ConditionService.PROP_CONDITIONAL_NOTIFICATION_ID, newNotification.getId());
				
				newNotification.getProperties().addProperty("AssociatedTool", "sakai.samigo");
				newNotification.getProperties().addProperty("AssociatedItem", rb.getString("notification_pubassess") + ": " + assessmentName);
				newNotification.getProperties().addProperty("AssociatedSite", siteId);
					
				notificationService.commitEdit(newNotification);
			}
		} catch (NotificationNotDefinedException e) {
			logger.info(rb.getString("notification_load_error"));
			return null;
		}	
		
		return newNotification.getId();
	
	}
}