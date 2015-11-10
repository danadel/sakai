package org.sakaiproject.videoconference.common.logic;

import java.util.ArrayList;
import java.util.List;

import org.sakaiproject.site.api.Group;
import org.sakaiproject.user.api.User;

import org.sakaiproject.videoconference.api.external.DataModel;
import org.sakaiproject.videoconference.api.external.ExternalLogic;
import org.sakaiproject.videoconference.api.external.ServiceConnector;
import org.sakaiproject.videoconference.api.logic.MessageList;
import org.sakaiproject.videoconference.api.logic.VideoconferenceLogic;
import org.sakaiproject.videoconference.api.model.VideoconferenceGroup;
import org.sakaiproject.videoconference.api.model.VideoconferenceRoom;
import org.sakaiproject.videoconference.api.model.VideoconferenceRoomType;
import org.sakaiproject.videoconference.api.model.VideoconferenceUser;


public abstract class VideoconferenceLogicBaseImpl implements VideoconferenceLogic {

	protected ExternalLogic externalLogic;
	public void setExternalLogic(ExternalLogic externalLogic) {
		this.externalLogic = externalLogic;
	}

	protected DataModel dataModel;   
	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	protected ServiceConnector serviceConnector;
	public void setServiceConnector(ServiceConnector serviceConnector) {
		this.serviceConnector = serviceConnector;
	}

	public void init(){}

	protected abstract String createCalendarTitle(VideoconferenceRoom room);

	protected abstract String createCalendarDescription(VideoconferenceRoom room);

	protected abstract String createAnnouncementSubject(VideoconferenceRoom room);

	protected abstract String createAnnouncementBody(VideoconferenceRoom room, boolean inCalendar);

	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.VideoconferenceLogic#getAllVisibleRooms()
	 */
	public List<VideoconferenceRoom> getAllVisibleRooms() 
	{	  
		//obtenemos la lista de salas de la BD
		List<VideoconferenceRoom> roomList = dataModel.getSiteRooms(externalLogic.getCurrentSiteId());

		//rellenamos los datos de cada sala con la informacion de la plataforma de comunicaciones (openmeetings, adobeconnect, ...)
		serviceConnector.getRoomList(roomList);	  

		return roomList;	   	  
	}

	public abstract String addRoom_(VideoconferenceRoom room, MessageList messageList);

	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.VideoconferenceLogic#addRoom(org.sakaiproject.videoconference.api.model.VideoconferenceRoom, org.sakaiproject.videoconference.api.logic.MessageList)
	 */
	public void addRoom(VideoconferenceRoom room, MessageList messageList)
	{
		//inserto la sala en la plataforma de comunicaciones (openmeetings, adobeconnect, ...)
		String roomId = addRoom_(room, messageList);

		if(roomId != null)
		{
			if(!roomId.equals(""))
			{
				//si debemos insertar en el calendario
				String calendarId = "";
				if(room.isInCalendar())
				{
					String title = createCalendarTitle(room);
					String description = createCalendarDescription(room);
					calendarId = externalLogic.createCalendarEvent(room.getStartDate(), room.getEndDate(), room.getRecurrenceType(), room.getRecurrenceCount(), title, description);
					room.setCalendarId(calendarId);
	
					if(calendarId.equals(""))
						messageList.addMessageError(MessageList.ERR_ADD_CAL);
	
				}
	
				if(room.isInAnnouncements())
				{			
					//construimos el titulo del anucio
					String subject = createAnnouncementSubject(room);			
	
					//construimos el cuerpo del anucio
					String body = createAnnouncementBody(room, (!calendarId.equals("")));									
					String announcementId = externalLogic.createAnnouncementMessage(subject,body);
					room.setAnnouncementId(announcementId);
	
					if(announcementId.equals(""))
						messageList.addMessageError(MessageList.ERR_ADD_ANN);
				}
	
				if(room.isSendEmail())
				{
					//construimos el titulo del email (igual que el anucio)
					String subject = createAnnouncementSubject(room);			
	
					//construimos el cuerpo del email (igual que el anucio)
					String body = createAnnouncementBody(room, (!calendarId.equals("")));
	
					externalLogic.sendEmail_siteUsers(subject, body);
				}
	
				//si todo ha ido bien, insertamos en la BD
				room.setRoomId(roomId);
				room.setSiteId(externalLogic.getCurrentSiteId());
				if(!dataModel.addSiteRoom(room))
					messageList.addMessageError(MessageList.ERR_DB);
			}
			else
				messageList.addMessageError(MessageList.ERR_VC);
		}
	}

