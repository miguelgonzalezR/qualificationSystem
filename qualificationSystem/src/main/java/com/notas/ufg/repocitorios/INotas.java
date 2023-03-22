package com.notas.ufg.repocitorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.notas.ufg.models.Notas;
import com.notas.ufg.models.Materia;

@Repository
public interface INotas extends JpaRepository<Notas, Integer>{
	
	public List<Notas> getByIdma (Optional<Materia> mater);
	
	@Query("SELECT n From Notas n WHERE n.alcar LIKE %?1% and n.idma = ?2 ")
	public List<Notas> FindByAlcarAndIdma(String buscar, Materia ma);
	
	@Query("SELECT n FROM Notas n where (n.tareap1 * 0.4) + (n.exap1 * 0.6)  >= 6 ")
	public List<Notas> aproP1();
	
	@Query("SELECT n FROM Notas n where (n.tareap2 * 0.4) + (n.exap2 * 0.6)  >= 6 ")
	public List<Notas> aproP2();
	
	@Query("SELECT n FROM Notas n where (n.tareap3 * 0.4) + (n.exap3 * 0.6)  >= 6 ")
	public List<Notas> aproP3();
	
	@Query("SELECT n FROM Notas n where (n.tareap4 * 0.4) + (n.tareap4 * 0.6)  >= 6 ")
	public List<Notas> aproP4();
	
	@Query("SELECT n FROM Notas n where (n.tareap1 * 0.4) + (n.exap1 * 0.6)  < 6 ")
	public List<Notas> rproP1();
	
	@Query("SELECT n FROM Notas n where (n.tareap2 * 0.4) + (n.exap2 * 0.6)  < 6 ")
	public List<Notas> rproP2();
	
	@Query("SELECT n FROM Notas n where (n.tareap3 * 0.4) + (n.exap3 * 0.6)  < 6 ")
	public List<Notas> rproP3();
	
	@Query("SELECT n FROM Notas n where (n.tareap4 * 0.4) + (n.exap4 * 0.6)  < 6 ")
	public List<Notas> rproP4();
	

}
