package org.sakaiproject.upv2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;
import org.sakaiproject.util.ResourceLoader;

public class Composicion implements Serializable {

	private Long codigo = null;
	private String propietario = null;
	private String nombre = null;
	private String nombrev = null;
	private String nombrei = null;
	private String descrip = null;
	private String descripv = null;	
	private String descripi = null;	
	private ResourceLoader rl = null;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getI18nNombre(){
	  if (rl==null) {rl=new ResourceLoader();};
	  if (rl.getLocale().toString().toLowerCase().startsWith("es")) {return nombre;}
	  if (rl.getLocale().toString().toLowerCase().startsWith("ca")) {return nombrev;}
	  else {return nombrei;}
	}
	public String getI18nDescrip(){
	  if (rl==null) {rl=new ResourceLoader();};
	  if (rl.getLocale().toString().toLowerCase().startsWith("es")) {return descrip;}
	  if (rl.getLocale().toString().toLowerCase().startsWith("ca")) {return descripv;}
	  else {return descripi;}
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombrei() {
		return nombrei;
	}
	public void setNombrei(String nombrei) {
		this.nombrei = nombrei;
	}
	public String getNombrev() {
		return nombrev;
	}
	public void setNombrev(String nombrev) {
		this.nombrev = nombrev;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
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
}
