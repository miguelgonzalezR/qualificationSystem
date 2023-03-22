package com.notas.ufg.repocitorios;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.notas.ufg.models.Grados;

@Repository
public interface IGradoR extends JpaRepository<Grados, Integer>{
	
	@Query("SELECT g From Grados g WHERE g.grado LIKE %?1% or g.seccion LIKE %?1% ")
	public List<Grados> FindByGradoAndSeccion(String buscar);
	
}
