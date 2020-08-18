package com.desafiolatam.proyect.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Repository
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name="sq_usuario", initialValue = 1, allocationSize = 1, sequenceName = "sq_usuario")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_usuario")
	private Integer id_usuario;
	private String nombre;
	private String email;
	private String password;
	@ManyToOne
	@JoinColumn(name = "id_role", nullable = false)
	private Role role;
}