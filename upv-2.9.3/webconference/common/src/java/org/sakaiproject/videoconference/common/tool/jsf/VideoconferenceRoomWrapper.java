
package org.sakaiproject.videoconference.common.tool.jsf;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.sakaiproject.videoconference.api.model.VideoconferenceRoom;
import org.sakaiproject.videoconference.common.external.I18nService;


/**
 * This is a wrapper class which is required to get the interactions from the user
 */
public class VideoconferenceRoomWrapper {
	
	private VideoconferenceRoom room;
	private boolean canDelete; // can this item be deleted
	private boolean isSelected; // is this item selected by the user
	
	private boolean recurrence; // has recurrence
	
	private String dateStatus = null;
	private Date init_d;
	private Date end_d;
	private int session;
	
	private List<SelectItem> groupList_available = null;	
	private List<SelectItem> groupList_selected = null;
	private String serialized_groupList = "";
	private List<SelectItem> userList_available = null;
	private List<SelectItem> userList_selected = null;
	private String serialized_userList = "";
		
	/**
	 * Basic Constructor
	 */
	public VideoconferenceRoomWrapper() {
		this.room = new VideoconferenceRoom();
		
		groupList_available = new ArrayList<SelectItem>();
		groupList_selected = new ArrayList<SelectItem>();
		userList_available = new ArrayList<SelectItem>();
		userList_selected = new ArrayList<SelectItem>();
	}
	/**
	 * Constructor which accepts the object we are wrapping
	 * @param room the VideoconferenceRoom we are wrapping
	 */
	public VideoconferenceRoomWrapper(VideoconferenceRoom room, boolean recurrence) {
		this.room = room;
		this.recurrence = recurrence;		
		
		
		Date now = new Date();
		init_d = room.getStartDate();
		end_d = room.getEndDate();	
		session = 1;
		// MODIFICA UMU
		if (room.isActive()) room.setActive((now.compareTo(init_d) >= 0 && now.compareTo(end_d) <= 0));
		// FIN MODIFICA UMU
		if(now.compareTo(end_d) > 0)
		{
			Period p = getNextPeriod(new Period(init_d, end_d));
			init_d = p.getInit_date();
			end_d = p.getEnd_date();
			session = p.getSession()+1;
		}
	}

	/**
	 * Advanced getters
	 */
	public String getRecurrenceStyleClass()
	{
		if(!recurrence)
			return "hidden";
		return "";
	}
	
	public String getGroupsStyleClass()
	{
		if(room.isAccessBySite())
			return "hidden";
		return "block";
	}
	
	public String getStartDate()
	{				
		SimpleDateFormat sdf = new SimpleDateFormat(I18nService.getInstance().getMessage("date_pattern"));
		sdf.setTimeZone(I18nService.getInstance().getTimeZone());
		return sdf.format(init_d).toString();
	}
	
	public String getEndDate()
	{
		SimpleDateFormat sdf = new SimpleDateFormat(I18nService.getInstance().getMessage("date_pattern"));
		sdf.setTimeZone(I18nService.getInstance().getTimeZone());
		return sdf.format(end_d).toString();
	}
	
	public String getDateStatus()
	{
		Date now = new Date();
		dateStatus = I18nService.getInstance().getMessage("closed");
		if(now.compareTo(init_d) >= 0 && now.compareTo(end_d) <= 0)
			dateStatus = I18nService.getInstance().getMessage("opened");
		
		return dateStatus;
	}
	
