package com.notas.ufg.crud;

import com.notas.ufg.alumnos.models.Alumno;

public interface IAlumSer {
	
	public int EditarAl(Alumno a, int id);
	public int recu(Alumno a, int id, String clave);

}
