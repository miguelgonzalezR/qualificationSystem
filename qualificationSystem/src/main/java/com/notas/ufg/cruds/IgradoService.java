package com.notas.ufg.cruds;

import java.util.List;
import java.util.Optional;

import com.notas.ufg.models.Grados;

public interface IgradoService {
	
	public List<Grados>listar();
	public Optional<Grados>listarId(int id);
	public int guardar(Grados g);
	public void eliminar(int id);
	public List<Grados>buscar(String bus);

}
