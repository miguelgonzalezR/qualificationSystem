package com.notas.ufg.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.ufg.alumnos.models.Notas;
import com.notas.ufg.repocitorios.INotasA;
import com.notas.ufg.repocitorios.IAlum;
import com.notas.ufg.alumnos.models.Alumno;

@Service
public class NotasImpl implements INotasSer{
	
	@Autowired
	private INotasA notas;
	
	@Autowired
	private IAlum alm;

	@Override
	public List<Notas> listar(int id) {
		Optional<Alumno> alu = alm.findById(id);
		
		
		return (List<Notas>)notas.getByIdal(alu);
	}

}
