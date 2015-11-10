/******************************************************************************
 * WebasimasterItem.java - created by Sakai App Builder -AZ
 * 
 * Copyright (c) 2008 Sakai Project/Sakai Foundation
 * Licensed under the Educational Community License version 1.0
 * 
 * A copy of the Educational Community License has been included in this 
 * distribution and is available at: http://www.opensource.org/licenses/ecl1.php
 * 
 *****************************************************************************/

package org.sakaiproject.webasimaster.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



/**
 * This is a sample POJO (data storage object) 
 * @author Sakai App Builder -AZ
 */
public class WebasimasterItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1878620091134148290L;
	private String sakCodigoMaster;
	private String dni;
	private String sakCodigoAsimaster;
	
	
	public WebasimasterItem() {
		
	}


	public WebasimasterItem(String sakCodigoMaster, String dni,	String sakCodigoAsimaster) {
		
		this.sakCodigoMaster = sakCodigoMaster;
		this.dni = dni;
		this.sakCodigoAsimaster = sakCodigoAsimaster;
	}


	/**
	 * @return the sakCodigoMaster
	 */
	public String getSakCodigoMaster() {
		return sakCodigoMaster;
	}


	/**
	 * @param sakCodigoMaster the sakCodigoMaster to set
	 */
	public void setSakCodigoMaster(String sakCodigoMaster) {
		this.sakCodigoMaster = sakCodigoMaster;
	}


	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}


	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}


	/**
	 * @return the sakCodigoAsimaster
	 */
	public String getSakCodigoAsimaster() {
		return sakCodigoAsimaster;
	}


	/**
	 * @param sakCodigoAsimaster the sakCodigoAsimaster to set
	 */
	public void setSakCodigoAsimaster(String sakCodigoAsimaster) {
		this.sakCodigoAsimaster = sakCodigoAsimaster;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		
		// object must be WebasimasterItem at this point
		WebasimasterItem item = (WebasimasterItem)obj;
		return (this.sakCodigoMaster.equals(item.sakCodigoMaster) &&
				this.dni.equals(item.dni) &&
				this.sakCodigoAsimaster.equals(item.sakCodigoAsimaster));
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(sakCodigoMaster).append(dni).append(sakCodigoAsimaster).toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("sakCodigoMaster", sakCodigoMaster)
			.append("dni", dni)
			.append("sakCodigoAsimaster", sakCodigoAsimaster)
			.toString();
	}
}
