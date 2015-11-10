package org.sakaiproject.videoconference.api.model;

public class VideoconferenceGroup {

	private String groupId;
	private String groupName;
	
	public VideoconferenceGroup(String groupId, String groupName) 
	{
		this.groupId = groupId;
		this.groupName = groupName;
	}
	
	public String getGroupId() {
		return groupId;
	}
	
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
