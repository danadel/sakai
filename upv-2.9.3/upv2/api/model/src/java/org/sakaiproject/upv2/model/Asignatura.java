package org.sakaiproject.upv2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;

public class Asignatura implements Serializable {

	private Long codigo = null;
	private Long codigo_origen = null;
	private String propietario = null;
	private String nombre = null;
	private String nombrev = null;
	private String nombrei = null;
	private Date fechaAlta = null;
	private Date fechaBaja = null;
	private Date fechaMod = null;
	private String sincronizar = null;
	private Set teldes = null;
	
	public Long getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(Long cod) {
		this.codigo = cod;
	}
	
	public Long getOrigen() {
		return this.codigo_origen;
	}
	
	public void setOrigen(Long cod) {
		this.codigo_origen = cod;
	}
	
	public String getPropietario() {
		return this.propietario;		
	}
	
	public void setPropietario(String prop) {
		this.propietario = prop;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nom) {
		this.nombre = nom;
	}
	
	public String getNombrev() {
		return this.nombrev;
	}
	
	public void setNombrev(String nom) {
		this.nombrev = nom;
	}
	
	public String getNombrei() {
		return this.nombrei;
	}
	
	public void setNombrei(String nom) {
		this.nombrei = nom;
	}
	
	public String getSincronizar() {
		return this.sincronizar;
	}
	
	public void setSincronizar(String sinc) {
		this.sincronizar = sinc;
	}
	
	public Date getFechaAlta() {
		return this.fechaAlta;
	}
	
	public void setFechaAlta(Date fecha) {
		this.fechaAlta = fecha;
	}
	
	public Date getFechaBaja() {
		return this.fechaBaja;
	}
	
	public void setFechaBaja(Date fecha) {
		this.fechaBaja = fecha;
	}
	
	public Date getFechaMod() {
		return this.fechaMod;
	}
	
	public void setFechaMod(Date fecha) {
		this.fechaMod = fecha;
	}

	public Set getTeldes() {
		return teldes;
	}

	public void setTeldes(Set teldes) {
		this.teldes = teldes;
	}
	
	
	
	
}
