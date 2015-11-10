package org.sakaiproject.assignment.tool;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.assignment.api.Assignment;
import org.sakaiproject.assignment.api.AssignmentEdit;
import org.sakaiproject.assignment.cover.AssignmentService;
import org.sakaiproject.cheftool.Context;
import org.sakaiproject.cheftool.VelocityPortletPaneledAction;
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
import org.sakaiproject.event.api.SessionState;
import org.sakaiproject.event.cover.EventTrackingService;
import org.sakaiproject.event.cover.NotificationService;
import org.sakaiproject.exception.IdUnusedException;
import org.sakaiproject.exception.PermissionException;
import org.sakaiproject.service.gradebook.shared.AssessmentNotFoundException;
import org.sakaiproject.tool.cover.ToolManager;
import org.sakaiproject.util.ParameterParser;
import org.sakaiproject.util.ResourceLoader;
import org.sakaiproject.entity.api.ResourcePropertiesEdit;
import org.sakaiproject.entity.api.ResourceProperties;
import org.sakaiproject.service.gradebook.shared.GradebookService;

public class AssignmentConditionsHelper {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3875833398687224551L;

	static final Log logger = LogFactory.getLog(AssignmentConditionsHelper.class);
	
	static final ConditionService conditionService = (ConditionService)ComponentManager.get("org.sakaiproject.assignment.conditionalrelease.AssignmentConditionService");
	
	/** Resource bundle using current language locale */
    private static ResourceLoader rb = new ResourceLoader("assignment");
	
