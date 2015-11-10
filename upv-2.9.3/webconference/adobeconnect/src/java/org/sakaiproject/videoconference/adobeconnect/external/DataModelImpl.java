package org.sakaiproject.videoconference.adobeconnect.external;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.sakaiproject.db.api.SqlService;
import org.sakaiproject.db.api.SqlReader;

import org.sakaiproject.videoconference.api.external.DataModel;
import org.sakaiproject.videoconference.api.external.ExternalLogic;
import org.sakaiproject.videoconference.api.model.VideoconferenceRoom;

public class DataModelImpl implements DataModel 
{		
	private static final String SQL_TABLE = "vc_rooms_cnn";
	private static final String SQL_ROOMID = "room_id";
	private static final String SQL_SITEID = "site_id";
	private static final String SQL_STARTDATE = "start_date";
	private static final String SQL_ENDDATE = "end_date";
	private static final String SQL_RECURRENCETYPE = "recurrence_type";
	private static final String SQL_RECURRENCECOUNT = "recurrence_count";
	private static final String SQL_CALENDAREVENTID = "calendar_event_id";
	private static final String SQL_ANNOUNCEMENTID = "announcement_id";
	private static final String SQL_NOTIFICATEBYEMAIL = "notificate_by_email";
	private static final String SQL_ACCESSBYSITE = "access_by_site";
	
	private static final String SQL_GROUP_TABLE = "vc_groups_cnn";
	private static final String SQL_GROUPID = "group_id";
	
	private static final String SQL_USER_TABLE = "vc_users_cnn";
	private static final String SQL_USERID = "user_id";
	
	private static Log log = LogFactory.getLog(DataModelImpl.class);
	
	private SqlService sqlService;	
	public void setSqlService(SqlService sqlService) {
		this.sqlService = sqlService;
	}

	private ExternalLogic externalLogic;
	public void setExternalLogic(ExternalLogic externalLogic) {
		this.externalLogic = externalLogic;
	}
	
