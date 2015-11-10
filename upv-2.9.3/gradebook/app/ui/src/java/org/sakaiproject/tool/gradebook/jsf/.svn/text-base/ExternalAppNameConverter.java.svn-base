/**********************************************************************************
*
* $Id: ExternalAppNameConverter.java 74416 2010-03-08 13:35:38Z wagnermr@iupui.edu $
*
***********************************************************************************
*
 * Copyright (c) 2005, 2006, 2007, 2008 The Sakai Foundation, The MIT Corporation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*
**********************************************************************************/

package org.sakaiproject.tool.gradebook.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.CharacterConverter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.sakaiproject.util.ResourceLoader;

/**
 * The standard JSF number formatters only round values. We generally need
 * them truncated.
 * This converter truncates the input value (probably a double) to two
 * decimal places, and then returns it with a maximum of two decimal places.
 */
public class ExternalAppNameConverter extends CharacterConverter {
	private static final Log log = LogFactory.getLog(ExternalAppNameConverter.class);

	private ResourceLoader rl = null;
	
	public ExternalAppNameConverter() {
		rl = new ResourceLoader("org.sakaiproject.tool.gradebook.bundle.Messages");
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (log.isDebugEnabled()) 
			log.debug("getAsString(" + context + ", " + component + ", " + value + ")");

		String convertedText = "";
		if (value != null && value instanceof String) {
			if (value.equals("sakai.assignment.grades"))
				convertedText = rl.getString("overview_assignments");
			else if (value.equals("sakai.samigo"))
				convertedText = rl.getString("overview_assessments");
			else
				convertedText = (String)value;
		}
		
		return convertedText;
	}

}
