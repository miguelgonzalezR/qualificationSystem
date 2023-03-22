package com.notas.ufg.models;

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
import javax.persistence.Transient;

import com.notas.ufg.models.Authority;

@Entity(name="administradores")
public class Administradores {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;

	@Column
	private String usuario;

	@Column
	private String correo;
	
	@Column
	private String clave;
	
	@Column
	private Integer tipo;

	
	@Transient
	private String claveco;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="authorities_users",
	joinColumns=@JoinColumn(name="usuario_id"),
	inverseJoinColumns=@JoinColumn(name="authority_id"))
	
	private Set<Authority> authority;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer ban) {
		this.tipo = ban;
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
		return "Administradores [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", usuario=" + usuario
				+ ", correo=" + correo + ", clave=" + clave + ", tipo=" + tipo + ", claveco=" + claveco + ", authority="
				+ authority + "]";
	}
	
}
