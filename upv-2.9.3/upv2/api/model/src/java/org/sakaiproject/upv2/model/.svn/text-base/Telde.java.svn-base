package org.sakaiproject.upv2.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.sakaiproject.util.ResourceLoader;

public class Telde implements Serializable, Comparable {

	private Long codigo = null;
	private Long asi_codigo = null;
	private String descrip = null;
	private String descripv = null;
	private String descripi = null;
	private String url = null;
	private Asignatura asignatura;
	private boolean seleccion;	
	private boolean preseleccion;
	private Set telsitios = new HashSet();
	private ResourceLoader rl;
	
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
        public String getI18nDescrip(){
	   if (rl==null) {rl=new ResourceLoader();};
	   if (rl.getLocale().toString().toLowerCase().startsWith("es")) {return descrip;}
	   if (rl.getLocale().toString().toLowerCase().startsWith("ca")) {return descripv;}
	   else {return descripi;}
	}	  
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getDescripi() {
		return descripi;
	}
	public void setDescripi(String descripi) {
		this.descripi = descripi;
	}
	public String getDescripv() {
		return descripv;
	}
	public void setDescripv(String descripv) {
		this.descripv = descripv;
	}
	public Long getAsi_codigo() {
		return asi_codigo;
	}
	public void setAsi_codigo(Long asi_codigo) {
		this.asi_codigo = asi_codigo;
	}
	
	  public int compareTo(Object obj)
	  {
	    return this.descrip.compareTo(((Telde) obj).getDescrip());  
	  }
	public boolean isSeleccion() {
		return seleccion;
	}
	public void setSeleccion(boolean seleccion) {
		this.seleccion = seleccion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Set getTelsitios() {
		return telsitios;
	}
	public void setTelsitios(Set telsitios) {
		this.telsitios = telsitios;
	}
	public boolean isPreseleccion() {
		return preseleccion;
	}
	public void setPreseleccion(boolean preseleccion) {
		this.preseleccion = preseleccion;
	}	
	
}
