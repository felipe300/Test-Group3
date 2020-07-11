package com.desafiolatam.desafioservlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.desafiolatam.desafioservlet.connection.DaoUtil;

public class AnimalDao {
	public void getListAnimal() throws Exception {
		Connection conn = null;
	
		// SELECT "idAnimal", "animalName", "animalYear" FROM pg."Animal";
		String sqlQuery = "SELECT \"idAnimal\", \"animalName\", \"animalYear\" FROM pg.\"Animal\";";
		
		conn = DaoUtil.getConnection("jdbc/DesafioServlet");
		PreparedStatement stmt = conn.prepareStatement(sqlQuery);
		ResultSet resultado = stmt.executeQuery();
		
	}
	
}
