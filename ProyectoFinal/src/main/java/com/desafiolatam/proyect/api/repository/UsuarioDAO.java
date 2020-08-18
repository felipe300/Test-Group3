package com.desafiolatam.proyect.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.desafiolatam.proyect.api.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	public List<Usuario> findByEmail(String email);
}
