package com.desafiolatam.desafioservlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.desafiolatam.desafioservlet.connection.DaoUtil;
import com.desafiolatam.desafioservlet.entities.UserDTO;

public class UserDao {
	
	public int insertUser(UserDTO dto) throws Exception{
		int resultado = 0;
		
		String sql = "INSERT INTO pg.Usuario (name, email, pass, isAdmin) VALUES (?, ?, ?, ?)";
		
		Connection conexion = null;
		conexion = DaoUtil.getConnection("jdbc/DesafioServlet");
		
		try(PreparedStatement stmt = conexion.prepareStatement(sql)){
			
			stmt.setString(1, dto.getName());
			stmt.setString(2, dto.getEmail());
			stmt.setString(3, dto.getPass());
			stmt.setBoolean(4,dto.isAdmin());
				
			//resultado = stmt.executeQuery();
			resultado = stmt.executeUpdate();
				
			if(stmt.executeUpdate() !=1) {
				throw new RuntimeException("A ocuurido un error inesperado" );
			}	
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("A ocuurido un error inesperado " +ex);
		}
		
		return resultado;		
	}

}
