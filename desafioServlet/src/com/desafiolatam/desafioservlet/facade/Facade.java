package com.desafiolatam.desafioservlet.facade;

import java.util.List;

import com.desafiolatam.desafioservlet.dao.AnimalDao;
import com.desafiolatam.desafioservlet.dao.UserDao;
import com.desafiolatam.desafioservlet.entities.UserDTO;

public class Facade {
	
	public int registrarUsuario(UserDTO dto) throws Exception {
		UserDao dao = new UserDao();
		return dao.insertUser(dto);
	}
	
	public List getListAnimal() throws Exception {
		AnimalDao dao = new AnimalDao();
		return dao.getListAnimal();
	}
}


