package com.desafiolatam.desafioservlet.facade;

import java.sql.SQLException;

import com.desafiolatam.desafioservlet.dao.UserDao;
import com.desafiolatam.desafioservlet.entities.UserDTO;

public class Facade {
	
	
	public int registrarUsuario(UserDTO dto) throws Exception {
		UserDao dao = new UserDao();
		return dao.insertUser(dto);
	}
	
	
}


