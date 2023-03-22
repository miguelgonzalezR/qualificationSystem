package com.notas.ufg.repocitorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.ufg.models.Administradores;

@Repository
public interface ValiAd extends JpaRepository<Administradores, Integer>{
	
	public Optional<Administradores> getByCorreo(String corr);

}
