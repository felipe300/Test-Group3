package com.desafiolatam.desafioservlet.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.desafioservlet.entities.UserDTO;
import com.desafiolatam.desafioservlet.facade.Facade;

/**
 * Servlet implementation class registerUser
 */
@WebServlet("/registerUser")
public class registerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
     
	   }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RECEPCION DE PARAMETROS
	      String name = request.getParameter("name");
	      String email = request.getParameter("email");
	      String pass = request.getParameter("pass");
	      
	       // instancio el DTO y le asigno los datos
	      UserDTO dto = new UserDTO();
	      
	      dto.setName(name);
	      dto.setEmail(email);
	      dto.setPass(pass);
	      
	      // invoco al facade
	      Facade facade = new Facade();
	        int id = 0;
			try {
				id = facade.registrarUsuario(dto);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	       // el resultado lo adjunto como atributo en el request
	      //request.setAttribute("idInsc", idInsc);
	      
	       // redirecciono el control hacia la siguiente vista,
	       // es decir: hacia su servlet de pre-procesamiento
	      request.getRequestDispatcher("/horoscopoList.jsp").forward(request, response);
	}

}
