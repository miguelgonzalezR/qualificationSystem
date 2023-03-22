package com.notas.ufg.repocitorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.notas.ufg.models.Periodo;

@Repository
public interface IPeriodo extends JpaRepository<Periodo, Integer>{
	
	public Optional<Periodo> findTopByOrderByIdprDesc();

}
