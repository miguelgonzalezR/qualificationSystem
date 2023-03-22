package com.notas.ufg.alumnos.repocitorio.login;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.notas.ufg.alumnos.models.Alumno;

public interface AlumRepocitorio extends CrudRepository<Alumno, Long>{
	public Optional<Alumno> findByUsuario(String usuario);
}
