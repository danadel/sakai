package org.sakaiproject.tool.assessment.facade;

import java.io.Serializable;

import org.sakaiproject.tool.assessment.data.dao.questionpool.QuestionPoolAccessData;

public class QuestionPoolDataFacade implements Serializable {

	private static final long serialVersionUID = 6263987648717107057L;
	
	private String agentDisplayName;
	private Long questionPoolId;
	private String agentId;
	private Long accessTypeId;
	private String role;
	
	public static final Long ACCESS_DENIED =  Long.valueOf(30);
	public static final Long READ_ONLY = Long.valueOf(31);
	public static final Long MODIFY = Long.valueOf(32);
	public static final Long READ_WRITE = Long.valueOf(33);
	public static final Long ADMIN = Long.valueOf(34);
	  
	public QuestionPoolDataFacade(QuestionPoolAccessData data) {
		this.questionPoolId = data.getQuestionPoolId();
		this.accessTypeId = data.getAccessTypeId();
		this.agentId = data.getAgentId();
		AgentFacade agent = new AgentFacade(this.agentId);
		this.agentDisplayName = agent.getDisplayName();
		this.role = agent.getRole();
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
	 * @return the questionPoolId
	 */
	public Long getQuestionPoolId() {
		return questionPoolId;
	}

	/**
	 * @param questionPoolId the questionPoolId to set
	 */
	public void setQuestionPoolId(Long questionPoolId) {
		this.questionPoolId = questionPoolId;
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
	 * @return the accessTypeId
	 */
	public Long getAccessTypeId() {
		return accessTypeId;
	}

	/**
	 * @param accessTypeId the accessTypeId to set
	 */
	public void setAccessTypeId(Long accessTypeId) {
		this.accessTypeId = accessTypeId;
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

	public boolean equals(Object questionPoolDataFacade){
	    boolean returnValue = false;
	    if (this == questionPoolDataFacade) returnValue = true;
	    
	    if (questionPoolDataFacade != null && questionPoolDataFacade.getClass()==this.getClass()) {
	    	QuestionPoolDataFacade qpi = (QuestionPoolDataFacade)questionPoolDataFacade;
	    	if ((this.getAgentId()).equals(qpi.getAgentId())
	    			&& (this.getQuestionPoolId()).equals(qpi.getQuestionPoolId()))
	        
	    		returnValue = true;
	    }
	    return returnValue;
	}
	  
}
