/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/sam/trunk/samigo-app/src/java/org/sakaiproject/tool/assessment/ui/bean/questionpool/QuestionPoolShareBean.java $
 * $Id: QuestionPoolShareBean.java 46438 2008-05-14 22:05:27Z ktsao@stanford.edu $
 ***********************************************************************************
 *
 * Copyright (c) 2006, 2008, 2009 The Sakai Foundation
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



package org.sakaiproject.tool.assessment.ui.bean.author;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.faces.component.html.HtmlDataTable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.tool.assessment.facade.AgentFacade;
import org.sakaiproject.tool.assessment.facade.AssessmentTemplateSharedFacade;
import org.sakaiproject.tool.assessment.services.assessment.AssessmentService;
import org.sakaiproject.tool.assessment.ui.listener.util.ContextUtil;
import org.sakaiproject.tool.assessment.util.BeanSort;
import org.sakaiproject.event.cover.EventTrackingService;

public class TemplateShareBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1154189308380595101L;

	private static Log log = LogFactory.getLog(TemplateShareBean.class);
	
	// Template
	private Long templateId;
	private String templateCreatedBy;
	private String templateTitle;

	private String[] destTemplates = {  }; // for multibox jsf
  
	// for sorting
	private String sortPropertyWith = "displayName";
	private boolean sortAscendingWith = true;
	private String sortPropertyWithout = "displayName";
	private boolean sortAscendingWithout = true;
  
	// collections of Agents
	private Collection<AssessmentTemplateSharedFacade> agentsWithAccess;
	private Collection<AssessmentTemplateSharedFacade> agentsWithoutAccess;
	private HtmlDataTable dataTable;
		
	
  	/**
  	 * Creates a new TemplateShareBean object.
  	 */
  	public TemplateShareBean()
  	{
  	}

  	public String shareTemplate() {

  		AssessmentService delegate = new AssessmentService();  		
  		 
  		ArrayList<String> revoke = ContextUtil.paramArrayValueLike("revokeCheckbox");
 	
  		Iterator<String> iter = revoke.iterator();
  		while(iter.hasNext()) {
  			String agentId = (String) iter.next();
  			
  			try {
  				delegate.removeTemplateAccess(getTemplateId(), agentId);
  				//Revoke template access
  				EventTrackingService.post(EventTrackingService.newEvent("sam.template.revoke", "/sam/" +AgentFacade.getCurrentSiteId() + "/agentId=" + agentId + " templateId=" + getTemplateId(), true));

  			}
  			catch(Exception e) {
  				e.printStackTrace();
  				throw new RuntimeException(e);
  			}
  		}
	  
  		ArrayList<String> grant = ContextUtil.paramArrayValueLike("grantCheckbox");
  		
  		iter = grant.iterator();
  		while(iter.hasNext()) {
  			String agentId = (String) iter.next();
  			
  			try {
  				delegate.addTemplateAccess(getTemplateId(), agentId);
  				//Grant question pool access
  				EventTrackingService.post(EventTrackingService.newEvent("sam.template.grant", "/sam/" +AgentFacade.getCurrentSiteId() + "/agentId=" + agentId + " templateId=" + getTemplateId(), true));
  			}
  			catch(Exception e) {
  				e.printStackTrace();
  				throw new RuntimeException(e);
  			}
  		}

  		return "template";
  	}

  	public String sortByColumnHeader() {
  		String sortString = ContextUtil.lookupParam("orderBy");
  		String ascending = ContextUtil.lookupParam("ascending");
  		String list = ContextUtil.lookupParam("list");
  		
  		if ("agentsWithAccess".equals(list)) {
  			this.setSortPropertyWith(sortString);
  	  		this.setSortAscendingWith((Boolean.valueOf(ascending)).booleanValue());
  			
  			sortAgentsWithAccess();
  		}
  		else { 
  			this.setSortPropertyWithout(sortString);
  	  		this.setSortAscendingWithout((Boolean.valueOf(ascending)).booleanValue());
  	  		
  	  		sortAgentsWithoutAccess();
  		}
        
  		return "shareList";
  	}
  	
  	public void sortAgentsWithAccess() {
  		BeanSort sort = new BeanSort(agentsWithAccess, sortPropertyWith);
		sort.toStringSort();
	        
		agentsWithAccess = sortAscendingWith ? (ArrayList)sort.sort() : (ArrayList)sort.sortDesc();
  	}

  	public void sortAgentsWithoutAccess() {
  		BeanSort sort = new BeanSort(agentsWithoutAccess, sortPropertyWithout);
		sort.toStringSort();
	        
		agentsWithoutAccess = sortAscendingWithout ? (ArrayList)sort.sort() : (ArrayList)sort.sortDesc();
  	}

  	  
	public Collection<AssessmentTemplateSharedFacade> getAgentsWithAccess() {
		return agentsWithAccess;
	}

	public void setAgentsWithAccess(Collection<AssessmentTemplateSharedFacade> agentsWithAccess) {
		this.agentsWithAccess = agentsWithAccess;
	}

	public Collection<AssessmentTemplateSharedFacade> getAgentsWithoutAccess() {
		return agentsWithoutAccess;
	}

	public void setAgentsWithoutAccess(Collection<AssessmentTemplateSharedFacade> agentsWithoutAccess) {
		this.agentsWithoutAccess = agentsWithoutAccess;
	}
	
	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public String getTemplateCreatedBy() {
		return templateCreatedBy;
	}

	public void setTemplateCreatedBy(String templateCreatedBy) {
		this.templateCreatedBy = templateCreatedBy;
	}

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public String getTemplateTitle() {
		return templateTitle;
	}

	public void setTemplateTitle(String templateTitle) {
		this.templateTitle = templateTitle;
	}

	public void setDestTemplates(String[] destTemplates) {
		this.destTemplates = destTemplates;
	}

	public String[] getDestTemplates() {
		return destTemplates;
	}

	public void setSortPropertyWith(String sortPropertyWith) {
		this.sortPropertyWith = sortPropertyWith;
	}

	public String getSortPropertyWith() {
		return sortPropertyWith;
	}

	public void setSortAscendingWith(boolean sortAscendingWith) {
		this.sortAscendingWith = sortAscendingWith;
	}

	public boolean isSortAscendingWith() {
		return sortAscendingWith;
	}

	public void setSortPropertyWithout(String sortPropertyWithout) {
		this.sortPropertyWithout = sortPropertyWithout;
	}

	public String getSortPropertyWithout() {
		return sortPropertyWithout;
	}

	public void setSortAscendingWithout(boolean sortAscendingWithout) {
		this.sortAscendingWithout = sortAscendingWithout;
	}

	public boolean isSortAscendingWithout() {
		return sortAscendingWithout;
	}
	
}
