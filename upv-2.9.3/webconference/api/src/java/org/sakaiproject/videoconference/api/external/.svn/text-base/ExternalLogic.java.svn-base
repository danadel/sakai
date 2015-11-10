package org.sakaiproject.videoconference.api.external;

import java.util.Date;
import java.util.List;

import org.sakaiproject.announcement.api.AnnouncementChannel;
import org.sakaiproject.calendar.api.Calendar;
import org.sakaiproject.site.api.Group;
import org.sakaiproject.user.api.User;

public interface ExternalLogic {

	 // connect permissions	
	 public final static String PER_CNN_CREATE_ROOM = "samoo.videoconference.connect.room.new";
	 public final static String PER_CNN_EDIT_ROOM = "samoo.videoconference.connect.room.edit";
	 public final static String PER_CNN_DELETE_ROOMS = "samoo.videoconference.connect.room.delete";
	 public final static String PER_CNN_ACCESS_ROOM = "samoo.videoconference.connect.room.access";
	 public final static String PER_CNN_MODERATE_ROOM = "samoo.videoconference.connect.room.moderate";
	 public final static String PER_CNN_SEE_ALL_ROOMS = "samoo.videoconference.connect.room.see_all";
	 public final static String PER_CNN_CHECK_CONNECTIVITY = "samoo.videoconference.connect.connectivity.check";	 

	 // connect sakai properties
	 public final static String VC_CNN_ADDRESS = "samoo.connect.url";
	 public final static String VC_CNN_USER = "samoo.connect.username";
	 public final static String VC_CNN_PASS = "samoo.connect.password";
	 
	// openmeetings permissions	
	 public final static String PER_OM_CREATE_ROOM = "samoo.videoconference.openmeetings.room.new";
	 public final static String PER_OM_EDIT_ROOM = "samoo.videoconference.openmeetings.room.edit";
	 public final static String PER_OM_DELETE_ROOMS = "samoo.videoconference.openmeetings.room.delete";
	 public final static String PER_OM_ACCESS_ROOM = "samoo.videoconference.openmeetings.room.access";
	 public final static String PER_OM_MODERATE_ROOM = "samoo.videoconference.openmeetings.room.moderate";
	 public final static String PER_OM_SEE_ALL_ROOMS = "samoo.videoconference.openmeetings.room.see_all";
	 public final static String PER_OM_CHECK_CONNECTIVITY = "samoo.videoconference.openmeetings.connectivity.check";	 

	 // openmeetings sakai properties
	 public final static String VC_OM_ADDRESS = "samoo.openmeetings.url";
	 public final static String VC_OM_USER = "samoo.openmeetings.username";
	 public final static String VC_OM_PASS = "samoo.openmeetings.password";
	 
	 public final static String AUTODDL = "auto.ddl";

	 //sakai tools
	 public final static String CALENDAR_TOOL = "sakai.schedule";
	 public final static String ANNOUNCEMENT_TOOL = "sakai.announcements";
	 
	/**
	 * whether the site has the specified tool
	 * @param toolId
	 *
	 * @return
	 */
	public abstract boolean siteHasTool(String siteId, String toolId);

	/* 
	 * obtiene el location del sitio actual
	 */
	public abstract String getCurrentLocationId();

	/* 
	 * obtiene el identificador del sitio actual
	 */
	public abstract String getCurrentSiteId();

	/* 
	 * obtiene el nombre del sitio
	 */
	public abstract String getLocationTitle(String locationId);

	public abstract String getSakaiProperty(String key);

	/* 
	 * obtiene el id del usuario actual
	 */
	public abstract String getCurrentUserId();

	/* 
	 * obtiene el usuario indicado
	 */
	public abstract User getUser(String userId);

	/* 
	 * obtiene el usuario actual
	 */
	public abstract User getCurrentUser();

	/* 
	 * obtiene el nombre del usuario indicado
	 */
	public abstract String getUserDisplayName(String userId);

	/* 
	 * obtiene el nombre del usuario actual
	 */
	public abstract String getCurrentUserName();

	/* 
	 * obtiene la propiedad indicada del usuario indicado
	 */
	public abstract String getUserProperty(String userId, String key);

	/* 
	 * establece la propiedad indicada del usuario indicado
	 */
	public abstract void setUserProperty(String userId, String key, String value);

	/* 
	 * comprueba si el usuario es admin
	 */
	public abstract boolean isUserAdmin(String userId);

	/* 
	 * comprueba si el usuario indicado tiene permisos en el sitio marcado
	 */
	public abstract boolean isUserAllowedInLocation(String userId,
			String permission, String locationId);

	@SuppressWarnings("unchecked")
	public abstract List<User> getSiteUsers();

	public abstract Calendar getSiteCalendar();

	public abstract String getSiteCalendarId();

	public abstract String createCalendarEvent(Date initialTime,
			Date finalTime, String recurrence_type, int recurrence_count,
			String displayName, String description);

	public abstract boolean updateCalendarEvent(String eventId,
			Date initialTime, Date finalTime, String recurrence_type,
			int recurrence_count, String displayName, String description);

	public abstract boolean deleteCalendarEvent(String eventId);

	/*
	 * -------------------------------------------------------------------
	 * 						Anuncios
	 * -------------------------------------------------------------------
	 */
	public abstract AnnouncementChannel getSiteAnnouncementChannel();

	public abstract String createAnnouncementMessage(String subject, String body);

	public abstract boolean updateAnnouncementMessage(String messageId,
			String subject, String body);

	public abstract boolean deleteAnnouncementMessage(String messageId);

	public abstract void sendEmail_siteUsers(String subject, String body);

	@SuppressWarnings("unchecked")
	public abstract List<Group> getSiteGroups();

	public abstract boolean hasSiteGroups();

	public abstract boolean isUserInGroup(String userId,
			List<String> list_groupId);

}