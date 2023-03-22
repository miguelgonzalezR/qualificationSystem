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
@Table(name="notas")
public class Notas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idno;
	
	@Column	
	private double tareap1;
	
	@Column 
	private double 	exap1;
	
	@Column
	private double tareap2;
	
	@Column
	private double exap2;
	
	@Column
	private double tareap3;
	
	@Column
	private double exap3;
	
	@Column
	private double tareap4;
	
	@Column
	private double exap4;
	
	@Column
	private double notaf;
	
	@Column
	private String alcar;
	
	@ManyToOne()
	@JoinColumn(name = "idma")
	private Materia idma;
	
	@ManyToOne()
	@JoinColumn(name = "idal")
	private Alumnos idal;

	public Integer getIdno() {
		return idno;
	}

	public void setIdno(Integer idno) {
		this.idno = idno;
	}

	public double getTareap1() {
		return tareap1;
	}

	public void setTareap1(double tareap1) {
		this.tareap1 = tareap1;
	}

	public double getExap1() {
		return exap1;
	}

	public void setExap1(double exap1) {
		this.exap1 = exap1;
	}

	public double getTareap2() {
		return tareap2;
	}

	public void setTareap2(double tareap2) {
		this.tareap2 = tareap2;
	}

	public double getExap2() {
		return exap2;
	}

	public void setExap2(double exap2) {
		this.exap2 = exap2;
	}

	public double getTareap3() {
		return tareap3;
	}

	public void setTareap3(double tareap3) {
		this.tareap3 = tareap3;
	}

	public double getExap3() {
		return exap3;
	}

	public void setExap3(double exap3) {
		this.exap3 = exap3;
	}

	public double getTareap4() {
		return tareap4;
	}

	public void setTareap4(double tareap4) {
		this.tareap4 = tareap4;
	}

	public double getExap4() {
		return exap4;
	}

	public void setExap4(double exap4) {
		this.exap4 = exap4;
	}

	public Materia getIdma() {
		return idma;
	}

	public void setIdma(Materia idma) {
		this.idma = idma;
	}

	public Alumnos getIdal() {
		return idal;
	}

	public void setIdal(Alumnos idal) {
		this.idal = idal;
	}

	public double getNotaf() {
		return notaf;
	}

	public void setNotaf(double notaf) {
		this.notaf = notaf;
	}
	

	public String getAlcar() {
		return alcar;
	}

	public void setAlcar(String alcar) {
		this.alcar = alcar;
	}

	@Override
	public String toString() {
		return "Notas [idno=" + idno + ", tareap1=" + tareap1 + ", exap1=" + exap1 + ", tareap2=" + tareap2 + ", exap2="
				+ exap2 + ", tareap3=" + tareap3 + ", exap3=" + exap3 + ", tareap4=" + tareap4 + ", exap4=" + exap4
				+ ", notaf=" + notaf + ", alcar=" + alcar + ", idma=" + idma + ", idal=" + idal + "]";
	}
	
}
