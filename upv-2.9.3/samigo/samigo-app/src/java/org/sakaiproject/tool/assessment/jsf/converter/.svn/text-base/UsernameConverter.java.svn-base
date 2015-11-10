package org.sakaiproject.tool.assessment.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.user.api.User;
import org.sakaiproject.user.api.UserDirectoryService;
import org.sakaiproject.user.api.UserNotDefinedException;

public class UsernameConverter implements Converter {
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		return getAsString(arg0, arg1, arg2);
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		String userId = (String)arg2;
		if (userId == null) return null;
		
		UserDirectoryService service = (UserDirectoryService)ComponentManager.get(UserDirectoryService.class);
		
		User user = null;
		try {
			user = service.getUser(userId);
		} catch (UserNotDefinedException e) {
			return userId;
		}
		
		return user.getDisplayName();
	}

}
