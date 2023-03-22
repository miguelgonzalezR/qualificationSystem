package com.notas.ufg.repocitorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.notas.ufg.models.Materia;
import com.notas.ufg.models.Administradores;
import com.notas.ufg.models.Alumnos;
import com.notas.ufg.models.Grados;

@Repository
public interface IMateriasRepo extends JpaRepository<Materia, Integer>{
	
	public List<Materia> findByIdgr(Optional<Grados> gra);
	
	public List<Materia> findByIdmaes(Optional<Administradores> ma);
	
	public List<Materia> findByIdmaesAndNombreLike(Optional<Administradores> ma, String bus);
	
	public Optional<Materia> findTopByOrderByIdmaDesc();
	
	@Query("SELECT m From Materia m WHERE m.nombre LIKE %?1%")
	public List<Materia> FindByNombre(String buscar);
	
	@Query("SELECT m FROM Materia m WHERE m.nombre LIKE %?1% ")
	public List<Materia> buscarmA(String bus);
	

}
