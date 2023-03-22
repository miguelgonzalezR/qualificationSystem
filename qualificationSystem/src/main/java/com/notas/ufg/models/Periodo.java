package com.notas.ufg.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="periodo")
public class Periodo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idpr;
	
	@Column	
	private String Nombre;
	
	@Column
	private Date fechain;
	
	@Column
	private Date fechafi;

	public Integer getIdpr() {
		return idpr;
	}

	public void setIdpr(Integer idpr) {
		this.idpr = idpr;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Date getFechain() {
		return fechain;
	}

	public void setFechain(Date fechain) {
		this.fechain = fechain;
	}

	public Date getFechafi() {
		return fechafi;
	}

	public void setFechafi(Date fechafi) {
		this.fechafi = fechafi;
	}

	@Override
	public String toString() {
		return "Periodo [idpr=" + idpr + ", Nombre=" + Nombre + ", fechain=" + fechain + ", fechafi=" + fechafi + "]";
	}


}
