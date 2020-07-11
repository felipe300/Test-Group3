package com.desafiolatam.desafioservlet.connection;

import java.sql.Connection;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public final class DaoUtil {
	private static Connection conexion = null;
	private static DataSource ds = null;

	public static Connection getConnection(String dsName) throws Exception{
		Context initContext;
		if (conexion == null) {
			try {
				initContext = new InitialContext();
				ds = (DataSource) initContext.lookup("java:/comp/env/" + dsName);
				if ( ds == null ) {
					throw new Exception("No se encuentra el datasource!");
				}
				conexion = ds.getConnection();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conexion;
		}else {
			return conexion;
		}
	}
	
	public static void closeConnection() throws SQLException{
		// TODO Auto-generated method stub
		if(ds != null) {
			ds = null;
		}
		
		if(conexion != null) {
			conexion.close();
			conexion = null;
		}
	}
}
