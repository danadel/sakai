/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/sam/tags/samigo-2.8.0/samigo-app/src/java/org/sakaiproject/tool/assessment/ui/listener/author/ConfirmDeleteTemplateListener.java $
 * $Id: ConfirmDeleteTemplateListener.java 59684 2009-04-03 23:33:27Z arwhyte@umich.edu $
 ***********************************************************************************
 *
 * Copyright (c) 2004, 2005, 2006, 2008 The Sakai Foundation
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



package org.sakaiproject.tool.assessment.ui.listener.author;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.tool.assessment.facade.AgentFacade;
import org.sakaiproject.tool.assessment.facade.AssessmentTemplateFacade;
import org.sakaiproject.tool.assessment.services.assessment.AssessmentService;
import org.sakaiproject.tool.assessment.ui.bean.author.TemplateShareBean;
import org.sakaiproject.tool.assessment.ui.listener.util.ContextUtil;

/**
 * <p> Stub</p>
 * <p>Description: Action Listener to share a template with others.</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Organization: Sakai Project</p>
 * @author Angel Nueda
 * @version $Id: TemplateShareListener.java 59684 2013-06-13 23:33:27Z anueda@indra.es $
 */

public class TemplateShareListener extends TemplateBaseListener implements ActionListener
{
	private static Log log = LogFactory.getLog(TemplateShareListener.class);

	public void processAction(ActionEvent ae) throws AbortProcessingException
	{
		log.info("SHARE TEMPLATE LISTENER.");

		String templateId = (String) FacesContext.getCurrentInstance().
				getExternalContext().getRequestParameterMap().get("templateId");
    
		AssessmentService assessmentService = new AssessmentService();
		AssessmentTemplateFacade template = assessmentService.getAssessmentTemplate(templateId);

		TemplateShareBean templateShareBean = (TemplateShareBean) ContextUtil.lookupBean(
				"templateShare");
    
		templateShareBean.setTemplateId(template.getAssessmentTemplateId());
		templateShareBean.setTemplateTitle(template.getTitle());
		templateShareBean.setTemplateCreatedBy(template.getCreatedBy());
		templateShareBean.setAgentsWithAccess(assessmentService.getAgentsWithAccess(new Long(templateId), template.getCreatedBy()));
		templateShareBean.setAgentsWithoutAccess(assessmentService.getAgentsWithoutAccess(new Long(templateId), template.getCreatedBy(), AgentFacade.getCurrentSiteId()));
		
  		// order by default
		templateShareBean.sortAgentsWithAccess();
		templateShareBean.sortAgentsWithoutAccess();
	}

}
