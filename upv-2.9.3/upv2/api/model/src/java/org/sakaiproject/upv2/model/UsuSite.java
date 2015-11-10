package org.sakaiproject.upv2.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UsuSite implements Serializable, Comparable {

	private Long site_codigo = null;
	private String per_perfil = null;
	private String usu_userid = null;

	
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getPer_perfil() {
		return per_perfil;
	}


	public void setPer_perfil(String per_perfil) {
		this.per_perfil = per_perfil;
	}


	public Long getSite_codigo() {
		return site_codigo;
	}


	public void setSite_codigo(Long site_codigo) {
		this.site_codigo = site_codigo;
	}


	public String getUsu_userid() {
		return usu_userid;
	}


	public void setUsu_userid(String usu_userid) {
		this.usu_userid = usu_userid;
	}
	
	
	public boolean equals(Object ob) {
		UsuSite us = (UsuSite) ob;
	  if (this.per_perfil.equals(us.getPer_perfil()) &&
	      this.usu_userid.equals(us.getUsu_userid())) { return true;};	      
	  return false;    	
	}
	
	public int hashCode() {
		return 0;
	}
}
