
package org.sakaiproject.videoconference.common.external;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.sakaiproject.authz.api.FunctionManager;
import org.sakaiproject.authz.api.SecurityService;
import org.sakaiproject.authz.api.AuthzGroupService;
import org.sakaiproject.tool.api.ToolManager;
import org.sakaiproject.tool.api.SessionManager;
import org.sakaiproject.component.api.ServerConfigurationService;

import org.sakaiproject.event.api.NotificationService;
import org.sakaiproject.exception.IdUnusedException;

import org.sakaiproject.site.api.Group;
import org.sakaiproject.site.api.Site;
import org.sakaiproject.site.api.SiteService;
import org.sakaiproject.user.api.User;
import org.sakaiproject.user.api.UserDirectoryService;
import org.sakaiproject.user.api.PreferencesService;
import org.sakaiproject.user.api.Preferences;
import org.sakaiproject.user.api.PreferencesEdit;
import org.sakaiproject.videoconference.api.external.ExternalLogic;
import org.sakaiproject.entity.api.ResourceProperties;
import org.sakaiproject.entity.api.ResourcePropertiesEdit;

import org.sakaiproject.calendar.api.Calendar;
import org.sakaiproject.calendar.api.CalendarEdit;
import org.sakaiproject.calendar.api.CalendarEventEdit;
import org.sakaiproject.calendar.api.CalendarService;
import org.sakaiproject.calendar.api.RecurrenceRule;
import org.sakaiproject.time.api.TimeService;
import org.sakaiproject.time.api.Time;
import org.sakaiproject.time.api.TimeRange;

import org.sakaiproject.announcement.api.AnnouncementMessageHeaderEdit;
import org.sakaiproject.announcement.api.AnnouncementService;
import org.sakaiproject.announcement.api.AnnouncementChannel;
import org.sakaiproject.announcement.api.AnnouncementMessageEdit;

