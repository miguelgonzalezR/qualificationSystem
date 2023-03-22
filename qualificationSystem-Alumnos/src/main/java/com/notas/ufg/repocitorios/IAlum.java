package com.notas.ufg.repocitorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.ufg.alumnos.models.Alumno;

@Repository
public interface IAlum extends JpaRepository<Alumno, Integer>{
	
	public Optional<Alumno> getByUsuario(String user);
	
	public Optional<Alumno> getByCorreo(String correo);

}
