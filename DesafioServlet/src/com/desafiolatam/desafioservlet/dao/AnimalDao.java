package com.desafiolatam.desafioservlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.desafioservlet.connection.DaoUtil;
import com.desafiolatam.desafioservlet.entities.AnimalDTO;

public class AnimalDao {
	public List getListAnimal() throws Exception {
		List<AnimalDTO> listaAnimal = new ArrayList<AnimalDTO>();
		Connection conn = null;
	
		// SELECT "idAnimal", "animalName", "animalYear" FROM pg."Animal";
		String sqlQuery = "SELECT \"idAnimal\", \"animalName\", \"animalYear\" FROM pg.\"Animal\";";
		
		conn = DaoUtil.getConnection("jdbc/DesafioServlet");
		
		try(PreparedStatement stmt = conn.prepareStatement(sqlQuery)){
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next()) {
				AnimalDTO animal = new AnimalDTO();
				animal.setIdAnimal(resultado.getInt("idInscripcion"));
				animal.setAnimalName(resultado.getString("nombre"));
				animal.setAnimalYear(resultado.getString("telefono"));
				
				listaAnimal.add(animal);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("A ocurrido un error inesperado" + ex);
		}
		return listaAnimal;
	}
	
}
