package org.etudes.tool.melete.conditionalrelease;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.etudes.api.app.melete.ModuleObjService;
import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.component.cover.ServerConfigurationService;
import org.sakaiproject.conditions.api.Condition;
import org.sakaiproject.conditions.api.ConditionService;
import org.sakaiproject.conditions.api.Rule;
import org.sakaiproject.event.api.Notification;
import org.sakaiproject.event.api.NotificationEdit;
import org.sakaiproject.event.api.NotificationLockedException;
import org.sakaiproject.event.api.NotificationNotDefinedException;
import org.sakaiproject.event.api.SessionState;
import org.sakaiproject.event.cover.EventTrackingService;
import org.sakaiproject.event.cover.NotificationService;
import org.sakaiproject.tool.cover.ToolManager;
import org.sakaiproject.util.ResourceLoader;
import org.sakaiproject.tool.api.ToolSession;

import javax.faces.model.SelectItem;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MeleteConditionsHelper {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3875137390687224551L;

	static final Log logger = LogFactory.getLog(MeleteConditionsHelper.class);
	
	static final ConditionService conditionService = (ConditionService)ComponentManager.get("MeleteConditionService");
	
	/** Resource bundle using current language locale */
    private static ResourceLoader rb = new ResourceLoader("org.etudes.tool.melete.bundle.Messages");
    
    public static final String DOT = "_";
	
	public Boolean conditionsEnabled = false;
	public Boolean noGradebookItems = false;
	
	public MeleteConditionsHelper(){		
	}
	
	public static <Module> String saveCondition(ModuleObjService module, boolean checkConditionalRelease, String gradebookItem, String conditionalOptionSelected, String conditionArgument, String oldNotificationId, String siteId) {
		if (! conditionsEnabled()) {
			return null;
		}
		
		FacesContext context = FacesContext.getCurrentInstance();
		
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
				String feedbackDateErr = rb.getString("conditions_invalid_condition_argument");
				logger.info("Error: " + feedbackDateErr);
				if(checkConditionalRelease==true)
					context.addMessage(null,new FacesMessage(feedbackDateErr));
				return null;
			}
			double assignmentPoints = 0;
			try {
				assignmentPoints = new Double(assignmentPointsString);
			} catch (NumberFormatException e) {
				return null;
			}
			if (((Double)argument < 0) || ((Double)argument > assignmentPoints)) {
				String feedbackDateErr = rb.getString("conditions_condition_argument_outofrange") + assignmentPointsString ;
				logger.info("Error: " + feedbackDateErr);
				if(checkConditionalRelease==true)
					context.addMessage(null,new FacesMessage(feedbackDateErr));
				return null;
			}
		}
		
		if (checkConditionalRelease) {
			if (oldNotificationId!=null) {
				logger.debug("Previous condition exists. Removing related notification");
				removeExistingNotification(oldNotificationId);
			}
						
			List<Condition> predicates = new ArrayList();
			Condition resourcePredicate = conditionService.makeBooleanExpression(eventDataClass, missingTermQuery, operatorValue, argument);
			
			predicates.add(resourcePredicate);
			
			Rule resourceConditionRule = conditionService.makeRule(module.getModuleId().toString(), predicates, Rule.Conjunction.OR);
			NotificationEdit notification = NotificationService.addNotification();
			
			notification.getProperties().addProperty("AssociatedTool","sakai.melete");
			notification.getProperties().addProperty("AssociatedItem", rb.getString("add_module_module_title") + ": " + module.getTitle() );
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
			notification.getProperties().addProperty("SAKAI:conditionEventState", additionalAssignmentInfo);
			NotificationService.commitEdit(notification);
			
			return notification.getId();
			
		} else {
			//only remove the condition if it previously existed
			if (oldNotificationId!=null) {
				removeExistingNotification(oldNotificationId);
			}			
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
				notification = NotificationService.getNotification(notificationId);
				if (notification != null) {
					valuesForBean.put("submittedFunctionName",notification.getProperties().getProperty(ConditionService.PROP_SUBMITTED_FUNCTION_NAME));
					String s1 = notification.getProperties().getProperty(ConditionService.PROP_SUBMITTED_RESOURCE_FILTER);
					String s2 = notification.getProperties().getProperty("SAKAI:conditionEventState");
					valuesForBean.put("gradebookItem",s1+s2);
					valuesForBean.put("conditionalOptionSelected",notification.getProperties().getProperty(ConditionService.PROP_SELECTED_CONDITION_KEY));
					valuesForBean.put("conditionArgument",notification.getProperties().getProperty(ConditionService.PROP_CONDITIONAL_RELEASE_ARGUMENT));
				} 
			} catch (NotificationNotDefinedException e) {
				logger.info("Error:" + rb.getString("notification_load_error"));
				valuesForBean = null;
			}					
		
		Map<String,String> resourceSelections = conditionService.getEntitiesForServiceAndContext("gradebook", ToolManager.getCurrentPlacement().getContext());

		List<SelectItem> resourceSelectionsSelectItems = new ArrayList<SelectItem>();
		java.util.Set keys = resourceSelections.keySet();
		java.util.Iterator it = keys.iterator();
		int i=0;
		String key = "";
		String value = "";
		SelectItem option = null;
		
		while(it.hasNext()){
			
			key = (String) it.next();
			value = (String) resourceSelections.get(key);
		    option = new SelectItem(key, value);
			resourceSelectionsSelectItems.add(option);

			i++;
		}
		
		if(i==0)
			noGradebookItems = true;
		else
			noGradebookItems = false;
			
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

		List conditionSelectionsSelectItems = new ArrayList();
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
			NotificationEdit notificationToRemove = NotificationService.editNotification(oldNotificationId);
			NotificationService.removeNotification(notificationToRemove);
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
		}
	}
	
	public static void notifyCondition(String notificationId) {
		
		if (! conditionsEnabled()) {
			return;
		}
		Notification meleteNotification = null;
		if (notificationId != null && !"".equals(notificationId)) {
			try {
				meleteNotification = NotificationService.getNotification(notificationId);
			} catch (NotificationNotDefinedException e) {
				e.printStackTrace();
			}
		}
			
		if (meleteNotification != null) {
			String eventDataString = meleteNotification.getProperties().getProperty("SAKAI:conditionEventState");
			// event resource of the form: /gradebook/[gradebook id]/[assignment name]/[points possible]/[due date millis]/[is released]/[is included in course grade]/[has authz]
			String content = meleteNotification.getResourceFilter();
			if (content == null) content = "/gradebook/null/null";
			EventTrackingService.post(EventTrackingService.newEvent("cond+" + meleteNotification.getFunction(), content + eventDataString, true));
		}
		
	}

}