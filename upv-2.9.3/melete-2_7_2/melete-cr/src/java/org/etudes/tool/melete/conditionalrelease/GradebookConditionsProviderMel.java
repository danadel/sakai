package org.etudes.tool.melete.conditionalrelease;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sakaiproject.conditions.api.ConditionProvider;
import org.sakaiproject.conditions.api.ConditionService;
import org.sakaiproject.service.gradebook.shared.Assignment;
import org.sakaiproject.service.gradebook.shared.GradebookService;

public class GradebookConditionsProviderMel implements ConditionProvider {
	
	private Map<String, String> eventLookup = new HashMap<String, String>();
	
	private ConditionService conditionService;
	public void setConditionService(ConditionService conditionService) {
		this.conditionService = conditionService;
	}
	
	private GradebookService gbs;
	public void setGradebookService(GradebookService gradebookService) {
		this.gbs = gradebookService;
	}
	
	public void init() {
		eventLookup.put("gradebook.updateItemScore", "org.etudes.tool.melete.conditionalrelease.AssignmentGrading");
		eventLookup.put("gradebook.updateAssignment", "org.etudes.tool.melete.conditionalrelease.AssignmentUpdate");
		conditionService.registerConditionProvider(this);
	}

	public Map<String, String> getEntitiesForContext(String gradebookUid) {

		Map<String, String> rv = new HashMap<String, String>();

		if (!gbs.isGradebookDefined(gradebookUid)) {
			return rv;
		}
		
		List<Assignment> assignments = gbs.getAssignments(gradebookUid);
		for (Assignment asn : assignments) {
			String assignmentName = asn.getName();
			Long assignmentId = asn.getId();
			String assignmentPoints = asn.getPoints().toString();
			boolean isReleasedToStudents = asn.isReleased();
			boolean isUsedInGradeCalculation = asn.isCounted();
			Date dueDate = asn.getDueDate();
			long dueDateMillis = 0;
			if (dueDate != null) dueDateMillis = dueDate.getTime();
			// event resource of the form: /gradebook/[gradebook id]/[assignment name]/[points possible]/[due date millis]/[is released]/[is included in course grade]/[has authz]
			rv.put("/gradebook/"+ gradebookUid + "/" + assignmentId + "/" + assignmentPoints + "/" + dueDateMillis + "/" + isReleasedToStudents + "/" + isUsedInGradeCalculation , assignmentName + " (" + assignmentPoints + " points)");
		}
		return rv;
	}

	public String getId() {
		return "gradebook";
	}

	public Map<String, String> getEventToDomainClassMapping() {
		return eventLookup;
	}

	public Map<String, String> getData(String type, String context) {
		Map<String, String> rv = new HashMap<String, String>();
		if ("grades".equals(type)) {
			String[] contextParts = context.split("\\|");
			String gradebookId = contextParts[0];
			String studentId = contextParts[2];
			Long assignmentId = Long.parseLong(contextParts[1]);
			rv.put("gradebookId", gradebookId);
			rv.put("studentId", studentId);
			rv.put("assignmentId", contextParts[1]);
			String score = gbs.getAssignmentScoreString(gradebookId, assignmentId, studentId);
			if (score == null) {
				score = "";
			}
			rv.put("score", score);
	  	}
 
		return rv;
 	}

	
}
