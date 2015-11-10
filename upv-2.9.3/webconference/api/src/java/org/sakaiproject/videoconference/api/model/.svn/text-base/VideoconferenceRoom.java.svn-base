package org.sakaiproject.videoconference.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class VideoconferenceRoom {
	
	//tipos de sala en openmeetings
	public static final String OM_TYPE_CONFERENCE = "1";
	public static final String OM_TYPE_AUDIENCE = "2";
	public static final String OM_TYPE_RESTRICTED = "3";
	public static final String OM_TYPE_INTERVIEW = "4";

	private String roomId; // videoconference room id		
	private String siteId; //sakai site id		

	private String name;			
	private long capacity = 10;				
	private Date startDate;
	private Date endDate;
	private String recurrenceType = "day";
	private int recurrenceCount = 1;
	private boolean inCalendar;	
	private boolean inAnnouncements;
	private String type = "";
	private boolean sendEmail;
	
	private String calendarId = null;
	private String announcementId = null;
	
	private boolean accessBySite = true;
	private List<String> groupList = null;	
	private List<String> userList = null;
	
	private boolean isPublic = false;
	
	private boolean active = true;
	
	private String url;
	
	/**
	 * Default constructor
	 */
	public VideoconferenceRoom() 
	{
		startDate = new Date();
		endDate = new Date(startDate.getTime() + 3600000); //60*60*1000
		
		groupList = new ArrayList<String>();
		userList = new ArrayList<String>();
	}

	/**
	 * Getters and Setters
	 */
	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}	
	
	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
		
	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRecurrenceType() {
		return recurrenceType;
	}

	public void setRecurrenceType(String recurrenceType) {
		this.recurrenceType = recurrenceType;
	}

	public int getRecurrenceCount() {
		return recurrenceCount;
	}

	public void setRecurrenceCount(int recurrenceCount) {
		this.recurrenceCount = recurrenceCount;
	}
	public boolean isInCalendar() {
		return inCalendar;
	}

	public void setInCalendar(boolean inCalendar) {
		this.inCalendar = inCalendar;
	}

	public boolean isInAnnouncements() {
		return inAnnouncements;
	}

	public void setInAnnouncements(boolean inAnnouncements) {
		this.inAnnouncements = inAnnouncements;
	}

	public String getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(String calendarId) {
		this.calendarId = calendarId;
	}

	public String getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(String announcementId) {
		this.announcementId = announcementId;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isActive() {
		return active;
	}

	public void setSendEmail(boolean sendEmail) {
		this.sendEmail = sendEmail;
	}

	public boolean isSendEmail() {
		return sendEmail;
	}
	
	public List<String> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<String> groupList) {
		this.groupList = groupList;
	}

	public List<String> getUserList() {
		return userList;
	}

	public void setUserList(List<String> userList) {
		this.userList = userList;
	}

	public void setAccessBySite(boolean accessBySite) {
		this.accessBySite = accessBySite;
	}

	public boolean isAccessBySite() {
		return accessBySite;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public boolean isPublic() {
		return isPublic;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getUrl(){
		return this.url;
	}
	public void setUrl(String l){
		this.url = l;
	}	
}