    static void saveCondition(ResourcePropertiesEdit aPropertiesEdit, String assignmentRef, ParameterParser params, SessionState state) {
    	//System.out.println("conditionsHelper.saveCondition(assignment:"+assignment+", params:"+params.getPath()+", state:"+state.getAttributeNames());
		if (! conditionsEnabled()) {
			return;
		}
		
		String useConditionalRelease = (String) aPropertiesEdit.getProperty(ConditionService.PROP_CONDITIONAL_RELEASE);
		String notificationId = (String) aPropertiesEdit.getProperty("notificationId");
		boolean useCR = false;
		if(useConditionalRelease !=null && useConditionalRelease.equals("true"))
			useCR = true;
		
		boolean cbSelected = Boolean.valueOf(params.get("cbCondition"));
		logger.debug("selected?? " + cbSelected);
		String selectedConditionValue = params.get("selectCondition");
		if (selectedConditionValue == null) return;
		logger.debug("Selected condition value: " + selectedConditionValue);
		//The selectCondition value must be broken up so we can get at the values
		//that make up the index, submittedFunctionName, missingTermQuery, and operatorValue in that order
		String[] conditionTokens = selectedConditionValue.split("\\|");
		int selectedIndex = Integer.valueOf(conditionTokens[0]);
		String submittedFunctionName = conditionTokens[1];
		String missingTermQuery = conditionTokens[2];
		String operatorValue = conditionTokens[3];
		logger.debug("submittedFunctionName: " + submittedFunctionName);
		logger.debug("missingTermQuery: " + missingTermQuery);
		logger.debug("operatorValue: " + operatorValue);			
		String submittedResourceFilter = params.get("selectResource");
		// the number of grade points are tagging along for the ride. chop this off.
		String[] resourceTokens = submittedResourceFilter.split("/");
		String assignmentPointsString = resourceTokens[4];
		submittedResourceFilter = "/" + resourceTokens[1] + "/" + resourceTokens[2] + "/" + resourceTokens[3];
		String additionalAssignmentInfo = "/" + resourceTokens[4] + "/" + resourceTokens[5] + "/" + resourceTokens[6] + "/" + resourceTokens[7];
		logger.debug("submittassignment.getProperties().get(ConditionService.PROP_CONDITIONAL_RELEASE)edResourceFilter: " + submittedResourceFilter);
		String eventDataClass = conditionService.getClassNameForEvent(submittedFunctionName);
		Object argument = null;
		if ((selectedIndex == 1) || (selectedIndex == 2)) {
			argument = "dateMillis:"+resourceTokens[5];
		}
		if ((selectedIndex == 9) || (selectedIndex == 10)) {
			try {
				argument = Double.valueOf(params.get("assignment_grade"));
			} catch (NumberFormatException e) {
				VelocityPortletPaneledAction.addAlert(state, rb.getString("conditions.invalid.condition.argument"));
				return;
			}
			double assignmentPoints = 0;
			try {
				assignmentPoints = new Double(assignmentPointsString);
			} catch (NumberFormatException e) {
				return;
			}
			if (((Double)argument < 0) || ((Double)argument > assignmentPoints)) {
			    VelocityPortletPaneledAction.addAlert(state, rb.getFormattedMessage("conditions.condition.argument.outofrange", new String[] { assignmentPointsString }));
				return;
			}
			logger.debug("argument: " + argument);
		}

		if (cbSelected) {
			if (useCR) {
				logger.debug("Previous condition exists. Removing related notification");
				removeExistingNotification(notificationId);
			}
			
			String resourceId = assignmentRef;

			List<Condition> predicates = new ArrayList();
			Condition resourcePredicate = conditionService.makeBooleanExpression(eventDataClass, missingTermQuery, operatorValue, argument);
			
			predicates.add(resourcePredicate);
			
			Rule resourceConditionRule = conditionService.makeRule(resourceId, predicates, Rule.Conjunction.OR);
			NotificationEdit notification = NotificationService.addNotification();
			notification.addFunction(submittedFunctionName);
			notification.addFunction("cond+" + submittedFunctionName);
			notification.setResourceFilter(submittedResourceFilter);
			if (missingTermQuery.contains("Date")) {
				notification.addFunction("datetime.update");
				notification.setResourceFilter(null);
			}
			notification.setAction(resourceConditionRule);
			notification.getProperties().addProperty(ConditionService.PROP_SUBMITTED_FUNCTION_NAME, submittedFunctionName);
			notification.getProperties().addProperty(ConditionService.PROP_SUBMITTED_RESOURCE_FILTER, submittedResourceFilter);
			notification.getProperties().addProperty(ConditionService.PROP_SELECTED_CONDITION_KEY, selectedConditionValue);
			notification.getProperties().addProperty(ConditionService.PROP_CONDITIONAL_RELEASE_ARGUMENT, params.get("assignment_grade"));
			notification.getProperties().addProperty("SAKAI:conditionEventState", additionalAssignmentInfo);
			
			notification.getProperties().addProperty("AssociatedTool","sakai.assignment.grades");
			notification.getProperties().addProperty("AssociatedItem", rb.getString("assignment.title") + " " + (String) state.getAttribute("new_assignment_title"));
			
			NotificationService.commitEdit(notification);
			
			aPropertiesEdit.addProperty(ConditionService.PROP_CONDITIONAL_RELEASE, "true");
			aPropertiesEdit.addProperty("notificationId", notification.getId());
			
			logger.debug("new notification: " + notification.getId());
		} else {
			//only remove the condition if it previously existed
			if (useCR) {
				aPropertiesEdit.removeProperty("notificationId");
				aPropertiesEdit.removeProperty(ConditionService.PROP_CONDITIONAL_RELEASE);
				aPropertiesEdit.removeProperty("resource.satisfies.rule");
				aPropertiesEdit.removeProperty("conditional.access.list");
				removeExistingNotification(notificationId);
			}			
		}
		
	}

	
	private static boolean conditionsEnabled() {
		return ServerConfigurationService.getBoolean("conditions.service.enabled", Boolean.FALSE)
			&& conditionService != null && !conditionService.getRegisteredServiceNames().isEmpty();
	}


