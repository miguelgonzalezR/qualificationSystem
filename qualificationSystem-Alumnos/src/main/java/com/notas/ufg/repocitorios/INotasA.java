package com.notas.ufg.repocitorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.ufg.alumnos.models.Notas;
import com.notas.ufg.alumnos.models.Alumno;

@Repository
public interface INotasA extends JpaRepository<Notas, Integer>{
	
	public List<Notas> getByIdal (Optional<Alumno> alm);

}