	public abstract Boolean updateRoom_(VideoconferenceRoom room, MessageList messageList);
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.VideoconferenceLogic#updateRoom(org.sakaiproject.videoconference.api.model.VideoconferenceRoom, org.sakaiproject.videoconference.api.logic.MessageList)
	 */
	public void updateRoom(VideoconferenceRoom room, MessageList messageList)
	{			
		Boolean res = updateRoom_(room, messageList);

		if(res != null)
		{
			if(res)
			{			
				res = true;
				String calendarId = (room.isInCalendar()) ? "true" : "";
				//si debe aparecer en el calendario
				if(room.isInCalendar())
				{
					String title = createCalendarTitle(room);
					String description = createCalendarDescription(room);
	
					//si antes no existia
					if(room.getCalendarId() == null)					
					{
						//creamos un nuevo evento
						calendarId = externalLogic.createCalendarEvent(room.getStartDate(), room.getEndDate(), room.getRecurrenceType(), room.getRecurrenceCount(), title, description);
						room.setCalendarId(calendarId);
					}
					else //si antes existia -> lo actulizamos
						res = externalLogic.updateCalendarEvent(room.getCalendarId(), room.getStartDate(), room.getEndDate(), room.getRecurrenceType(), room.getRecurrenceCount(), title, description);
				}else if(room.getCalendarId() != null) //si no debe aparecer y antes existia
				{
					//lo borramos
					res = externalLogic.deleteCalendarEvent(room.getCalendarId());
					room.setCalendarId(null);
				}
	
				if(!res)
					messageList.addMessageError(MessageList.ERR_UPD_CAL);
	
				res = true;
				//si debe aparecer en los anuncios
				if(room.isInAnnouncements())
				{
					//construimos el titulo del anucio
					String subject = createAnnouncementSubject(room);			
	
					//construimos el cuerpo del anucio
					String body = createAnnouncementBody(room, (!calendarId.equals("")));	
	
					//si antes no existia
					if(room.getAnnouncementId() == null)
					{
						//lo creamos
						String announcementId = externalLogic.createAnnouncementMessage(subject,body);				
						room.setAnnouncementId(announcementId);
					}
					else //si antes existia -> lo actulizamos
						res = externalLogic.updateAnnouncementMessage(room.getAnnouncementId(), subject, body);					
				}
				else if(room.getAnnouncementId() != null) //si no debe aparecer y antes existia
				{
					//lo borramos
					res = externalLogic.deleteAnnouncementMessage(room.getAnnouncementId());
					room.setAnnouncementId(null);
				}
	
				if(!res)
					messageList.addMessageError(MessageList.ERR_UPD_ANN);
	
				if(room.isSendEmail())
				{
					//construimos el titulo del email (igual que el anucio)
					String subject = createAnnouncementSubject(room);			
	
					//construimos el cuerpo del email (igual que el anucio)
					String body = createAnnouncementBody(room, (!calendarId.equals("")));
	
					externalLogic.sendEmail_siteUsers(subject, body);
				}
	
				if(!dataModel.updateSiteRoom(room))
					messageList.addMessageError(MessageList.ERR_DB);
			}
			else
				messageList.addMessageError(MessageList.ERR_VC);
		}
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.VideoconferenceLogic#deleteRooms(java.util.List, org.sakaiproject.videoconference.api.logic.MessageList)
	 */
	public void deleteRooms(List<VideoconferenceRoom> rooms, MessageList messageList) 
	{
		boolean res = serviceConnector.deleteRooms(rooms);
		boolean calendar_ok = true;
		boolean announcements_ok = true;
		boolean db_ok = true;

		for(VideoconferenceRoom room : rooms)
		{	
			//si se ha borrado correctamente del servidor de videoconferencias
			if(!room.isActive())
			{
				//borramos el evento del calendario
				calendar_ok = calendar_ok && externalLogic.deleteCalendarEvent(room.getCalendarId());
				room.setCalendarId(null);

				//borramos el evento de los anuncios
				announcements_ok = announcements_ok && externalLogic.deleteAnnouncementMessage(room.getAnnouncementId());
				room.setAnnouncementId(null);

				//borramos los datos de la BD
				db_ok = db_ok && dataModel.deleteSiteRoom(room);					
			}
		}

		if(!calendar_ok)
			messageList.addMessageError(MessageList.ERR_DEL_CAL);

		if(!announcements_ok)
			messageList.addMessageError(MessageList.ERR_DEL_ANN);

		if(!db_ok)
			messageList.addMessageError(MessageList.ERR_DB);

		if(!res)
			messageList.addMessageError(MessageList.ERR_VC);
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.VideoconferenceLogic#accessRoom(org.sakaiproject.videoconference.api.model.VideoconferenceRoom)
	 */
	public abstract String accessRoom(VideoconferenceRoom room);
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.VideoconferenceLogic#getRoomTypes()
	 */
	public List<VideoconferenceRoomType> getRoomTypes()
	{
		return serviceConnector.getRoomTypes();
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.VideoconferenceLogic#getAvailableGroups()
	 */
	public List<VideoconferenceGroup> getAvailableGroups()
	{
		List<VideoconferenceGroup> ret = new ArrayList<VideoconferenceGroup>();
		for(Group g : externalLogic.getSiteGroups())
			ret.add(new VideoconferenceGroup(g.getId(), g.getTitle()));
		return ret;
	}	

	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.VideoconferenceLogic#hasAvailableGroups()
	 */
	public boolean hasAvailableGroups()
	{
		return externalLogic.hasSiteGroups();
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.VideoconferenceLogic#getAvailableUsers()
	 */
	public List<VideoconferenceUser> getAvailableUsers()
	{
		List<VideoconferenceUser> ret = new ArrayList<VideoconferenceUser>();
		for(User u : externalLogic.getSiteUsers())
			ret.add(new VideoconferenceUser(u.getId(), u.getLastName()+", "+u.getFirstName()));
		return ret;
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.VideoconferenceLogic#hasPermission(java.lang.String)
	 */
	public boolean hasPermission(String permission)
	{
		return externalLogic.isUserAllowedInLocation(externalLogic.getCurrentUserId(), permission, externalLogic.getCurrentLocationId());
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.VideoconferenceLogic#canSeeRoom(org.sakaiproject.videoconference.api.model.VideoconferenceRoom)
	 */
	public abstract boolean canSeeRoom(VideoconferenceRoom room);	

	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.VideoconferenceLogic#pingServer()
	 */
	public boolean pingServer()
	{
		return serviceConnector.pingServer();
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.VideoconferenceLogic#checkLogin()
	 */
	public boolean checkLogin()
	{		
		return serviceConnector.getSessionAndLogin();
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.VideoconferenceLogic#hasCalendar()
	 */
	public boolean hasCalendar()
	{
		return externalLogic.siteHasTool(externalLogic.getCurrentSiteId(), ExternalLogic.CALENDAR_TOOL);
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.logic.VideoconferenceLogic#hasAnnouncement()
	 */
	public boolean hasAnnouncement()
	{
		return externalLogic.siteHasTool(externalLogic.getCurrentSiteId(), ExternalLogic.ANNOUNCEMENT_TOOL);
	}
}
