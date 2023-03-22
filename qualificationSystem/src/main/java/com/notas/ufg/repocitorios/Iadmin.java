package com.notas.ufg.repocitorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.notas.ufg.models.Administradores;

public interface Iadmin extends JpaRepository<Administradores, Integer>{
	
	public List<Administradores> getByTipo(int tipo);
	
	public Optional<Administradores> getByUsuario(String usu);
	
	public List<Administradores> getByCorreo(String correo);
	
	@Query("SELECT a From administradores a WHERE a.usuario LIKE %?1%  and a.tipo = ?2")
	public List<Administradores> FindByUsuarioAndTipo(String usuario, Integer tipo);

}
