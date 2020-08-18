package com.desafiolatam.proyect.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@SequenceGenerator(name="sq_role", initialValue = 1, allocationSize = 1, sequenceName = "sq_role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_role")
	private Integer idRole;
	private String roleName;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "role")
	List<Usuario> listaUsuario;
}