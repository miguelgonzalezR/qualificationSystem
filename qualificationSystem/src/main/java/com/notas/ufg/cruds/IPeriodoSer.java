package com.notas.ufg.cruds;

import java.util.List;
import java.util.Optional;

import com.notas.ufg.models.Periodo;

public interface IPeriodoSer {
	
	public List<Periodo>listar();
	public Optional<Periodo>listarId(int id);
	public int guardar(Periodo p);

}
