package org.sakaiproject.videoconference.openmeetings.tool.jsf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.faces.component.html.HtmlInputHidden;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.videoconference.api.external.ExternalLogic;
import org.sakaiproject.videoconference.api.logic.MessageList;
import org.sakaiproject.videoconference.api.logic.VideoconferenceLogic;
import org.sakaiproject.videoconference.api.model.VideoconferenceGroup;
import org.sakaiproject.videoconference.api.model.VideoconferenceRoom;
import org.sakaiproject.videoconference.api.model.VideoconferenceUser;
import org.sakaiproject.videoconference.common.external.I18nService;
import org.sakaiproject.videoconference.common.logic.MessageListImpl;
import org.sakaiproject.videoconference.common.tool.jsf.VideoconferenceRoomWrapper;

public class VideoconferenceBean {	

	private static Log log = LogFactory.getLog(VideoconferenceBean.class);

	private MessageList messageList;
	
	private VideoconferenceLogic videoconferenceLogic;	
	public void setVideoconferenceLogic(VideoconferenceLogic videoconferenceLogic) {
		this.videoconferenceLogic = videoconferenceLogic;
	}
	
	private VideoconferenceRoomWrapper currentRoom = null;	
	public VideoconferenceRoomWrapper getCurrentRoom() {
		return currentRoom;
	}
	public void setCurrentRoom(VideoconferenceRoomWrapper currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	private List<VideoconferenceRoom> confirmRoomList;
	
	private boolean isNew;
	
		
	public VideoconferenceBean() {
		messageList = new MessageListImpl();					
	}
	
	/*
	 * -------------------------------------------------------------------
	 * 						Metodos genericos
	 * -------------------------------------------------------------------
	 */
	public String getTimeZone()
	{
		return Calendar.getInstance().getTimeZone().getID();
	}	
	
	/*
	 * -------------------------------------------------------------------
	 * 						El listado de salas
	 * -------------------------------------------------------------------
	 */
	private DataModel roomsModel = null;
	private Boolean pingServer = null;
	private Boolean checkLogin = null;
	
	
	private void refreshWrapper_groups(VideoconferenceRoomWrapper wrapper)
	{
		refreshWrapper_groups(wrapper, videoconferenceLogic.getAvailableGroups());
	}
	
	private void refreshWrapper_groups(VideoconferenceRoomWrapper wrapper, List<VideoconferenceGroup> groups)
	{
		List<SelectItem> si_groups_available = new ArrayList<SelectItem>();
		List<SelectItem> si_groups_selected = new ArrayList<SelectItem>();
		//recorremos los grupos disponibles y comprobamos si tenemos alguno seleccionado
		for(VideoconferenceGroup g : groups)
		{
			if(wrapper.getRoom().getGroupList().contains(g.getGroupId()))
				si_groups_selected.add(new SelectItem(g.getGroupId(), g.getGroupName()));
			else
				si_groups_available.add(new SelectItem(g.getGroupId(), g.getGroupName()));
		}
		
		wrapper.setGroupList_available(si_groups_available);
		wrapper.setGroupList_selected(si_groups_selected);
	}
	
	private void refreshWrapper_users(VideoconferenceRoomWrapper wrapper)
	{
		refreshWrapper_users(wrapper, videoconferenceLogic.getAvailableUsers());
	}
	
	private void refreshWrapper_users(VideoconferenceRoomWrapper wrapper, List<VideoconferenceUser> users)
	{
		List<SelectItem> si_users_available = new ArrayList<SelectItem>();
		List<SelectItem> si_users_selected = new ArrayList<SelectItem>();
		//recorremos los usuarios disponibles y comprobamos si tenemos alguno seleccionado
		for(VideoconferenceUser u : users)
		{			
			if(wrapper.getRoom().getUserList().contains(u.getUserId()))
				si_users_selected.add(new SelectItem(u.getUserId(), u.getUserName()));
			else
				si_users_available.add(new SelectItem(u.getUserId(), u.getUserName()));
		}
		
		wrapper.setUserList_available(si_users_available);
		wrapper.setUserList_selected(si_users_selected);
	}
	
	public synchronized DataModel getRoomList()
	{
		List<VideoconferenceRoomWrapper> wrappedRooms = new ArrayList<VideoconferenceRoomWrapper>();

		List<VideoconferenceRoom> rooms = videoconferenceLogic.getAllVisibleRooms();
		List<VideoconferenceGroup> groups = videoconferenceLogic.getAvailableGroups();
		List<VideoconferenceUser> users = videoconferenceLogic.getAvailableUsers();
		
		for(VideoconferenceRoom room : rooms)
		{				
			if(videoconferenceLogic.canSeeRoom(room))
			{
			//anaydir permisos o efectos de visualizacion a la sala si son necesarios....
			boolean recurrence = (room.getRecurrenceCount() > 0);
			if(!recurrence)
			{
				room.setRecurrenceCount(1);
				room.setRecurrenceType("day");
			}
			
			VideoconferenceRoomWrapper wrapper = new VideoconferenceRoomWrapper(room, recurrence);				
			
				//refrescamos el wrapper con los grupos disponibles y los seleccionados
				refreshWrapper_groups(wrapper, groups);
				
				//refrescamos el wrapper con los grupos disponibles y los seleccionados
				refreshWrapper_users(wrapper, users);	
				
			wrappedRooms.add(wrapper);
		}
		}
		roomsModel = new ListDataModel(wrappedRooms);
		
		if(!isCheckLogin())
		{
			FacesContext fc = FacesContext.getCurrentInstance();
			String message = I18nService.getInstance().getMessage("server_connection_error");
			fc.addMessage("items", new FacesMessage(FacesMessage.SEVERITY_WARN, message, message));
		}
		return roomsModel;
	}
	
	public boolean getCanCreate()
	{
		return videoconferenceLogic.hasPermission(ExternalLogic.PER_OM_CREATE_ROOM);
	}
	
	public boolean getCanEdit()
	{
		return videoconferenceLogic.hasPermission(ExternalLogic.PER_OM_EDIT_ROOM);
	}
	
	public boolean getCanDelete()
	{
		return videoconferenceLogic.hasPermission(ExternalLogic.PER_OM_DELETE_ROOMS);
	}
	
	public boolean getCanAccess()
	{
		return videoconferenceLogic.hasPermission(ExternalLogic.PER_OM_ACCESS_ROOM);
	}
	
	public boolean getCanCheckConnectivity()
	{
		return videoconferenceLogic.hasPermission(ExternalLogic.PER_OM_CHECK_CONNECTIVITY);
	}
	
	public String processNewRoom() 
	{
		if(getCanCreate())
		{
			currentRoom = new VideoconferenceRoomWrapper();
			//establecemos el tipo por defecto
			currentRoom.getRoom().setType(VideoconferenceRoom.OM_TYPE_CONFERENCE);
						
			//buscamos los grupos disponibles
			List<VideoconferenceGroup> groups = videoconferenceLogic.getAvailableGroups();
			List<SelectItem> si_groups_available = new ArrayList<SelectItem>();
			for(VideoconferenceGroup g : groups)
				si_groups_available.add(new SelectItem(g.getGroupId(), g.getGroupName()));
			currentRoom.setGroupList_available(si_groups_available);
			
			//buscamos los usuarios disponibles
			List<VideoconferenceUser> users = videoconferenceLogic.getAvailableUsers();
			List<SelectItem> si_users_available = new ArrayList<SelectItem>();			
			for(VideoconferenceUser u : users)
				si_users_available.add(new SelectItem(u.getUserId(), u.getUserName()));
			currentRoom.setUserList_available(si_users_available);
			
			isNew = true;
			return "editRoom";
		}
		return "roomList";
	}
	
	public String processEditRoom() 
	{
		if(getCanEdit())
		{
			currentRoom = (VideoconferenceRoomWrapper) roomsModel.getRowData();
			isNew = false;
			return "editRoom";
		}
		return "roomList";
	}
	
	@SuppressWarnings("unchecked")
	public String processConfirmDeleteRooms()
	{
		if(getCanDelete())
		{
			confirmRoomList = new ArrayList<VideoconferenceRoom>();
			List<VideoconferenceRoomWrapper> wrappedRooms = (List<VideoconferenceRoomWrapper>)roomsModel.getWrappedData();
			
			for(VideoconferenceRoomWrapper wrappedRoom : wrappedRooms)
			{
				if(wrappedRoom.isSelected())
					confirmRoomList.add(wrappedRoom.getRoom());
			}
			
			return "confirmDeleteRooms";
		}
		return "roomList";
	}
	
	
	
	public String processAccessRoom()
	{
		if(getCanAccess())
		{
			currentRoom = (VideoconferenceRoomWrapper) roomsModel.getRowData();
			return "accessRoom";
		}
		return "roomList";
	}	
	
	public String processCheckStatus()
	{
		pingServer = null;
		checkLogin = null;
		return "checkStatus";
	}
	
	/*
	 * -------------------------------------------------------------------
	 * 						Confirmar borrado de salas
	 * -------------------------------------------------------------------
	 */
	
	public List<VideoconferenceRoom> getConfirmRoomList()
	{		
		return confirmRoomList;
	}
	
	public String processDeleteRooms()
	{		
		if(getCanDelete())
		{
			messageList.cleanMessageList();
			
			videoconferenceLogic.deleteRooms(confirmRoomList, messageList);
			
			int cont = 0;
			for(VideoconferenceRoom room : confirmRoomList)
			{
				if(!room.isActive())
					cont++;
			}
			
			messageList.addMessageInfo(MessageList.INF_ROOM_REMOVED, new String[] {String.valueOf(cont)});									
		}
		
		return "roomList";
	}
	
	
	/*
	 * -------------------------------------------------------------------
	 * 						Comprobar estado servidor 
	 * -------------------------------------------------------------------
	 */
	public String processRefreshState()
	{
		pingServer = null;
		checkLogin = null;
		return "checkStatus";
	}
	
	public boolean isPingServer()
	{
		if(pingServer == null)
			pingServer = videoconferenceLogic.pingServer();
		return pingServer;
	}
	
	public boolean isCheckLogin()
	{
		if(checkLogin == null)
			checkLogin = videoconferenceLogic.checkLogin();
		return checkLogin;
	}
	
	/*
	 * -------------------------------------------------------------------
	 * 						Acceso a sala 
	 * -------------------------------------------------------------------
	 */
	private HtmlInputHidden popupBlocked;
	
	public String getUrl() 	
	{
		if(getCanAccess())
			return videoconferenceLogic.accessRoom(currentRoom.getRoom());
		return "";
	}
	
	public HtmlInputHidden getPopupBlocked() {
		return popupBlocked;
	}
	
	public void setPopupBlocked(HtmlInputHidden popupBlocked) {
		this.popupBlocked = popupBlocked;
	}
	public String processLoadingReturn()
	{
		String s = (String)popupBlocked.getValue();
		Boolean isBlocked = Boolean.valueOf(s);
				
		messageList.cleanMessageList();
		
		if(isBlocked)
		{		
			messageList.addMessageInfo(MessageList.INF_POPUP_BLOCK);		
		}
		
		return "roomList";
	}
	
	/*
	 * -------------------------------------------------------------------
	 * 						Creacion / Edicion de sala 
	 * -------------------------------------------------------------------
	 */	
	public boolean isHasCalendar()
	{
		return videoconferenceLogic.hasCalendar();
	}
	
	public boolean isHasAnnouncement()
	{
		return videoconferenceLogic.hasAnnouncement();
	}
	
	public Locale getLocale()
	{
		return I18nService.getInstance().getLocale();
	}
		
	public boolean isHasAvailableGroups()
	{
		return videoconferenceLogic.hasAvailableGroups();
	}

	private List<SelectItem> typeOptions = null;
	public List<SelectItem> getTypeOptions()
	{
		if(typeOptions == null)
		{
			typeOptions = new ArrayList<SelectItem>();
			typeOptions.add(new SelectItem(VideoconferenceRoom.OM_TYPE_CONFERENCE, I18nService.getInstance().getMessage("type_conference")));
			typeOptions.add(new SelectItem(VideoconferenceRoom.OM_TYPE_AUDIENCE, I18nService.getInstance().getMessage("type_audience")));
			typeOptions.add(new SelectItem(VideoconferenceRoom.OM_TYPE_RESTRICTED, I18nService.getInstance().getMessage("type_restricted")));
			typeOptions.add(new SelectItem(VideoconferenceRoom.OM_TYPE_INTERVIEW, I18nService.getInstance().getMessage("type_interview")));
		}		
		
		return typeOptions;
	}
	
	public List<SelectItem> getAccessOptions()
	{
		List<SelectItem> ret = new ArrayList<SelectItem>();
		ret.add(new SelectItem(true, I18nService.getInstance().getMessage("access_by_site")));
		
		if(isHasAvailableGroups())
			ret.add(new SelectItem(false, I18nService.getInstance().getMessage("access_by_group_user")));
		else
			ret.add(new SelectItem(false, I18nService.getInstance().getMessage("access_by_user")));
		
		return ret;
	}
		
	public synchronized String processActionUpdate() 
	{							
		messageList.cleanMessageList();
		
		if(currentRoom.getRoom().isAccessBySite())
		{
			currentRoom.getRoom().setGroupList(new ArrayList<String>());
			currentRoom.getRoom().setUserList(new ArrayList<String>());
		}
		else
		{
			currentRoom.getRoom().setGroupList(currentRoom.getSerialized_groupList().equals("") ? new ArrayList<String>() : Arrays.asList(currentRoom.getSerialized_groupList().split(",")));
			currentRoom.getRoom().setUserList(currentRoom.getSerialized_userList().equals("") ? new ArrayList<String>() : Arrays.asList(currentRoom.getSerialized_userList().split(",")));
		}
		
		//se refresca para que en el caso de error, aparezcan los ultimos cambios
		refreshWrapper_groups(currentRoom);
		refreshWrapper_users(currentRoom);
		
		if(!validateFields())
			return "error"; 
		
		String ret = "roomList";
		if((isNew && getCanCreate()) || (!isNew && getCanEdit()))
		{
			if(!currentRoom.isRecurrence())
				currentRoom.getRoom().setRecurrenceCount(0);
			
			if(isNew)
				videoconferenceLogic.addRoom(currentRoom.getRoom(), messageList);
			else
				videoconferenceLogic.updateRoom(currentRoom.getRoom(), messageList);	
			
			//comprobamos si ha habido algun error
			ret = processErrors();
			
			if(ret.equals("error"))
			{
				if(!currentRoom.isRecurrence())
				{
					currentRoom.getRoom().setRecurrenceCount(1);
					currentRoom.getRoom().setRecurrenceType("day");
				}
			}
		}
			
		return ret;
	}
	
	private boolean validateFields()
	{
		String name = currentRoom.getRoom().getName();
		Date init = currentRoom.getRoom().getStartDate();
		Date end = currentRoom.getRoom().getEndDate();
		
		FacesContext fc = FacesContext.getCurrentInstance();
		String message;
		boolean ret = true;
		
		if(name == null || (name != null && name.length() == 0))
		{
			message = I18nService.getInstance().getMessage("empty_name");
			fc.addMessage("items", new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
			ret = false;
		}
		
		if(init == null)
		{
			message = I18nService.getInstance().getMessage("empty_init_date");
			fc.addMessage("items", new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
			ret = false;
		}
		
		if(end == null)
		{
			message = I18nService.getInstance().getMessage("empty_end_date");
			fc.addMessage("items", new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
			ret = false;
		}
		
		if(init != null && end != null)
		{
			if(init.compareTo(end) >= 0)
			{
				message = I18nService.getInstance().getMessage("incorrect_dates");
				fc.addMessage("items", new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
				
				ret = false;
			}
		}
		return ret;
	}
	
	private String processErrors()
	{
		String ret = "roomList";
		
		//comprobamos la pagina donde debe volver segun los errores
		for(FacesMessage msg : messageList.getMessageList())
		{
			if(msg.getSummary().equals(MessageList.ERR_VC))
			{
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.addMessage("items", msg);
				ret = "error";
			}
		}		
		
		return ret;

	}
	
	public String processRoomList()
	{
		return "roomList";
	}
	
	public String processActionCancel() 
	{
		return "roomList";
	}
	
	/*
	 * -------------------------------------------------------------------
	 * 						Pagina auxiliar
	 * -------------------------------------------------------------------
	 */
	
	public String processBypass()
	{
		if(messageList.hasMessages())
		{
			FacesContext fc = FacesContext.getCurrentInstance();
			for(FacesMessage fm : messageList.getMessageList())
			{
				fc.addMessage("items", fm);
			}
		}
				
		messageList.cleanMessageList();
		
		return "roomList";
	}
}
