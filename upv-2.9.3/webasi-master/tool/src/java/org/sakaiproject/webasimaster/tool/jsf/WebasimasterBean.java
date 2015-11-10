/******************************************************************************
 * WebasimasterBean.java - created by Sakai App Builder -AZ
 * 
 * Copyright (c) 2008 Sakai Project/Sakai Foundation
 * Licensed under the Educational Community License version 1.0
 * 
 * A copy of the Educational Community License has been included in this 
 * distribution and is available at: http://www.opensource.org/licenses/ecl1.php
 * 
 *****************************************************************************/

package org.sakaiproject.webasimaster.tool.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.sakaiproject.webasimaster.logic.ExternalLogic;
import org.sakaiproject.webasimaster.model.WebasimasterItem;

/**
 * This is a backing bean for the JSF app which handles the events and
 * sends the information from the logic layer to the UI
 * @author Sakai App Builder -AZ
 */
public class WebasimasterBean {

	private static Log log = LogFactory.getLog(WebasimasterBean.class);
	
	private DataModel itemsModel;

	private ExternalLogic externalLogic;
	public void setExternalLogic(ExternalLogic externalLogic) {
		this.externalLogic = externalLogic;
	}

	
	public WebasimasterBean() {
	}


	public DataModel getAsignaturas() {
		log.debug("getting asignaturas for JSF datatable...");
		List<WebasimasterItemWrapper> items = new ArrayList<WebasimasterItemWrapper>();
		
		List<WebasimasterItem> asignaturas = externalLogic.getAsignaturasMaster(externalLogic.getCurrentUserId(), externalLogic.getCurrentLocationId() );
		
		for (WebasimasterItem asignatura : asignaturas) {
			WebasimasterItemWrapper item = new WebasimasterItemWrapper();
			item.setCode(asignatura.getSakCodigoAsimaster());
			item.setName(externalLogic.getLocationTitle(asignatura.getSakCodigoAsimaster()));
			item.setUrl(externalLogic.getLocationUrl() + asignatura.getSakCodigoAsimaster());
			items.add(item);
		}
		
		itemsModel = new ListDataModel(items);
		return itemsModel;
	}
	
	
	/**
	 * @return the noHayDatos
	 */
	public boolean isNoHayDatos() {
		return itemsModel.getRowCount() == 0;
	}
	
}
