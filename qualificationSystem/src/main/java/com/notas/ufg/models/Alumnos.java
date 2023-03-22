package com.notas.ufg.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.notas.ufg.models.Grados;

@Entity
@Table(name="alumno")
public class Alumnos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idal;
	
	@Column
	private String carnet;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;

	@Column
	private String usuario;

	@Column
	private String correo;
	
	@Column
	private String clave;
	
	
	@ManyToOne()
	@JoinColumn(name = "idgrado")
	private Grados idgrado;

	
	public int getIdal() {
		return idal;
	}

	public void setIdal(int idal) {
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



	public Grados getIdgrado() {
		return idgrado;
	}

	public void setIdgrado(Grados idgrado) {
		this.idgrado = idgrado;
	}

	@Override
	public String toString() {
		return "Alumnos [idal=" + idal + ", carnet=" + carnet + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", usuario=" + usuario + ", correo=" + correo + ", clave=" + clave 
				+  ", idgrado=" + idgrado + "]";
	}

	
}