	/**
	 * init method
	 */
	public void init() 
	{		
		//auto-ddl
		if(Boolean.valueOf(externalLogic.getSakaiProperty(ExternalLogic.AUTODDL)))
		{
			try
			{
				sqlService.ddl(this.getClass().getClassLoader(), "sakai_videoconference_adobeconnect");				
			}
			catch(Exception e)
			{
				log.warn("Constructor -> "+e);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.adobeconnect.external.DataModel#getSiteRooms(java.lang.String)
	 */
	public List<VideoconferenceRoom> getSiteRooms(String siteId)
	{
		List<VideoconferenceRoom> ret;
		try
		{
			String sql = "SELECT * FROM "+SQL_TABLE+" WHERE "+SQL_SITEID+" = '"+siteId+"'";
			ret = sqlService.dbRead(sql,null,new VideoconferenceRoomReader());		
		}catch(Exception e){
			log.error("getSiteRooms -> "+e);
			ret = new ArrayList<VideoconferenceRoom>();
		}
		return ret;
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.adobeconnect.external.DataModel#addSiteRoom(org.sakaiproject.videoconference.adobeconnect.model.VideoconferenceRoom)
	 */
	public boolean addSiteRoom(VideoconferenceRoom room)
	{
		boolean ret;
		
		try
		{
			String sql = "INSERT INTO "+SQL_TABLE+"("+SQL_ROOMID+","
													+SQL_SITEID+","
													+SQL_STARTDATE+","
													+SQL_ENDDATE+","
													+SQL_RECURRENCETYPE+","
													+SQL_RECURRENCECOUNT+","
													+SQL_CALENDAREVENTID+","
													+SQL_ANNOUNCEMENTID+","
													+SQL_NOTIFICATEBYEMAIL+","
													+SQL_ACCESSBYSITE+") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			//Timestamp ts_start =   new Timestamp((room.getStartDate() != null) ? room.getStartDate().getTime() : 0);
			//Timestamp ts_end =   new Timestamp((room.getEndDate() != null) ? room.getEndDate().getTime() : 0);
			long l_start = (room.getStartDate() != null) ? room.getStartDate().getTime() : 0;
			long l_end = (room.getEndDate() != null) ? room.getEndDate().getTime() : 0;
			
			Object[] fields = new Object[10];
			fields[0] = room.getRoomId();
			fields[1] = room.getSiteId();
			fields[2] = l_start;
			fields[3] = l_end;
			fields[4] = room.getRecurrenceType();
			fields[5] = room.getRecurrenceCount();
			fields[6] = room.getCalendarId();
			fields[7] = room.getAnnouncementId();
			fields[8] = room.isSendEmail();
			fields[9] = room.isAccessBySite();	
			
			ret = sqlService.dbWrite(sql, fields);
			
			if(ret)
			{
				boolean aux1 = true;
				boolean aux2 = true;
				
				if(!room.isAccessBySite())
				{
					//anyadimos los grupos asociados
					if(room.getGroupList() != null && room.getGroupList().size() > 0)
					{													
						for(String g : room.getGroupList())
						{
							sql = "INSERT INTO "+SQL_GROUP_TABLE+"("+SQL_ROOMID+","													
																	+SQL_GROUPID+") VALUES ('"+room.getRoomId()+"','"+g+"')";
						
							aux1 = aux1 && sqlService.dbWrite(sql);
						}
					}
					
					//anyadimos los usuarios asociados
					if(room.getUserList() != null && room.getUserList().size() > 0)
					{					
						for(String u : room.getUserList())
						{
							sql = "INSERT INTO "+SQL_USER_TABLE+"("+SQL_ROOMID+","													
																	+SQL_USERID+") VALUES ('"+room.getRoomId()+"','"+u+"')";
						
							aux2 = aux2 && sqlService.dbWrite(sql);
						}
					}
				}
				
				ret = aux1 && aux2;
			}
		}catch(Exception e)
		{
			log.error("addSiteRoom -> "+e);
			ret = false;
		}
		
		return ret;
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.adobeconnect.external.DataModel#updateSiteRoom(org.sakaiproject.videoconference.adobeconnect.model.VideoconferenceRoom)
	 */
	public boolean updateSiteRoom(VideoconferenceRoom room)
	{
		boolean ret;
		
		try
		{
			String sql = "UPDATE "+SQL_TABLE+" SET "
												+SQL_STARTDATE+" = ?, "
												+SQL_ENDDATE+" = ?, "
												+SQL_RECURRENCETYPE+" = ?, "
												+SQL_RECURRENCECOUNT+" = ?, "
												+SQL_CALENDAREVENTID+" = ?, "
												+SQL_ANNOUNCEMENTID+" = ?, "
												+SQL_NOTIFICATEBYEMAIL+" = ?, "
												+SQL_ACCESSBYSITE+" = ? "
												+"WHERE "+SQL_ROOMID+" = ?";
			//Timestamp ts_start =   new Timestamp((room.getStartDate() != null) ? room.getStartDate().getTime() : 0);
			//Timestamp ts_end =   new Timestamp((room.getEndDate() != null) ? room.getEndDate().getTime() : 0);
			long l_start = (room.getStartDate() != null) ? room.getStartDate().getTime() : 0;
			long l_end = (room.getEndDate() != null) ? room.getEndDate().getTime() : 0;
			
			Object[] fields = new Object[9];
			fields[0] = l_start;
			fields[1] = l_end;
			fields[2] = room.getRecurrenceType();
			fields[3] = room.getRecurrenceCount();
			fields[4] = room.getCalendarId();
			fields[5] = room.getAnnouncementId();
			fields[6] = room.isSendEmail();
			fields[7] = room.isAccessBySite();	
			fields[8] = room.getRoomId();
			
			ret = sqlService.dbWrite(sql, fields);
			
			if(ret)
			{
				sql = "DELETE FROM "+SQL_GROUP_TABLE+" WHERE "+SQL_ROOMID+" = '"+room.getRoomId()+"'";
				boolean aux1 = sqlService.dbWrite(sql);
				
				sql = "DELETE FROM "+SQL_USER_TABLE+" WHERE "+SQL_ROOMID+" = '"+room.getRoomId()+"'";
				boolean aux2 = sqlService.dbWrite(sql);
				
				boolean aux3 = true;
				boolean aux4 = true;

				if(aux1 && aux2)
				{
					if(!room.isAccessBySite())
					{
						//anyadimos los grupos asociados
						if(room.getGroupList() != null && room.getGroupList().size() > 0)
						{													
							for(String g : room.getGroupList())
							{
								sql = "INSERT INTO "+SQL_GROUP_TABLE+"("+SQL_ROOMID+","													
																		+SQL_GROUPID+") VALUES ('"+room.getRoomId()+"','"+g+"')";
							
								aux3 = aux3 && sqlService.dbWrite(sql);
							}
						}
						
						//anyadimos los usuarios asociados
						if(room.getUserList() != null && room.getUserList().size() > 0)
						{					
							for(String u : room.getUserList())
							{
								sql = "INSERT INTO "+SQL_USER_TABLE+"("+SQL_ROOMID+","													
																		+SQL_USERID+") VALUES ('"+room.getRoomId()+"','"+u+"')";
							
								aux4 = aux4 && sqlService.dbWrite(sql);
							}
						}
					}
				}
				
				ret = aux1 && aux2 && aux3 && aux4;
			}
		}catch(Exception e)
		{
			log.error("updateSiteRoom -> "+e);
			ret = false;
		}
		
		return ret;
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.videoconference.adobeconnect.external.DataModel#deleteSiteRoom(org.sakaiproject.videoconference.adobeconnect.model.VideoconferenceRoom)
	 */
	public boolean deleteSiteRoom(VideoconferenceRoom room)
	{
		boolean ret;
		
		try
		{
			String sql = "DELETE FROM "+SQL_TABLE+" WHERE "+SQL_ROOMID+" = ?";
			
			Object[] fields = new Object[1];
			fields[0] = room.getRoomId();			
			
			ret = sqlService.dbWrite(sql, fields);
		}catch(Exception e)
		{
			log.error("deleteSiteRoom -> "+e);
			ret = false;
		}
		
		return ret;
	}
	
	public class VideoconferenceRoomReader implements SqlReader
	{
	    @SuppressWarnings("unchecked")
		public Object readSqlResultRecord(ResultSet result)
	    {
	    	VideoconferenceRoom ret;
	        try
	        {
				ret = new VideoconferenceRoom();
				ret.setRoomId(result.getString(SQL_ROOMID));
				ret.setSiteId(result.getString(SQL_SITEID));
				//ret.setStartDate(result.getTimestamp(SQL_STARTDATE));
				//ret.setEndDate(result.getTimestamp(SQL_ENDDATE));
				ret.setStartDate(new java.util.Date(result.getLong(SQL_STARTDATE)));
				ret.setEndDate(new java.util.Date(result.getLong(SQL_ENDDATE)));
				ret.setRecurrenceType(result.getString(SQL_RECURRENCETYPE));
				ret.setRecurrenceCount(result.getInt(SQL_RECURRENCECOUNT));
				String calendarId = result.getString(SQL_CALENDAREVENTID);
				ret.setCalendarId(calendarId);
				if(calendarId != null && !calendarId.equals(""))
					ret.setInCalendar(true);
				String announcementId = result.getString(SQL_ANNOUNCEMENTID);
				ret.setAnnouncementId(announcementId);
				if(announcementId != null && !announcementId.equals(""))
					ret.setInAnnouncements(true);
				ret.setSendEmail(result.getBoolean(SQL_NOTIFICATEBYEMAIL));
				ret.setAccessBySite(result.getBoolean(SQL_ACCESSBYSITE));
				
				String sql = "SELECT "+SQL_GROUPID+" FROM "+SQL_GROUP_TABLE+" WHERE "+SQL_ROOMID+" = '"+ret.getRoomId()+"'";
				List<String> l = sqlService.dbRead(sql);
				ret.setGroupList(l);
				
				sql = "SELECT "+SQL_USERID+" FROM "+SQL_USER_TABLE+" WHERE "+SQL_ROOMID+" = '"+ret.getRoomId()+"'";
				l = sqlService.dbRead(sql);
				ret.setUserList(l);
	        }
	        catch (Exception e)
	        {
	        	log.error("VideoconferenceRoomReader : readSqlResultRecord -> "+e);	        	
				e.printStackTrace();
				ret = null;
	        }	      
	        return ret;
	    }

	}

	public int getAndUpdateSequence() {
		return 0;
	}
}
