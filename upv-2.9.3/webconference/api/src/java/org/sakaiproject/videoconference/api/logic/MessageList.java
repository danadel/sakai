package org.sakaiproject.videoconference.api.logic;

import java.util.List;

import javax.faces.application.FacesMessage;

public interface MessageList {

	public final static String ERR_ADD_CAL = "create_calendar_error";
	public final static String ERR_ADD_ANN = "create_announcement_error";
	public final static String ERR_UPD_CAL = "update_calendar_error";
	public final static String ERR_UPD_ANN = "update_announcement_error";
	public final static String ERR_DEL_CAL = "delete_calendar_error";
	public final static String ERR_DEL_ANN = "delete_announcement_error";
	public final static String ERR_DB = "database_error";
	public final static String ERR_VC = "videoconference_error";
	public final static String ERR_DUPLICATED_NAME = "duplicated_name";
	public final static String INF_ROOM_REMOVED = "room_removed";
	public final static String INF_POPUP_BLOCK = "popup_blocker";

	public abstract boolean hasMessages();

	public abstract void addMessageError(String msg);

	public abstract void addMessageInfo(String msg);

	public abstract void addMessageInfo(String msg, String[] args);

	public abstract void cleanMessageList();

	public abstract List<FacesMessage> getMessageList();

}