	void loadConditionData(SessionState state) {
		//System.out.println("loadConditionData .. conditions enabled?"+conditionsEnabled());
		if (! conditionsEnabled()) {
			return;
		}
		logger.debug("Loading condition data");

		String editingAssignmentId = (String) state.getAttribute("edit_assignment_id");
		Assignment assignment = null;
		try {
			if(editingAssignmentId!=null)
				assignment = AssignmentService.getAssignment(editingAssignmentId);
			else{
				state.setAttribute("submitted_function_name", null);
				state.setAttribute("submitted_resource_filter", null);
				state.setAttribute("selected_condition_key", null);
				state.setAttribute("condition_argument", null);
				state.setAttribute("use_conditional_release",null);
				state.setAttribute("cbCondition",false);	
			}
		} catch (Exception e) {
			logger.debug("Exception on loadConditonData");
		}
		if( assignment!=null ){
			state.setAttribute("use_conditional_release",assignment.getProperties().get(ConditionService.PROP_CONDITIONAL_RELEASE));
						
			String aux = (String) assignment.getProperties().get(ConditionService.PROP_CONDITIONAL_RELEASE);
			boolean baux = false;
			if(aux!=null && aux.equals("true")) 
				baux = true;
			if (baux==true){
				try {
					Notification notification = NotificationService.getNotification((String)assignment.getProperties().get("notificationId"));						
					logger.debug("voy a cargar la notificacion " + notification.getId());
					if (notification != null) {					
						state.setAttribute("submitted_function_name", notification.getProperties().getProperty(ConditionService.PROP_SUBMITTED_FUNCTION_NAME));
						//System.out.println("submitted_function_name ="+notification.getProperties().getProperty(ConditionService.PROP_SUBMITTED_FUNCTION_NAME));
						state.setAttribute("submitted_resource_filter", notification.getProperties().getProperty(ConditionService.PROP_SUBMITTED_RESOURCE_FILTER));
						//System.out.println("submitted_resource_filter ="+notification.getProperties().getProperty(ConditionService.PROP_SUBMITTED_RESOURCE_FILTER));
						state.setAttribute("selected_condition_key", notification.getProperties().getProperty(ConditionService.PROP_SELECTED_CONDITION_KEY));
						//System.out.println("selected_condition_key ="+notification.getProperties().getProperty(ConditionService.PROP_SELECTED_CONDITION_KEY));
						state.setAttribute("condition_argument", notification.getProperties().getProperty(ConditionService.PROP_CONDITIONAL_RELEASE_ARGUMENT));
						//System.out.println("condition_argument ="+notification.getProperties().getProperty(ConditionService.PROP_CONDITIONAL_RELEASE_ARGUMENT));
					}
				} catch (NotificationNotDefinedException e) {
					VelocityPortletPaneledAction.addAlert(state, rb.getString("notification.load.error"));								
				}
			}
		}
		
		
		Map<String,String> resourceSelections = conditionService.getEntitiesForServiceAndContext("gradebook", ToolManager.getCurrentPlacement().getContext());
		
		//TODO look this data up
		//Using LinkedHashMap to maintain order
		Map<String,String> conditionSelections = new LinkedHashMap<String,String>();
		/*conditionSelections.put("1|gradebook.updateAssignment|dueDateHasPassed|no_operator",rb.getString("conditional.duedate_passed"));
		conditionSelections.put("2|gradebook.updateAssignment|dueDateHasNotPassed|no_operator",rb.getString("conditional.duedate_notpassed"));
		conditionSelections.put("3|gradebook.updateAssignment|isReleasedToStudents|no_operator",rb.getString("conditional.released_to_students"));
		conditionSelections.put("4|gradebook.updateAssignment|isNotReleasedToStudents|no_operator",rb.getString("conditional.not_released_to_students"));
		conditionSelections.put("5|gradebook.updateAssignment|isIncludedInCourseGrade|no_operator",rb.getString("conditional.included_in_course_grade"));
		conditionSelections.put("6|gradebook.updateAssignment|isNotIncludedInCourseGrade|no_operator",rb.getString("conditional.not_included_in_course_grade"));*/
		conditionSelections.put("7|gradebook.updateItemScore|isScoreBlank|no_operator", rb.getString("conditional.grade_blank"));
		conditionSelections.put("8|gradebook.updateItemScore|isScoreNonBlank|no_operator", rb.getString("conditional.grade_non_blank"));
		conditionSelections.put("9|gradebook.updateItemScore|getScore|less_than",rb.getString("conditional.grade_less_than"));
		conditionSelections.put("10|gradebook.updateItemScore|getScore|greater_than_equal_to",rb.getString("conditional.grade_greather_or_equal"));	
		
		//This isn't the final resting place for this data..see the buildReviseMetadataContext method in this class
		state.setAttribute("resourceSelections", resourceSelections);
		state.setAttribute("conditionSelections", conditionSelections);
		/*if (assignment != null) { 
			state.setAttribute("conditionArgument", item.getConditionArgument());			
		}*/
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
			logger.error("Error: " + rb.getString("conditions.disable.error"));
			//VelocityPortletPaneledAction.addAlert(state, );				
		} catch (NotificationNotDefinedException e) {
			//VelocityPortletPaneledAction.addAlert(state, rb.getString("conditions.disable.error"));								
			logger.error("Error: " + rb.getString("conditions.disable.error"));
		}		
	}
	
	public static void notifyCondition(String notificationId) {
		System.out.println(" ----------------- AssignmentConditionsHelper.notifyCondition ------------");
		if (! conditionsEnabled()) {
			return;
		}
		Notification assignmentNotification = null;
		if (notificationId != null && !"".equals(notificationId)) {
			try {
				assignmentNotification = NotificationService.getNotification(notificationId);
			} catch (NotificationNotDefinedException e) {
				logger.error("Error: " + e.getMessage());
			}
		}
			
		if (assignmentNotification != null) {
			String eventDataString = assignmentNotification.getProperties().getProperty("SAKAI:conditionEventState");
			// event resource of the form: /gradebook/[gradebook id]/[assignment name]/[points possible]/[due date millis]/[is released]/[is included in course grade]/[has authz]
			String assignment = assignmentNotification.getResourceFilter();
			System.out.println("	> assignment: " + assignment);
			if (assignment == null) assignment = "/gradebook/null/null";
			EventTrackingService.post(EventTrackingService.newEvent("cond+" + assignmentNotification.getFunction(), assignment + eventDataString, true));
		}
		
	}
	
	static void buildConditionContext(Context context, SessionState state) {
		if (! conditionsEnabled()) {
			context.put("conditions_enabled", Boolean.FALSE);
			return;
		}
		//logger.info("buildddd");//muchas veces entra...
		context.put("conditions_enabled", Boolean.TRUE);
		context.put("resourceSelections", state.getAttribute("resourceSelections"));
		context.put("conditionSelections", state.getAttribute("conditionSelections"));		
	}
	
	public void updateConditions(String contextString, Assignment sourceAsn){
		//Todas las tareas del site
		Iterator iAssignments = AssignmentService.getAssignmentsForContext(contextString);
		while (iAssignments.hasNext()){
			Assignment a = (Assignment) iAssignments.next();
			//Comprobamos si tiene CR configurada
			String useCR = (String) a.getProperties().get(ConditionService.PROP_CONDITIONAL_RELEASE);
			if ((useCR!=null) && (useCR.equals("true"))){
				//La tarea tiene configurada la CR
				try {
					//Cargamos la notificación
					Notification notification = NotificationService.getNotification((String)a.getProperties().get("notificationId"));
					if (notification != null) {
						String eventDataString = notification.getProperties().getProperty("SAKAI:conditionEventState");
						// event resource of the form: /gradebook/[gradebook id]/[assignment name]/[points possible]/[due date millis]/[is released]/[is included in course grade]/[has authz]
						String assignment = notification.getResourceFilter();
						if (assignment == null) assignment = "/gradebook/null/null";
						String[] assignmentRefParts = assignment.split("/");						
						String gradebookItem = StringUtils.trimToNull(sourceAsn.getProperties().getProperty(AssignmentService.PROP_ASSIGNMENT_ASSOCIATE_GRADEBOOK_ASSIGNMENT));
						Long itemGB = getGradebookItemId(gradebookItem,contextString);
						Long parsedGB = Long.parseLong(assignmentRefParts[3]);
						if (itemGB != null && itemGB.equals(parsedGB)){	
							notifyCondition(notification.getId());
						}
					}
					
				} catch (NotificationNotDefinedException e) {
					e.printStackTrace();
				}
				
			}
			
			
		}		
	}
	private Long getGradebookItemId(String name, String gradebookUid){
		GradebookService g = (GradebookService) ComponentManager.get("org.sakaiproject.service.gradebook.GradebookService");
		Long itemGB = null;
		try{
			List gradebookAssignments = g.getAssignments(gradebookUid);
			for (Iterator i=gradebookAssignments.iterator(); i.hasNext();){
				org.sakaiproject.service.gradebook.shared.Assignment gAssignment = (org.sakaiproject.service.gradebook.shared.Assignment) i.next();
				if (gAssignment.getName().equals(name)){
					itemGB = gAssignment.getId();
					break;
				}
			}

		}catch(Exception e){
			
		}
		return itemGB;
	}
	

}