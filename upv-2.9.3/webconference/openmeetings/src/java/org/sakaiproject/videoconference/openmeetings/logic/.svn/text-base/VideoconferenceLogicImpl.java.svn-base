package org.sakaiproject.videoconference.openmeetings.logic;

import java.text.SimpleDateFormat;

import org.sakaiproject.videoconference.api.external.ExternalLogic;
import org.sakaiproject.videoconference.api.logic.MessageList;
import org.sakaiproject.videoconference.api.model.VideoconferenceRoom;
import org.sakaiproject.videoconference.common.external.I18nService;
import org.sakaiproject.videoconference.common.logic.VideoconferenceLogicBaseImpl;


public class VideoconferenceLogicImpl extends VideoconferenceLogicBaseImpl{
   
   protected String createCalendarTitle(VideoconferenceRoom room)
   {
	   return I18nService.getInstance().getMessage("calendar_title", new String[] {room.getName()});
   }
   
   protected String createCalendarDescription(VideoconferenceRoom room)
   {
	   SimpleDateFormat sdf = new SimpleDateFormat(I18nService.getInstance().getMessage("date_pattern"));
	   return I18nService.getInstance().getMessage("calendar_description_openmeetings", new String[] {
					   																room.getName(), 
					   																sdf.format(room.getStartDate()).toString(), 
					   																sdf.format(room.getEndDate()).toString()});
   }
   
   protected String createAnnouncementSubject(VideoconferenceRoom room)
   {
	   return I18nService.getInstance().getMessage("announcement_subject", new String[] {room.getName()});
   }
   
   protected String createAnnouncementBody(VideoconferenceRoom room, boolean inCalendar)
   {
	   SimpleDateFormat sdf = new SimpleDateFormat(I18nService.getInstance().getMessage("date_pattern")); 
	   
	   String str_recurrence = "";
	   if(room.getRecurrenceCount() > 0)
		   str_recurrence = I18nService.getInstance().getMessage("announcement_recurrence", new String[] {
				   																			String.valueOf(room.getRecurrenceCount()),
				   																			I18nService.getInstance().getMessage("announcement_recurrence_"+room.getRecurrenceType())});
	   String str_calendar = "";
	   if(inCalendar)
		   str_calendar = I18nService.getInstance().getMessage("announcement_calendar");
	   
	   return I18nService.getInstance().getMessage("announcement_body_openmeetings", new String[] {
			   																	room.getName(),
			   																	sdf.format(room.getStartDate()).toString(),
			   																	sdf.format(room.getEndDate()).toString(),
			   																	String.valueOf(room.getCapacity()),
			   																	str_recurrence,
			   																	str_calendar});
   }

   

   
	public String addRoom_(VideoconferenceRoom room, MessageList messageList)
	{
		try {
			return serviceConnector.addRoom(room);
		} catch (Exception e) {
			return "";
		}
	}
	
	public Boolean updateRoom_(VideoconferenceRoom room, MessageList messageList)
	{
		try {
			return serviceConnector.updateRoom(room);
		} catch (Exception e) {
			return false;
		}
	}
	
	public String accessRoom(VideoconferenceRoom room)
	{
		return serviceConnector.accesssRoom(room, externalLogic.getCurrentUser(), hasPermission(ExternalLogic.PER_OM_MODERATE_ROOM));		
	}
	
	public boolean canSeeRoom(VideoconferenceRoom room)
	{
		String userId = externalLogic.getCurrentUserId();
		if(externalLogic.isUserAdmin(userId))
			return true;

		if(hasPermission(ExternalLogic.PER_OM_SEE_ALL_ROOMS))
			return true;

		if(room.isAccessBySite())
			return true;

		if (externalLogic.isUserInGroup(userId,room.getGroupList()))
			return true;

		return room.getUserList().contains(userId);
	}
}