	private Period getNextPeriod(Period p)
	{
		if(!recurrence)
			return p;
		
		Date now = new Date();
		//si la fecha todavia no ha pasado (normalmente esto nunca se cumplira)
		if(p.getEnd_date().compareTo(now) >= 0)
			return p;
		
		Calendar init_c = Calendar.getInstance();
		Calendar end_c = Calendar.getInstance();
		Date old_end_d;	
		
		init_c.setTime(p.getInit_date());
		end_c.setTime(p.getEnd_date());
		
		for(int i = 0; i < room.getRecurrenceCount(); i++)
		{	
			old_end_d = end_c.getTime();
			
			if(room.getRecurrenceType().equals("day"))
			{
				init_c.set(Calendar.DAY_OF_MONTH, init_c.get(Calendar.DAY_OF_MONTH)+1);
				end_c.set(Calendar.DAY_OF_MONTH, end_c.get(Calendar.DAY_OF_MONTH)+1);
			}
			else if(room.getRecurrenceType().equals("week"))
			{
				init_c.set(Calendar.DAY_OF_MONTH, init_c.get(Calendar.DAY_OF_MONTH)+7);
				end_c.set(Calendar.DAY_OF_MONTH, end_c.get(Calendar.DAY_OF_MONTH)+7);
			}
			else if(room.getRecurrenceType().equals("month"))
			{
				init_c.set(Calendar.MONTH, init_c.get(Calendar.MONTH)+1);
				end_c.set(Calendar.MONTH, end_c.get(Calendar.MONTH)+1);
			}
			else if(room.getRecurrenceType().equals("year"))
			{
				init_c.set(Calendar.YEAR, init_c.get(Calendar.YEAR)+1);
				end_c.set(Calendar.YEAR, end_c.get(Calendar.YEAR)+1);
			}						
			
			if((now.compareTo(end_c.getTime()) <= 0) && (now.compareTo(old_end_d) > 0))
			{
				p.setInit_date(init_c.getTime());
				p.setEnd_date(end_c.getTime());
				p.setSession(i+1);
				return p;
			}
				
		}
		
		p.setInit_date(init_c.getTime());
		p.setEnd_date(end_c.getTime());
		p.setSession(room.getRecurrenceCount());
		
		return p;
	}
	
	/**
	 * Basic setters and getters
	 */
	public VideoconferenceRoom getRoom() {
		return room;
	}

	public void setRoom(VideoconferenceRoom room) {
		this.room = room;
	}

	public boolean isCanDelete() {
		return canDelete;
	}

	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	public boolean isRecurrence() {
		return recurrence;
	}

	public void setRecurrence(boolean recurrence) {
		this.recurrence = recurrence;
	}
	
	public int getSession() {
		return session;
	}
	
	public void setSession(int session) {
		this.session = session;
	}
	
	public List<SelectItem> getGroupList_available() {
		return groupList_available;
	}
	
	public void setGroupList_available(List<SelectItem> groupListAvailable) {
		groupList_available = groupListAvailable;
	}
	
	public List<SelectItem> getGroupList_selected() {
		return groupList_selected;
	}
	
	public void setGroupList_selected(List<SelectItem> groupListSelected) {
		groupList_selected = groupListSelected;
	}
	
	public List<SelectItem> getUserList_available() {
		return userList_available;
	}
	
	public void setUserList_available(List<SelectItem> userListAvailable) {
		userList_available = userListAvailable;
	}
	
	public List<SelectItem> getUserList_selected() {
		return userList_selected;
	}
	
	public void setUserList_selected(List<SelectItem> userListSelected) {
		userList_selected = userListSelected;
	}
	
	public void setSerialized_groupList(String serialized_groupList) {
		this.serialized_groupList = serialized_groupList;
	}
	
	public String getSerialized_groupList() {
		return serialized_groupList;
	}

	public void setSerialized_userList(String serialized_userList) {
		this.serialized_userList = serialized_userList;
	}
	
	public String getSerialized_userList() {
		return serialized_userList;
	}

	/**
	 * Private class to return multiple values
	 */
	private class Period
	{
		private Date init_date;			
		private Date end_date;
		private int session;
		
		public Period(Date initDate, Date endDate) {
			init_date = initDate;
			end_date = endDate;
			session = 0;
		}		

		public Date getInit_date() {
			return init_date;
		}
		public void setInit_date(Date initDate) {
			init_date = initDate;
		}
		public Date getEnd_date() {
			return end_date;
		}
		public void setEnd_date(Date endDate) {
			end_date = endDate;
		}
		public int getSession() {
			return session;
		}
		public void setSession(int session) {
			this.session = session;
		}		
	}

}
