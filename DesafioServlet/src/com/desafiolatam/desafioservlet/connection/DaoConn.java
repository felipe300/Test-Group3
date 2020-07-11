package com.desafiolatam.desafioservlet.connection;

import java.sql.Connection;

public class DaoConn {
	String db_name = "desafioServlet";
	public String db_conn = "jdbc:postgresql://localhost:5432/" + db_name;
	String db_user = "postgres";
	String db_pass = "aiep1234";
	Connection conn = null;
}
