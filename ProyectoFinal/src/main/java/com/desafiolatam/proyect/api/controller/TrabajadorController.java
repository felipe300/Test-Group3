package com.desafiolatam.proyect.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiolatam.proyect.api.model.Trabajador;
import com.desafiolatam.proyect.api.repository.TrabajadorDAO;

@RestController
@RequestMapping("/api/auth")
public class TrabajadorController {
	@Autowired
	private TrabajadorDAO dao;
	
	@CrossOrigin
	@GetMapping("/trabajadores")
	public ResponseEntity<List<Trabajador>> getTrabajadores() {
		List<Trabajador> listaTrabajadores = (List<Trabajador>) dao.findAll();
		return ResponseEntity.ok(listaTrabajadores);
	}
	
	@CrossOrigin
	@RequestMapping(value="/trabajador/{trabajdorId}")
	public ResponseEntity<Trabajador> getTrabajadorById(@PathVariable("trabajdorId") Integer trabajdorId) {
		Optional<Trabajador> optionalTrabajador =  dao.findById(trabajdorId);
		if(optionalTrabajador.isPresent()) {
			return ResponseEntity.ok(optionalTrabajador.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@CrossOrigin
	@PostMapping("/trabajador")
	public ResponseEntity<Trabajador> createTrabajador(@RequestBody Trabajador trabajador) {
		Trabajador newTrabajador =  dao.save(trabajador);
		return ResponseEntity.ok(newTrabajador);
	}
	
	@CrossOrigin
	@PutMapping(value="/trabajador/{trabajdorId}")
	public ResponseEntity<Trabajador> updateTrabajador(@RequestBody Trabajador trabajador) {
		Optional<Trabajador> optionalTrabajador =  dao.findById(trabajador.getIdTrabajador());
		if(optionalTrabajador.isPresent()) {
			Trabajador updateTrabajador = optionalTrabajador.get();
			updateTrabajador.setNombreTrabajador(trabajador.getNombreTrabajador());
			dao.save(updateTrabajador);
			return ResponseEntity.ok(updateTrabajador);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@CrossOrigin
	@DeleteMapping(value="/trabajador/{trabajdorId}")
	public ResponseEntity<Void> deleteTrabajador(@PathVariable("trabajdorId") Integer trabajdorId) {
		dao.deleteById(trabajdorId);
		return ResponseEntity.ok(null);
	}
}