import org.sakaiproject.email.api.EmailService;

 public abstract class ExternalLogicBaseImpl implements ExternalLogic
 {	 
	 private static Log log = LogFactory.getLog(ExternalLogicBaseImpl.class);
	 
	 protected FunctionManager functionManager = null;
	 protected ToolManager toolManager = null;
	 protected SecurityService securityService = null;
	 protected SessionManager sessionManager = null;
	 protected SiteService siteService = null;
	 protected ServerConfigurationService serverConfigurationService = null;
	 protected UserDirectoryService userDirectoryService = null;
	 protected PreferencesService preferencesService = null;
	 protected CalendarService calendarService = null;
	 protected TimeService timeService = null;
	 protected AnnouncementService announcementService = null;
	 protected AuthzGroupService authzGroupService = null;
	 protected EmailService emailService = null;
	 
	 public void setFunctionManager(FunctionManager functionManager) {
		 this.functionManager = functionManager;
	 }

	 public void setToolManager(ToolManager toolManager) {
		 this.toolManager = toolManager;
	 }

	 public void setSecurityService(SecurityService securityService) {
		 this.securityService = securityService;
	 }

	 public void setSessionManager(SessionManager sessionManager) {
		 this.sessionManager = sessionManager;
	 }

	 public void setSiteService(SiteService siteService) {
		 this.siteService = siteService;
	 }

	 public void setServerConfigurationService(
			 ServerConfigurationService serverConfigurationService) {
		 this.serverConfigurationService = serverConfigurationService;
	 }

	 public void setUserDirectoryService(UserDirectoryService userDirectoryService) {
		 this.userDirectoryService = userDirectoryService;
	 }

	 public void setPreferencesService(PreferencesService preferencesService) {
		 this.preferencesService = preferencesService;
	 }

	 public void setCalendarService(CalendarService calendarService) {
		 this.calendarService = calendarService;
	 }

	 public void setTimeService(TimeService timeService) {
		 this.timeService = timeService;
	 }

	 public void setAnnouncementService(AnnouncementService announcementService) {
		 this.announcementService = announcementService;
	 }

	 public void setAuthzGroupService(AuthzGroupService authzGroupService) {
		 this.authzGroupService = authzGroupService;
	 }

	 public void setEmailService(EmailService emailService) {
		 this.emailService = emailService;
	 }

	 public abstract void init();


	public ExternalLogicBaseImpl(){}		

	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#siteHasTool(java.lang.String, java.lang.String)
	 */
	public boolean siteHasTool(String siteId, String toolId) {
		boolean ret = false;
		try
		{
			Site s = siteService.getSite(siteId);
			if (s.getToolForCommonId(toolId) != null)
			{
				ret = true;
			}
		}
		catch (Exception e)
		{
			log.warn("siteHasTool: " + e.getMessage() + siteId);
		}
		return ret;
	}



	/*
	 * -------------------------------------------------------------------
	 * 						Sitios 
	 * -------------------------------------------------------------------
	 */
	
	/* 
	 * obtiene el location del sitio actual
	 */
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#getCurrentLocationId()
	 */
	public String getCurrentLocationId() {
      try {
         String context = toolManager.getCurrentPlacement().getContext();
         Site s = siteService.getSite( context );
         return s.getReference(); // get the entity reference to the site
      } catch (Exception e) {
         return null;
      }
   }
   
	/* 
	 * obtiene el identificador del sitio actual
	 */
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#getCurrentSiteId()
	 */
	public String getCurrentSiteId() {
		try {
			return toolManager.getCurrentPlacement().getContext();
		} catch (Exception e) {
			return null;
		}
	}

	/* 
	 * obtiene el nombre del sitio
	 */
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#getLocationTitle(java.lang.String)
	 */
	public String getLocationTitle(String locationId) {
	   String title = null;
		try {
			Site site = siteService.getSite(locationId);
			title = site.getTitle();
		} catch (IdUnusedException e) {
			log.warn("Cannot get the info about locationId: " + locationId);
			title = "----------";
		}
		return title;
	}
	
	/*
	 * -------------------------------------------------------------------
	 * 						Propiedades
	 * -------------------------------------------------------------------
	 */	
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#getSakaiProperty(java.lang.String)
	 */
	public String getSakaiProperty(String key)
	{
		try
		{
			return serverConfigurationService.getString(key);
		}catch(Exception e)
		{
			log.warn("getSakaiProperty -> "+e);
			return "";
		}
	}
	
	
	
	/*
	 * -------------------------------------------------------------------
	 * 						Usuarios 
	 * -------------------------------------------------------------------
	 */
	
	/* 
	 * obtiene el id del usuario actual
	 */
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#getCurrentUserId()
	 */
	public String getCurrentUserId() {
		return sessionManager.getCurrentSessionUserId();
	}
	
	/* 
	 * obtiene el usuario indicado
	 */
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#getUser(java.lang.String)
	 */
	public User getUser(String userId)
	{
		User user = null;
		try {
			user = userDirectoryService.getUser(userId);
		} catch (Exception e) {
			log.warn("Cannot get user for id: " + userId);
			user = null;
		}
		return user;
	}
	
	/* 
	 * obtiene el usuario actual
	 */
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#getCurrentUser()
	 */
	public User getCurrentUser()
	{
		return getUser(getCurrentUserId());
	}
	

	/* 
	 * obtiene el nombre del usuario indicado
	 */
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#getUserDisplayName(java.lang.String)
	 */
	public String getUserDisplayName(String userId) {
	   String name = null;
		try {
			name = userDirectoryService.getUser(userId).getDisplayName();
		} catch (Exception e) {
			log.warn("Cannot get user displayname for id: " + userId);
			name = "--------";
		}
		return name;
	}
	
	/* 
	 * obtiene el nombre del usuario actual
	 */
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#getCurrentUserName()
	 */
	public String getCurrentUserName()
	{
		return getUserDisplayName(getCurrentUserId());
	}		
	
	/* 
	 * obtiene la propiedad indicada del usuario indicado
	 */
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#getUserProperty(java.lang.String, java.lang.String)
	 */
	public String getUserProperty(String userId, String key)
	{
		String ret = "";
		try
		{
			Preferences preferences = preferencesService.getPreferences(userId);
			ResourceProperties properties = preferences.getProperties();
			
			if( properties != null)
				ret = properties.getProperty(key);
			
			if(ret == null)
				ret = "";
		}
		catch(Exception e)
		{
			log.warn("getCurrentUserProperty -> "+e);
		}
		
		return ret;
	}

	/* 
	 * establece la propiedad indicada del usuario indicado
	 */
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#setUserProperty(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void setUserProperty(String userId, String key, String value) 
	{
		PreferencesEdit preferences = null;
		try {
			try {
				preferences = preferencesService.edit(userId);
			} catch (Exception e1) {
				preferences = preferencesService.add(userId);
			}
				
			ResourcePropertiesEdit props = preferences.getPropertiesEdit();
			props.addProperty(key, value);
			preferencesService.commit(preferences);
		} catch (Exception e2)
		{
			log.warn("setUserPreference -> "+e2);
		}
	}

	/* 
	 * comprueba si el usuario es admin
	 */
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#isUserAdmin(java.lang.String)
	 */
	public boolean isUserAdmin(String userId) {
		return securityService.isSuperUser(userId);
	}

	/* 
	 * comprueba si el usuario indicado tiene permisos en el sitio marcado
	 */
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#isUserAllowedInLocation(java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean isUserAllowedInLocation(String userId, String permission, String locationId) {
		if ( securityService.unlock(userId, permission, locationId) ) {
			return true;
		}
		return false;
	}	
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#getSiteUsers()
	 */
	@SuppressWarnings("unchecked")
	public List<User> getSiteUsers()
	{
		List<User> ret = new ArrayList<User>();
		try 
		{
			Set<String> set = siteService.getSite(getCurrentSiteId()).getUsers();		
			
			for(String s : set)
			{
				try {
				ret.add(userDirectoryService.getUser(s));				
				} catch (Exception e) {
					log.warn("getSiteUsers (user: "+s+") -> "+e);
				}				
			}
		} catch (Exception e) {
			log.warn("getSiteUsers -> "+e);
		}
		
		return ret;
	}
	
	/*
	 * -------------------------------------------------------------------
	 * 						Calendario
	 * -------------------------------------------------------------------
	 */
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#getSiteCalendar()
	 */
	public Calendar getSiteCalendar() 
	{
		try 
        {
			if(!siteHasTool(getCurrentSiteId(), CALENDAR_TOOL))
				return null;
			
	        String siteId = getCurrentSiteId();
	        String calendarRef = calendarService.calendarReference(siteId, SiteService.MAIN_CONTAINER);
        
            return calendarService.getCalendar(calendarRef);
        } catch ( Exception e ) {
            return null;
        }
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#getSiteCalendarId()
	 */
	public String getSiteCalendarId() 
	{
		Calendar c = getSiteCalendar();
		if(c != null)
			return c.getReference();
		return "";
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#createCalendarEvent(java.util.Date, java.util.Date, java.lang.String, int, java.lang.String, java.lang.String)
	 */
	public String createCalendarEvent(Date initialTime, Date finalTime, String recurrence_type, int recurrence_count, String displayName, String description)
	{ 
	    int interval = 1; 
		
	    String calendarId = getSiteCalendarId();		

	    String ret = "";
	    if(calendarId != "")
	    {
	    	CalendarEdit calendarEdit = null;
		    try {  
		        //get calendar
		        calendarEdit = calendarService.editCalendar(calendarId);
		        
		        Time initialEventTime = timeService.newTime(initialTime.getTime());
		        Time finalEventTime = timeService.newTime(finalTime.getTime());
		            
		        TimeRange timeRange = timeService.newTimeRange(initialEventTime, finalEventTime, true, true);
		        
		        RecurrenceRule recurrence = calendarService.newRecurrence(recurrence_type,interval,recurrence_count+1);
		        
		        CalendarEventEdit cedit = calendarEdit.addEvent(); 
		        cedit.setRange(timeRange); 
		        cedit.setDisplayName(displayName); 
		        cedit.setDescription(description);  
		        cedit.setRecurrenceRule(recurrence); 
		        calendarEdit.commitEvent(cedit);         
		        calendarService.commitCalendar(calendarEdit);
		        
		        ret = cedit.getId();
		    } catch (Exception e) { 
		    	log.warn("createCalendarEvent(): error " + e.getClass().getName() + " : " + e.getMessage());
		    	if(calendarEdit != null)
		    		calendarService.cancelCalendar(calendarEdit);
		        ret = "";
		    }		    
	    }
	    return ret;
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#updateCalendarEvent(java.lang.String, java.util.Date, java.util.Date, java.lang.String, int, java.lang.String, java.lang.String)
	 */
	public boolean updateCalendarEvent(String eventId, Date initialTime, Date finalTime, String recurrence_type, int recurrence_count, String displayName, String description)
	{ 
	    int interval = 1; 
		
	    String calendarId = getSiteCalendarId();		

	    boolean ret = true;
	    if(calendarId != "")
	    {
	    	CalendarEdit calendarEdit = null;
		    try {  
		        //get calendar
		        calendarEdit = calendarService.editCalendar(calendarId);
		        
		        Time initialEventTime = timeService.newTime(initialTime.getTime());
		        Time finalEventTime = timeService.newTime(finalTime.getTime());
		            
		        TimeRange timeRange = timeService.newTimeRange(initialEventTime, finalEventTime, true, true);
		        
		        RecurrenceRule recurrence = calendarService.newRecurrence(recurrence_type,interval,recurrence_count+1);
		        
		        CalendarEventEdit cedit = calendarEdit.getEditEvent(eventId,CalendarService.EVENT_MODIFY_CALENDAR); 
		        cedit.setRange(timeRange); 
		        cedit.setDisplayName(displayName); 
		        cedit.setDescription(description);  
		        cedit.setRecurrenceRule(recurrence); 
		        calendarEdit.commitEvent(cedit);         
		        calendarService.commitCalendar(calendarEdit);
		    } catch (Exception e) { 
		    	log.warn("updateCalendarEvent(): error " + e.getClass().getName() + " : " + e.getMessage());
		    	if(calendarEdit != null)
		    		calendarService.cancelCalendar(calendarEdit);
		        ret = false;
		    }		    
	    }
	    return ret;
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#deleteCalendarEvent(java.lang.String)
	 */
	public boolean deleteCalendarEvent(String eventId)
	{
		boolean ret = true;
		
		if(eventId != null)
		{
			Calendar calendar = getSiteCalendar();		
	   
		    if(calendar != null)
		    {
		    	try
		    	{
			    	CalendarEventEdit calendarEvent = calendar.getEditEvent(eventId, CalendarService.EVENT_REMOVE_CALENDAR);
			    	calendar.removeEvent(calendarEvent);
			    	ret = true;
		    	}
		    	catch(Exception e)
		    	{
		    		log.warn("deleteCalendarEvent(): error " + e.getClass().getName() + " : " + e.getMessage());
		    		ret = false;
		    	}
		    }
		    else
		    	ret = false;
	    }	   
	    return ret;
	}
	
	/*
	 * -------------------------------------------------------------------
	 * 						Anuncios
	 * -------------------------------------------------------------------
	 */		
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#getSiteAnnouncementChannel()
	 */
	public AnnouncementChannel getSiteAnnouncementChannel() 
	{
		try 
        {
			if(!siteHasTool(getCurrentSiteId(), ANNOUNCEMENT_TOOL))
				return null;
			
	        String siteId = getCurrentSiteId();
	        String channelId = announcementService.channelReference(siteId, SiteService.MAIN_CONTAINER);
            return announcementService.getAnnouncementChannel(channelId);
        } catch ( Exception e ) {
            return null;
        }
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#createAnnouncementMessage(java.lang.String, java.lang.String)
	 */
	public String createAnnouncementMessage(String subject, String body)
	{		
		AnnouncementChannel channel = getSiteAnnouncementChannel();
		
		String ret = "";
		if(channel != null)
		{
			try 
			{ 									
				AnnouncementMessageEdit am = channel.addAnnouncementMessage();
				AnnouncementMessageHeaderEdit amh = am.getAnnouncementHeaderEdit();
				am.setBody(body);
				amh.setDraft(false);
				amh.setSubject(subject);
				
				channel.commitMessage(am, NotificationService.NOTI_NONE);
				
				ret = am.getId();			
			}catch(Exception e)
			{
				log.warn("createAnnouncementEvent -> "+e);
	    		ret = "";
			}
		}
		return ret;		
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#updateAnnouncementMessage(java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean updateAnnouncementMessage(String messageId, String subject, String body)
	{		
		boolean ret = true;
		if(messageId != null)
		{
			AnnouncementChannel channel = getSiteAnnouncementChannel();
			
			if(channel != null)
			{
				AnnouncementMessageEdit ame = null;
				try
				{
					ame = channel.editAnnouncementMessage(messageId);
					ame.setBody(body);
					ame.getAnnouncementHeaderEdit().setSubject(subject);
					channel.commitMessage(ame);
				}
				catch(Exception e)
				{
					log.warn("updateAnnouncementMessage -> "+e);
					if(ame != null)
						channel.cancelMessage(ame);
		    		ret = false;
				}
			}
			else
				ret = false;
		}
		return ret;
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#deleteAnnouncementMessage(java.lang.String)
	 */
	public boolean deleteAnnouncementMessage(String messageId)
	{		
		boolean ret = true;
		if(messageId != null)
		{
			AnnouncementChannel channel = getSiteAnnouncementChannel();							
			
			if(channel != null)
			{
				try 
				{ 		
					channel.removeAnnouncementMessage(messageId);					
				}catch(Exception e)
				{
					log.warn("deleteAnnouncementEvent -> "+e);
		    		ret = false;
				}
				
				if(ret)
				{
					try 
					{ 
						//en caso de que el anuncio este bloqueado (otro usuario esta accediendo a el) no podemos saber si ha habido algun error,
						//puesto que salta una excepcion en el hilo y no la podemos capturar.
						//por ello, comprobamos si el mensaje sigue existiendo despues de borrarlo						
						channel.getAnnouncementMessage(messageId);
					}catch(IdUnusedException e)
					{	
						//si salta esta excepcion es porque el mensaje no existe, que es lo que queremos
			    		ret = true;
					}
					catch(Exception e)
					{
						log.warn("deleteAnnouncementEvent -> "+e);
			    		ret = false;
					}
				}
			}
			else
				ret = false;
		}
		return ret;
	}
	
	/*
	 * -------------------------------------------------------------------
	 * 						Correos
	 * -------------------------------------------------------------------
	 */
	
	private List<String> getEmailHeaders(String subject)
	{
		List<String> ret = new ArrayList<String>();
		ret.add("Content-Type: text/plain");
		ret.add("Subject: "+subject);
		ret.add("From: " + "\"" + serverConfigurationService.getString("ui.service", "Sakai") + "\"<no-reply@"+ serverConfigurationService.getServerName() + ">");
		
		return ret;
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#sendEmail_siteUsers(java.lang.String, java.lang.String)
	 */
	public void sendEmail_siteUsers(String subject, String body)
	{
		emailService.sendToUsers(getSiteUsers(), getEmailHeaders(subject), body);
	}
	
	
	/*
	 * -------------------------------------------------------------------
	 * 						Grupos
	 * -------------------------------------------------------------------
	 */
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#getSiteGroups()
	 */
	@SuppressWarnings("unchecked")
	public List<Group> getSiteGroups()
	{
		ArrayList<Group> ret;
		try 
		{
			Site site = siteService.getSite(getCurrentSiteId());
			
			ret = new ArrayList<Group>(site.getGroups());				
		} catch (Exception e) {
			log.warn("getSiteGroups -> "+e);
			ret = new ArrayList<Group>();
		}
		
		return ret;
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#hasSiteGroups()
	 */
	public boolean hasSiteGroups()
	{
		try 
		{
			Site site = siteService.getSite(getCurrentSiteId());

			return !site.getGroups().isEmpty();				
		} catch (Exception e) {
			log.warn("hasSiteGroups -> "+e);
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.api.external.ExternalLogic#isUserInGroup(java.lang.String, java.util.List)
	 */
	public boolean isUserInGroup(String userId, List<String> list_groupId)
	{
		try 
		{
			
			String ref_o = "/site/"+getCurrentSiteId()+"/group/";
			for(String groupId : list_groupId)
			{
				String ref = ref_o + groupId;
								
				if(authzGroupService.getAuthzGroup(ref).getMember(userId) != null)
					return true;
			}
		} catch (Exception e) {
			log.warn("isUserInGroup -> "+e);
		}			

		return false;
	}
	
}
