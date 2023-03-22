package com.notas.ufg.cruds;

import java.util.List;
import java.util.Optional;

import com.notas.ufg.models.Administradores;

public interface Iadmincon {
	
	public List<Administradores>listar();
	public Optional<Administradores>listarId(int id);
	public int guardar(Administradores a);
	public int guardarm(Administradores a);
	public void eliminar(int id);
	public int editar(Administradores a, int id);
	public int recuco(Administradores a, int id, String clave);
	public List<Administradores>buscador(String usu, int ti);

}
