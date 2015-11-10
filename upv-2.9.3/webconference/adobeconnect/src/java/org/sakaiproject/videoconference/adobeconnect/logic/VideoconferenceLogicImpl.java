package org.sakaiproject.videoconference.adobeconnect.logic;

import java.text.SimpleDateFormat;
import org.sakaiproject.videoconference.api.external.ExternalLogic;
import org.sakaiproject.videoconference.api.logic.MessageList;
import org.sakaiproject.videoconference.api.model.VideoconferenceRoom;
import org.sakaiproject.videoconference.common.external.I18nService;
import org.sakaiproject.videoconference.common.logic.VideoconferenceLogicBaseImpl;


public class VideoconferenceLogicImpl extends VideoconferenceLogicBaseImpl {
   
	protected String createCalendarTitle(VideoconferenceRoom room)
	{
		return I18nService.getInstance().getMessage("calendar_title", new String[] {room.getName()});
	}
   
	protected String createCalendarDescription(VideoconferenceRoom room)
    {
	   SimpleDateFormat sdf = new SimpleDateFormat(I18nService.getInstance().getMessage("date_pattern"), I18nService.getInstance().getLocale());
	   sdf.setTimeZone(I18nService.getInstance().getTimeZone());
	   return I18nService.getInstance().getMessage("calendar_description_adobeconnect", new String[] {
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
	   SimpleDateFormat sdf = new SimpleDateFormat(I18nService.getInstance().getMessage("date_pattern"), I18nService.getInstance().getLocale());
	   sdf.setTimeZone(I18nService.getInstance().getTimeZone());
	   
	   String str_recurrence = "";
	   if(room.getRecurrenceCount() > 0)
		   str_recurrence = I18nService.getInstance().getMessage("announcement_recurrence", new String[] {
				   																			String.valueOf(room.getRecurrenceCount()),
				   																			I18nService.getInstance().getMessage("announcement_recurrence_"+room.getRecurrenceType())});
	   String str_calendar = "";
	   if(inCalendar)
		   str_calendar = I18nService.getInstance().getMessage("announcement_calendar");
	   
	   String str_room = "";
	   try{
		   str_room = serviceConnector.getRoomURL(room);
	   }catch(Exception e){
		   
	   }
	   
	   return I18nService.getInstance().getMessage("announcement_body_adobeconnect", new String[] {
			   																	room.getName(),
			   																	sdf.format(room.getStartDate()).toString(),
			   																	sdf.format(room.getEndDate()).toString(),
			   																	str_recurrence,
			   																	str_calendar,
			   																	str_room});
    }

   
	public String addRoom_(VideoconferenceRoom room, MessageList messageList)
	{
		try {
			   return serviceConnector.addRoom(room);
		   } catch (org.sakaiproject.videoconference.adobeconnect.exceptions.VideoconferenceExceptions.DuplicatedNameException dne) {
			   messageList.addMessageError(MessageList.ERR_DUPLICATED_NAME);
			   dne.printStackTrace();
			   return null;
		   }catch (Exception e) {
			   e.printStackTrace();
			   return "";			
		   }
	}

   
	public Boolean updateRoom_(VideoconferenceRoom room, MessageList messageList)
	{
		try {
			return serviceConnector.updateRoom(room);
		} catch (org.sakaiproject.videoconference.adobeconnect.exceptions.VideoconferenceExceptions.DuplicatedNameException dne) {
			dne.printStackTrace();
			messageList.addMessageError(MessageList.ERR_DUPLICATED_NAME);
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return false;		
		}
	}

   
   public String accessRoom(VideoconferenceRoom room)
   {
	   return serviceConnector.accesssRoom(room, externalLogic.getCurrentUser(), hasPermission(ExternalLogic.PER_CNN_MODERATE_ROOM));		
   }

   public boolean canSeeRoom(VideoconferenceRoom room)
   {
	   String userId = externalLogic.getCurrentUserId();
	   if(externalLogic.isUserAdmin(userId))
		   return true;

	   if(hasPermission(ExternalLogic.PER_CNN_SEE_ALL_ROOMS))
		   return true;

	   if(room.isAccessBySite())
		   return true;

	   if (externalLogic.isUserInGroup(userId,room.getGroupList()))
		   return true;

	   return room.getUserList().contains(userId);
   }
}
