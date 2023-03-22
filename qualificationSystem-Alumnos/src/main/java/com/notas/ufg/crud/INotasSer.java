package com.notas.ufg.crud;

import java.util.List;

import com.notas.ufg.alumnos.models.Notas;

public interface INotasSer {
	
	public List<Notas>listar(int id);

}
