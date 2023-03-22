package com.notas.ufg.repocitorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.notas.ufg.models.Alumnos;
import com.notas.ufg.models.Grados;

@Repository
public interface IAlumnosRepo extends JpaRepository<Alumnos, Integer>{
	
	public List<Alumnos> findByIdal (int idgr);
	
	public List<Alumnos> findByIdgrado(Optional<Grados> gra);
	
	public Optional<Alumnos> findTopByOrderByIdalDesc();
	
	@Query("SELECT a From Alumnos a WHERE a.usuario LIKE %?1% or a.carnet LIKE %?1% or a.nombre LIKE %?1%")
	public List<Alumnos> FindByUsuarioAndCarnetAndNombre(String bus);

}
