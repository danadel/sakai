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



package org.sakaiproject.tool.assessment.ui.bean.questionpool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.event.cover.EventTrackingService;
import org.sakaiproject.tool.assessment.data.model.Tree;
import org.sakaiproject.tool.assessment.facade.AgentFacade;
import org.sakaiproject.tool.assessment.facade.QuestionPoolDataFacade;
import org.sakaiproject.tool.assessment.facade.QuestionPoolFacade;
import org.sakaiproject.tool.assessment.facade.QuestionPoolIteratorFacade;
import org.sakaiproject.tool.assessment.services.QuestionPoolService;
import org.sakaiproject.tool.assessment.ui.bean.author.ItemAuthorBean;
import org.sakaiproject.tool.assessment.ui.listener.util.ContextUtil;
import org.sakaiproject.tool.assessment.util.BeanSort;
import org.sakaiproject.tool.assessment.business.questionpool.QuestionPoolTreeImpl;
import org.sakaiproject.util.ResourceLoader;
import org.sakaiproject.event.cover.EventTrackingService;

public class QuestionPoolShareBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1154189308380595101L;

	private static Log log = LogFactory.getLog(QuestionPoolShareBean.class);
	
	// QuestionPool
	private Long questionPoolId;
	private String questionPoolOwnerId;
	private String questionPoolName;

	private String[] destPools = {  }; // for multibox jsf
  
	// for sorting
	private String sortPropertyWith = "displayName";
	private boolean sortAscendingWith = true;
	private String sortPropertyWithout = "displayName";
	private boolean sortAscendingWithout = true;
  
	// collections of Agents
	private Collection<QuestionPoolDataFacade> agentsWithAccess;
	private Collection<QuestionPoolDataFacade> agentsWithoutAccess;
	private HtmlDataTable dataTable;
	
	private List<SelectItem> accessTypes;
	
	
  	/**
  	 * Creates a new QuestionPoolShareBean object.
  	 */
  	public QuestionPoolShareBean()
  	{
  		setAccessTypes();
  	}

  	public String startSharePool()
  	{
  		log.debug("inside startSharePool()");  
	
  		String qpid = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("qpid");

  		QuestionPoolService delegate = new QuestionPoolService();
    
  		QuestionPoolFacade thepool = delegate.getPool(new Long(qpid), AgentFacade.getAgentString());
         
  		setAgentsWithAccess(delegate.getAgentsWithAccess(new Long(qpid)));
  		setAgentsWithoutAccess(delegate.getAgentsWithoutAccess(new Long(qpid), AgentFacade.getCurrentSiteId()));
  		setQuestionPoolId(new Long(qpid));
  		setQuestionPoolOwnerId(thepool.getOwnerId());
  		setQuestionPoolName(thepool.getDisplayName());
	
  		// order by default
  		sortAgentsWithAccess();
  		sortAgentsWithoutAccess();
  		
  		return "sharePool";
  	}
  
  	public String sharePool() {

  		QuestionPoolService delegate = new QuestionPoolService();
  		Tree tree = null;
  		try { 		
  			tree= new QuestionPoolTreeImpl((QuestionPoolIteratorFacade) delegate.getAllPoolsWithAccess(AgentFacade.getAgentString(), QuestionPoolDataFacade.READ_ONLY));
  		}
  		catch(Exception e) {
  			e.printStackTrace();
  			throw new RuntimeException(e);
  		}
	  		  	
  		ArrayList<String> revoke = ContextUtil.paramArrayValueLike("revokeCheckbox");
 	
  		Iterator<String> iter = revoke.iterator();
  		while(iter.hasNext()) {
  			String agentId = (String) iter.next();
  			
  			try {
  				delegate.removeQuestionPoolAccess(tree, agentId, getQuestionPoolId());
  				//Revoke question pool access
  				EventTrackingService.post(EventTrackingService.newEvent("sam.questionpool.revoke", "/sam/" +AgentFacade.getCurrentSiteId() + "/agentId=" + agentId + " poolId=" + getQuestionPoolId(), true));

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
  				delegate.addQuestionPoolAccess(tree, agentId, this.getQuestionPoolId(), getTypeAccess(agentId));
  				//Grant question pool access
  				EventTrackingService.post(EventTrackingService.newEvent("sam.questionpool.grant", "/sam/" +AgentFacade.getCurrentSiteId() + "/agentId=" + agentId + " poolId=" + getQuestionPoolId() + " type=" + getTypeAccess(agentId), true));
  			}
  			catch(Exception e) {
  				e.printStackTrace();
  				throw new RuntimeException(e);
  			}
  		}

  		return "poolList";
  	}
  	
  	public String unsharePool() {

  		log.debug("inside unharePool()");  
  		
  		String qpid = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("qpid");
  		QuestionPoolBean qpbean = (QuestionPoolBean) ContextUtil.lookupBean("questionpool");

  		QuestionPoolService delegate = new QuestionPoolService();
  		
		try {
			delegate.removeQuestionPoolAccess(qpbean.getTree(), AgentFacade.getAgentString(), Long.parseLong(qpid));
			//Revoke question pool access
			EventTrackingService.post(EventTrackingService.newEvent("sam.questionpool.revoke", "/sam/" + AgentFacade.getCurrentSiteId() + "/agentId=" + AgentFacade.getAgentString() + " poolId=" + Long.parseLong(qpid), true));
		}
		catch(Exception e) {
			log.error("Error unsharing pool " + qpid + ", error:" + e.getMessage());
			throw new RuntimeException(e);
		}
		
		qpbean.buildTree(QuestionPoolDataFacade.READ_ONLY);
		qpbean.setQpDataModelByLevel(qpbean.getSortProperty(), qpbean.getSortAscending());
		
  		return "poolList";
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

  	  
	public Collection<QuestionPoolDataFacade> getAgentsWithAccess() {
		return agentsWithAccess;
	}

	public void setAgentsWithAccess(Collection<QuestionPoolDataFacade> agentsWithAccess) {
		this.agentsWithAccess = agentsWithAccess;
	}

	public Collection<QuestionPoolDataFacade> getAgentsWithoutAccess() {
		return agentsWithoutAccess;
	}

	public void setAgentsWithoutAccess(Collection<QuestionPoolDataFacade> agentsWithoutAccess) {
		this.agentsWithoutAccess = agentsWithoutAccess;
	}
	
	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public String getQuestionPoolOwnerId() {
		return questionPoolOwnerId;
	}

	public void setQuestionPoolOwnerId(String questionPoolOwnerId) {
		this.questionPoolOwnerId = questionPoolOwnerId;
	}

	public Long getQuestionPoolId() {
		return questionPoolId;
	}

	public void setQuestionPoolId(Long questionPoolId) {
		this.questionPoolId = questionPoolId;
	}

	public String getQuestionPoolName() {
		return questionPoolName;
	}

	public void setQuestionPoolName(String questionPoolName) {
		this.questionPoolName = questionPoolName;
	}

	public void setDestPools(String[] destPools) {
		this.destPools = destPools;
	}

	public String[] getDestPools() {
		return destPools;
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
	
	public List<SelectItem> getAccessTypes() {
		return accessTypes;
	}
	
	public void setAccessTypes() {
	    List<SelectItem> accessTypes = new ArrayList<SelectItem>();
	    
	    ResourceLoader messages = new ResourceLoader("org.sakaiproject.tool.assessment.bundle.QuestionPoolMessages");
	    
	    accessTypes.add(new SelectItem(QuestionPoolDataFacade.READ_ONLY, messages.getString("read_only")));
	    accessTypes.add(new SelectItem(QuestionPoolDataFacade.MODIFY, messages.getString("modify")));
	    accessTypes.add(new SelectItem(QuestionPoolDataFacade.READ_WRITE, messages.getString("read_write")));
	    
	    this.accessTypes = accessTypes;
	}

	public void changePermisoSelect(ValueChangeEvent event) {

		Long value = (Long) event.getNewValue();
		
		QuestionPoolDataFacade permiso = (QuestionPoolDataFacade)dataTable.getRowData();
	    permiso.setAccessTypeId(value);
	        
	}
	
	private Long getTypeAccess(String agentId) {
		
		int row = 0;
		boolean enc = false;
		Long access = null;
		try {
			while (!enc) {
				dataTable.setRowIndex(row);
				QuestionPoolDataFacade qpd = (QuestionPoolDataFacade)dataTable.getRowData();
				if (qpd.getAgentId().equals(agentId)) {
					enc = true;
					access = qpd.getAccessTypeId();
				}
				row++;
			}
		} catch (Exception e) {
			// Do nothing
		}
		return access;
	}
}
