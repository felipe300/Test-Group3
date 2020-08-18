package com.desafiolatam.proyect.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafiolatam.proyect.api.model.Usuario;

import com.desafiolatam.proyect.api.repository.UsuarioDAO;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UsuarioDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//return new User("foo", "foo", new ArrayList<>());
		List<Usuario> listaUsuario = dao.findByEmail(email);
		Usuario usuario = null;
		UserBuilder builder = null;
		
		if (listaUsuario == null || listaUsuario.size() != 1) 
			throw new UsernameNotFoundException(email);
		else {
			usuario = listaUsuario.get(0);
			builder = org.springframework.security.core.userdetails.User.withUsername(usuario.getEmail());
		    builder.password(new BCryptPasswordEncoder().encode(usuario.getPassword()));
		    String[] roles = {usuario.getRole().getRoleName()};
		    builder.roles(roles);
		}
		
		return builder.build();
	}
}
