/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/msub/upv.es/PoliformaT/upv-2.9.3/samigo/samigo-app/src/java/org/sakaiproject/tool/assessment/ui/listener/util/ContextUtil.java $
 * $Id: ContextUtil.java 71511 2010-01-15 22:35:10Z ktsao@stanford.edu $
 ***********************************************************************************
 *
 * Copyright (c) 2004, 2005, 2006, 2007, 2008, 2009 The Sakai Foundation
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


package org.sakaiproject.tool.assessment.ui.listener.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.event.api.Notification;
import org.sakaiproject.event.cover.NotificationService;
import org.sakaiproject.service.gradebook.shared.GradebookExternalAssessmentService;
import org.sakaiproject.spring.SpringBeanLocator;
import org.sakaiproject.tool.cover.ToolManager;

/**
 * <p>Description: Action Listener helper utility</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Organization: Sakai Project</p>
 * @author Ed Smiley
 * @version $Id: ContextUtil.java 71511 2010-01-15 22:35:10Z ktsao@stanford.edu $
 */

public class DeleteGradebookUtil
{
	private static Log log = LogFactory.getLog(DeleteGradebookUtil.class);

	public static boolean checkCanDeleteGradebook(FacesContext context, String gradebookUid, Long assessmentId) {
		String msgError = ContextUtil.getLocalizedString("org.sakaiproject.tool.assessment.bundle.AssessmentSettingsMessages", 
				"notification_error_link2others");
		List<String> errors = new ArrayList<String>();
		errors.add(msgError);
		
		GradebookExternalAssessmentService g = (GradebookExternalAssessmentService) SpringBeanLocator.getInstance().
				getBean("org.sakaiproject.service.gradebook.GradebookExternalAssessmentService");
		
		try {
			Long assignmentId = g.getExternalAssignmentId(gradebookUid, assessmentId.toString());
			
			String notificationRef = "/gradebook/" + gradebookUid + "/" + assignmentId.toString();
			
			List<Notification> notifications = NotificationService.findNotifications("gradebook.updateItemScore", notificationRef);
			Iterator<Notification> iter = notifications.iterator();
		  	while (iter.hasNext()) {
		  		Notification notification = iter.next();
		  		String itemName = notification.getProperties().getProperty("AssociatedItem");
		  		String tool = notification.getProperties().getProperty("AssociatedTool");
		  		if (tool != null) {
			  		String toolName = ToolManager.getTool(tool) != null ? ToolManager.getTool(tool).getTitle() : tool;
			  		
			  		if (itemName != null)
			  			errors.add(toolName + "; " + itemName + ". ");
			  		else 
			  			errors.add(toolName + ". ");
		  		}
		  	}
		
		  	if (!notifications.isEmpty()) {
		  		for (String error : errors) {
		  			context.addMessage(null, new FacesMessage(error));
		  		}
				return false;
			}
		} catch (Exception e) {
			log.warn("DeleteGradebookUtil: No se ha encontrado getExternalAssignmentId asociado al examen: " + assessmentId.toString());
		}
		
	  	return true;
	}
}
