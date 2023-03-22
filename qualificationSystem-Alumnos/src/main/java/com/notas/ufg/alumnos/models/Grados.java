package com.notas.ufg.alumnos.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grado")
public class Grados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idgr;
	private String grado;
	private String seccion;
	
	public Integer getIdgr() {
		return idgr;
	}
	public void setIdgr(Integer idgr) {
		this.idgr = idgr;
	}
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

}
