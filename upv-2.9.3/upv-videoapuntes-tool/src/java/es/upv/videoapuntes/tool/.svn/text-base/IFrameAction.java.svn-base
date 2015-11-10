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

package es.upv.videoapuntes.tool;

import java.util.ResourceBundle;

import org.sakaiproject.cheftool.Context;
import org.sakaiproject.cheftool.JetspeedRunData;
import org.sakaiproject.cheftool.RunData;
import org.sakaiproject.cheftool.VelocityPortlet;
import org.sakaiproject.cheftool.VelocityPortletPaneledAction;
import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.entity.api.Reference;
import org.sakaiproject.entity.api.EntityManager;
import org.sakaiproject.event.api.SessionState;
import org.sakaiproject.site.api.SiteService;
import org.sakaiproject.tool.api.ToolManager;
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
	
	private EntityManager entityManager = (EntityManager) ComponentManager.get(EntityManager.class);
	
	private SiteService siteService = (SiteService) ComponentManager.get(SiteService.class);
	
	private ToolManager toolManager = (ToolManager) ComponentManager.get(ToolManager.class);
	
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
		Reference ref = entityManager.newReference(url);

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
		
		String siteId = toolManager.getCurrentPlacement().getContext();
		
		state.setAttribute(URL, sourceURL.concat(siteId));

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
			value = siteService.getSite(toolManager.getCurrentPlacement().getContext()).getProperties().getProperty(key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return value;
	}

}
