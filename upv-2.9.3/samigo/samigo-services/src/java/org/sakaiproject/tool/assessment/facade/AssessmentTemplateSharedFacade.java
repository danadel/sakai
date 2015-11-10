package org.sakaiproject.tool.assessment.facade;

import java.io.Serializable;

import org.sakaiproject.tool.assessment.data.dao.assessment.AssessmentTemplateSharedData;
import org.sakaiproject.tool.assessment.data.ifc.assessment.AssessmentTemplateSharedIfc;

public class AssessmentTemplateSharedFacade implements Serializable, AssessmentTemplateSharedIfc {

	private static final long serialVersionUID = 6263987648717107057L;
	
	private String agentDisplayName;
	private Long templateId;
	private String agentId;
	private String role;
	private AssessmentTemplateSharedData data;
	  
	public AssessmentTemplateSharedFacade(AssessmentTemplateSharedData data) {
		this.templateId = data.getTemplateId();
		this.agentId = data.getAgentId();
		AgentFacade agent = new AgentFacade(this.agentId);
		this.agentDisplayName = agent.getDisplayName();
		this.role = agent.getRole();
		this.data = data;
	}

	/**
	 * @return the agentDisplayName
	 */
	public String getAgentDisplayName() {
		return agentDisplayName;
	}

	/**
	 * @param agentDisplayName the agentDisplayName to set
	 */
	public void setAgentDisplayName(String agentDisplayName) {
		this.agentDisplayName = agentDisplayName;
	}

	/**
	 * @return the templateId
	 */
	public Long getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	/**
	 * @return the agentId
	 */
	public String getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	public AssessmentTemplateSharedData getData() {
		return data;
	}
	
	public void setData(AssessmentTemplateSharedData data) {
		this.data = data;
	}

	public boolean equals(Object assessmentTemplateSharedFacade){
	    boolean returnValue = false;
	    if (this == assessmentTemplateSharedFacade) returnValue = true;
	    
	    if (assessmentTemplateSharedFacade != null && assessmentTemplateSharedFacade.getClass()==this.getClass()) {
	    	AssessmentTemplateSharedFacade atf = (AssessmentTemplateSharedFacade)assessmentTemplateSharedFacade;
	    	if ((this.getAgentId()).equals(atf.getAgentId())
	    			&& (this.getTemplateId()).equals(atf.getTemplateId()))
	        
	    		returnValue = true;
	    }
	    return returnValue;
	}
	  
}
