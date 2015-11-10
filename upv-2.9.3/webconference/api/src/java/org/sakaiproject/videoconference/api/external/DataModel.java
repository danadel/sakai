package org.sakaiproject.videoconference.api.external;

import java.util.List;

import org.sakaiproject.videoconference.api.model.VideoconferenceRoom;

public interface DataModel {

	public abstract List<VideoconferenceRoom> getSiteRooms(String siteId);

	public abstract boolean addSiteRoom(VideoconferenceRoom room);

	public abstract boolean updateSiteRoom(VideoconferenceRoom room);

	public abstract boolean deleteSiteRoom(VideoconferenceRoom room);
	
	public abstract int getAndUpdateSequence();

}