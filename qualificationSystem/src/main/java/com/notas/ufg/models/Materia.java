package com.notas.ufg.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="materia")
public class Materia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idma;
	
	@Column
	private String nombre;
	
	@ManyToOne()
	@JoinColumn(name = "idgr")
	private Grados 	idgr;
	
	@ManyToOne()
	@JoinColumn(name = "idmaes")
	private Administradores idmaes;

	public int getIdma() {
		return idma;
	}

	public void setIdma(int idma) {
		this.idma = idma;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Grados getIdgr() {
		return idgr;
	}

	public void setIdgr(Grados idgr) {
		this.idgr = idgr;
	}

	public Administradores getIdmaes() {
		return idmaes;
	}

	public void setIdmaes(Administradores idmaes) {
		this.idmaes = idmaes;
	}

	@Override
	public String toString() {
		return "Materia [idma=" + idma + ", nombre=" + nombre + ", idgr=" + idgr + ", idmaes=" + idmaes + "]";
	}
	
}
