package com.notas.ufg.models;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ContraAlum {
	
	private Integer idal;
	private String carnet;
	private String nombre;
	private String apellido;
	private String usuario;
	private String correo;
	private String clave;
	private String clavecon;
	
	@ManyToOne()
	@JoinColumn(name = "idgrado")
	private Grados idgrado;

	public Integer getIdal() {
		return idal;
	}

	public void setIdal(Integer idal) {
		this.idal = idal;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getClavecon() {
		return clavecon;
	}

	public void setClavecon(String clavecon) {
		this.clavecon = clavecon;
	}

	public Grados getIdgrado() {
		return idgrado;
	}

	public void setIdgrado(Grados idgrado) {
		this.idgrado = idgrado;
	}

	@Override
	public String toString() {
		return "ContraAlum [idal=" + idal + ", carnet=" + carnet + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", usuario=" + usuario + ", correo=" + correo + ", clave=" + clave + ", clavecon=" + clavecon
				+ ", idgrado=" + idgrado + "]";
	}
	
}
