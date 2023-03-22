package com.notas.ufg.cruds;

import java.util.List;
import java.util.Optional;

import com.notas.ufg.models.Fechaed;

public interface IFechasSer {
	
	
	public List<Fechaed>listar();
	public Optional<Fechaed>listarId(int id);
	public int guardar(Fechaed p);
	

}
