package com.notas.ufg.cruds;

import java.util.List;
import java.util.Optional;

import com.notas.ufg.models.Administradores;
import com.notas.ufg.models.Materia;

public interface IMateSer {
	
	public List<Materia>listar();
	public Optional<Materia>listarId(int id);
	public int guardar(Materia a);
	public int EditarAl(Materia a, int id);
	public void eliminar(int id);
	public List<Materia>Buscar(String bus);
	

}
