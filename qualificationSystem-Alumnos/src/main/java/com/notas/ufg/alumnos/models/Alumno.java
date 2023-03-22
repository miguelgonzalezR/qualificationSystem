package com.notas.ufg.alumnos.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.notas.ufg.alumnos.models.Authority;
import com.notas.ufg.alumnos.models.Grados;

@Entity(name="alumno")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idal;
	
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
	
	@Transient
	private String claveco;
	
	
	@ManyToOne()
	@JoinColumn(name = "idgrado")
	private Grados idgrado;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="authorities_alum",
	joinColumns=@JoinColumn(name="usuario_id"),
	inverseJoinColumns=@JoinColumn(name="authority_id"))
	private Set<Authority> authority;


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

	public Grados getIdgrado() {
		return idgrado;
	}


	public void setIdgrado(Grados idgrado) {
		this.idgrado = idgrado;
	}


	public Set<Authority> getAuthority() {
		return authority;
	}


	public void setAuthority(Set<Authority> authority) {
		this.authority = authority;
	}
	
	public String getClaveco() {
		return claveco;
	}


	public void setClaveco(String claveco) {
		this.claveco = claveco;
	}


	@Override
	public String toString() {
		return "Alumno [idal=" + idal + ", carnet=" + carnet + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", usuario=" + usuario + ", correo=" + correo + ", clave=" + clave + ", claveco=" + claveco
				+ ", idgrado=" + idgrado + ", authority=" + authority + "]";
	}
	
}
