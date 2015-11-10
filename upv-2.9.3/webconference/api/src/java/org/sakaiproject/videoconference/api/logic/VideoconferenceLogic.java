package org.sakaiproject.videoconference.api.logic;

import java.util.List;

import org.sakaiproject.videoconference.api.model.VideoconferenceGroup;
import org.sakaiproject.videoconference.api.model.VideoconferenceRoom;
import org.sakaiproject.videoconference.api.model.VideoconferenceRoomType;
import org.sakaiproject.videoconference.api.model.VideoconferenceUser;

public interface VideoconferenceLogic {

	public abstract List<VideoconferenceRoom> getAllVisibleRooms();

	public abstract void addRoom(VideoconferenceRoom room, MessageList messageList);
	
	public abstract String addRoom_(VideoconferenceRoom room, MessageList messageList);

	public abstract void updateRoom(VideoconferenceRoom room, MessageList messageList);
	
	public abstract Boolean updateRoom_(VideoconferenceRoom room, MessageList messageList);

	public abstract void deleteRooms(List<VideoconferenceRoom> rooms, MessageList messageList);

	public abstract String accessRoom(VideoconferenceRoom room);
	
	public abstract List<VideoconferenceRoomType> getRoomTypes();

	public abstract List<VideoconferenceGroup> getAvailableGroups();

	public abstract boolean hasAvailableGroups();

	public abstract List<VideoconferenceUser> getAvailableUsers();

	public abstract boolean hasPermission(String permission);

	public abstract boolean canSeeRoom(VideoconferenceRoom room);

	public abstract boolean pingServer();

	public abstract boolean checkLogin();

	public abstract boolean hasCalendar();

	public abstract boolean hasAnnouncement();

}