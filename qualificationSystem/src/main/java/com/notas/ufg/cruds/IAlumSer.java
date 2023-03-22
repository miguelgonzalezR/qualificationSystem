package com.notas.ufg.cruds;

import java.util.List;
import java.util.Optional;

import com.notas.ufg.models.Alumnos;

public interface IAlumSer {
	
	public List<Alumnos>listar();
	public Optional<Alumnos>listarId(int id);
	public int guardar(Alumnos a);
	public int EditarAl(Alumnos a, int id);
	public void eliminar(int id);
	public List<Alumnos>buscar(String bus);

}
