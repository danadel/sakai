package org.sakaiproject.tool.assessment.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.sakaiproject.util.ResourceLoader;

public class AccessTypeConverter implements Converter {

	private ResourceLoader messages = new ResourceLoader("org.sakaiproject.tool.assessment.bundle.QuestionPoolMessages");
	
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		String result = "";
		String value = "";
		if (arg2.getClass().getName().equals("java.lang.String")) {
			value = (String)arg2;
		}
		else if (arg2.getClass().getName().equals("java.lang.Long")) {
			value = ((Long)arg2).toString();
		}
		
		if ("31".equals(value))
			result = messages.getString("read_only");
		else if ("32".equals(value))
			result = messages.getString("modify");
		else if ("33".equals(value))
			result = messages.getString("read_write");
		else if ("34".equals(value))
			result = messages.getString("admin");
		
		return result;
	}

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		return getAsString(arg0, arg1, arg2);
	}
}
