package com.notas.ufg.cruds;

import java.util.List;
import java.util.Optional;

import com.notas.ufg.models.Notas;

public interface INotasSer {
	
	public List<Notas>listar();
	public List<Notas>verPorMaterias(int id);
	public Optional<Notas>listarId(int id);
	public int guardar(Notas a, String ca);
	public int EditarNo(Notas n, int id, String ca);
	public int EditarNo2(Notas n, int id, String ca);
	public int EditarNo3(Notas n, int id, String ca);
	public int EditarNo4(Notas n, int id, String ca);
	public void eliminar(int id);
	
	public void guardart(int idm, int ida, String ca);
	
	public List<Notas>buscar(int ma,String car, int al);
}
