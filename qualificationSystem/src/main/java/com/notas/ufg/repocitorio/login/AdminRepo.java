package com.notas.ufg.repocitorio.login;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.notas.ufg.models.Administradores;

@Repository
public interface AdminRepo extends CrudRepository<Administradores, Long>{
	public Optional<Administradores> findByUsuario(String usuario);
}
