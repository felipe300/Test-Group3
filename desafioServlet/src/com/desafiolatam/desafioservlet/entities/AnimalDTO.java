package com.desafiolatam.desafioservlet.entities;

public class AnimalDTO {
	// AnimalName, Year
	public int idAnimal;
	public String animalName;
	public String animalYear;
	
	//GETTERS AND SETTERS DE ANIMALDTO
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getAnimalYear() {
		return animalYear;
	}
	public void setAnimalYear(String animalYear) {
		this.animalYear = animalYear;
	}

}
