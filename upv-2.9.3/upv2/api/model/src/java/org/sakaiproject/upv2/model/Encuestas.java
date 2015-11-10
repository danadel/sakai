package org.sakaiproject.upv2.model;

import java.io.Serializable;

public class Encuestas implements Serializable {

	   
	private int codigo = -1;
	private int id_pase = -1;
	private String codigo_site_sakai = null;
	private String login_creador = null;
	private String codigo_grupo_sakai = null;	
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(int cod) {
		this.codigo = cod;
	}
	
	public int getIdPase() {
		return this.id_pase;
	}
	
	public void setIdPase(int cod) {
		this.id_pase = cod;
	}
	
	public String getCodigoSiteSakai() {
		return this.codigo_site_sakai;
	}
	
	public void setCodigoSiteSakai(String cod) {
		this.codigo_site_sakai = cod;
	}
	
	public String getLoginCreador() {
		return this.login_creador;		
	}
	
	public void setLoginCreador(String prop) {
		this.login_creador = prop;
	}
	
	public String getCodigoGrupoSakai() {
		return this.codigo_grupo_sakai;
	}
	
	public void setCodigoGrupoSakai(String cod) {
		this.codigo_grupo_sakai = cod;
	}	
	
}
