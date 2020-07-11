package com.desafiolatam.desafioservlet.connection;

import java.sql.DriverManager;

public class Connect {
	public Connect getConnection(Connect conn) throws Exception{
		DaoConn dc = new DaoConn();
		Class.forName("org.postgresql.Driver");
		conn = (Connect) DriverManager.getConnection(dc.db_conn, dc.db_user, dc.db_pass);
		return conn;
	}
	
	public Connect closeConnection(Connect conn) throws Exception{
		if (conn != null) ((java.sql.Connection) conn).close();
		return conn;
	}
}
