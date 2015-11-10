package org.sakaiproject.videoconference.adobeconnect.exceptions;

public class VideoconferenceExceptions {
	
	public static class DuplicatedNameException extends Exception
	{
	  public DuplicatedNameException(String name)
	  {
		  super(name+" is already in use");
	  }
	}	
}
