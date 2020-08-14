package com.desafiolatam.proyect.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Repository;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="sq_trabajador", initialValue=1, allocationSize=1, sequenceName="sq_trabajador")
@Repository
public class Trabajador {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="sq_trabajador")
	private Integer idTrabajador;
	private String nombreTrabajador;
	private String email;
	private String password;
	private String oficio;
	private Integer nota;
}
