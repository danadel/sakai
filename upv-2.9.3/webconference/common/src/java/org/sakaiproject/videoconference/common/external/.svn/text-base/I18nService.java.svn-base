package org.sakaiproject.videoconference.common.external;

import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.util.ResourceLoader;
import org.sakaiproject.time.cover.TimeService;

public class I18nService {

	private static I18nService uniqueInstance = null;
	
	private ResourceLoader resourceLoader = null;
	
	private static Log log = LogFactory.getLog(I18nService.class);
	
	public static I18nService getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new I18nService();			
		}
		return uniqueInstance;
	}
	
	private I18nService()
	{
		resourceLoader = new ResourceLoader("org/sakaiproject/tool/videoconference/messages");
	}
	
	public String getMessage(String key, String[] args)
	{
		return resourceLoader.getFormattedMessage(key, args);			
	}
	
	public String getMessage(String key)
	{
		return resourceLoader.getString(key);			
	}
	
	public Locale getLocale()
	{
		try
		{
			return resourceLoader.getLocale();
		}catch(Exception e)
		{
			log.warn("In getLocale",e);
			return null;
		}
	}
	public TimeZone getTimeZone(){
		return TimeService.getLocalTimeZone();
	}
}
