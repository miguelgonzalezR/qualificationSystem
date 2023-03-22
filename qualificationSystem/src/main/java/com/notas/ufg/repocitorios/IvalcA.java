package com.notas.ufg.repocitorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.ufg.models.Alumnos;

@Repository
public interface IvalcA extends JpaRepository<Alumnos, Integer>{
	
	public List<Alumnos> getByCarnet(String tipo);
	
	public List<Alumnos> getByUsuario(String usu);
	
	public List<Alumnos> getByCorreo(String correo);

}
