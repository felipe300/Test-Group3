package com.desafiolatam.desafioservlet.entities;

public class UserDTO {
	// idUser, name, age, email, birthday, isAdmin, userName, pass
	
	public int idUser;
	public String name;
	public String email;
	public String pass;
	public boolean isAdmin;
	
	//GETTERS AND SETTERS DE USERDTO
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isAdmin() {
		//isAdmin = false;
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	
	
	
	
}
