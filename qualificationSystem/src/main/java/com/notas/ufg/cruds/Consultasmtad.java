package com.notas.ufg.cruds;

import java.util.List;
import java.util.Optional;

import com.notas.ufg.models.Administradores;

public interface Consultasmtad {
	
	public List<Administradores>listar();
	public Optional<Administradores>listarId(int id);
	public int guardar(Administradores a);
	public void eliminar(int id);
}
