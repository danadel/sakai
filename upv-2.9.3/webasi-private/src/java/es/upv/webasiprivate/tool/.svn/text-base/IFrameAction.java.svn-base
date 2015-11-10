/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/web/branches/sakai_2-4-x/web-tool/tool/src/java/org/sakaiproject/web/tool/IFrameAction.java $
 * $Id: IFrameAction.java 18589 2006-12-01 07:14:55Z joshua.ryan@asu.edu $
 ***********************************************************************************
 *
 * Copyright (c) 2003, 2004, 2005, 2006 The Sakai Foundation.
 * 
 * Licensed under the Educational Community License, Version 1.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at
 * 
 *      http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 *
 **********************************************************************************/

package es.upv.webasiprivate.tool;

import java.util.*;
import java.net.URLEncoder;
import java.io.*;


import org.sakaiproject.authz.api.AuthzGroup;
import org.sakaiproject.authz.api.GroupNotDefinedException;
import org.sakaiproject.authz.api.Role;
import org.sakaiproject.authz.cover.AuthzGroupService;
import org.sakaiproject.cheftool.Context;
import org.sakaiproject.cheftool.JetspeedRunData;
import org.sakaiproject.cheftool.RunData;
import org.sakaiproject.cheftool.VelocityPortlet;
import org.sakaiproject.cheftool.VelocityPortletPaneledAction;
import org.sakaiproject.component.cover.ServerConfigurationService;
import org.sakaiproject.entity.api.Reference;
import org.sakaiproject.entity.cover.EntityManager;
import org.sakaiproject.event.api.SessionState;
import org.sakaiproject.exception.IdUnusedException;
import org.sakaiproject.site.api.Site;
import org.sakaiproject.site.api.SitePage;
import org.sakaiproject.site.api.ToolConfiguration;
import org.sakaiproject.site.cover.SiteService;
import org.sakaiproject.tool.api.Placement;
import org.sakaiproject.tool.api.Session;
import org.sakaiproject.tool.api.ToolSession;
import org.sakaiproject.tool.cover.SessionManager;
import org.sakaiproject.tool.cover.ToolManager;
import org.sakaiproject.util.StringUtil;
import org.sakaiproject.user.api.User;
import org.sakaiproject.user.api.UserNotDefinedException;
import org.sakaiproject.user.cover.UserDirectoryService;

import org.sakaiproject.portal.api.PortalService;
/**
 * <p>
 * IFrameAction is the Sakai tool to place any web content in an IFrame on the page.
 * </p>
  */
public class IFrameAction extends VelocityPortletPaneledAction
{
	/** The value in state and context for the source URL to actually used, as computed from special and URL. */
	protected final static String URL = "url";

	/** The height, in state, config and context. */
	protected final static String HEIGHT = "height";
	
	/**
	 * Populate the state with configuration settings
	 */
	protected void initState(SessionState state, VelocityPortlet portlet, JetspeedRunData rundata){
		// TODO: we might want to keep this from running for each request - but by letting it we get fresh info each time... -ggolden
		super.initState(state, portlet, rundata);
	}
	

	/**
	 * If the url is a valid reference, convert it to a URL, else return it unchanged.
	 */
	protected String convertReferenceUrl(String url){
		// make a reference
		Reference ref = EntityManager.newReference(url);

		// if it didn't recognize this, return it unchanged
		if (!ref.isKnownType()) return url;

		// return the reference's url
		return ref.getUrl();
	}


	/**
	 * Setup the velocity context and choose the template for the response.
	 */
	public String buildMainPanelContext(VelocityPortlet portlet, Context context, RunData rundata, SessionState state){
//		System.out.println(" ----------- IFrameAction.buildMainPanelContext -------------");

		// Read configuration properties.
		ResourceBundle props = ResourceBundle.getBundle("config");
	    
		String sourceURL = convertReferenceUrl(props.getString("sourceURL"));
		state.setAttribute(URL, sourceURL);
//		System.out.println("	> sourceURL: " + sourceURL);
		
			//Parsing URL
		int paramCount = Integer.parseInt(props.getString("param.count"));
//		System.out.println("	> paramCount: " + paramCount);

		for (int i=1;i<=paramCount;i++){
			try{
//				System.out.println("	> param_" + i);
				String paramName = props.getString("param.name." + new Integer(i).toString());
//				System.out.println("		> param.name: " + paramName);
				String paramProperty = props.getString("param.property." + new Integer(i).toString());
//				System.out.println("		> param.property: " + paramProperty);
				String paramValue = getSiteProperty(paramProperty);
//				System.out.println("		> param.value: " + paramValue);
				sourceURL = sourceURL.replaceAll("\\[" + paramName + "\\]", paramValue);
			}catch(Exception e){}
		}

//		System.out.println("	> sourceURL: " + sourceURL);
		state.setAttribute(URL, sourceURL);

		String height = props.getString("height");
		state.setAttribute(HEIGHT, height);
//		System.out.println("	> height: " + height);

		//Put configuration parameters into Application Context
		context.put(URL, (String) state.getAttribute(URL));
		context.put(HEIGHT, state.getAttribute(HEIGHT));

		return (String) getContext(rundata).get("template");
	}

	private String getSiteProperty(String key){
		String value = null;
		try{
			value = SiteService.getSite(ToolManager.getCurrentPlacement().getContext()).getProperties().getProperty(key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return value;
	}

}
