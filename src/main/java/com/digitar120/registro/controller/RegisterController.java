package com.digitar120.registro.controller;

import com.digitar120.registro.repository.InterfaceRepositorio;
import com.digitar120.registro.Registro;
import com.digitar120.registro.exception.RegisterNotFoundException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
	
	private final InterfaceRepositorio repositorio;
	
	RegisterController(InterfaceRepositorio repositorio){
		this.repositorio = repositorio;
	}
	
	// GET para todos los registros
	@GetMapping("/registros")
	List<Registro> all() {
		return repositorio.findAll();
	}
	
	// POST para inserción de un registro
	@PostMapping("/registros")
	Registro nuevoRegistro(@RequestBody Registro nuevoRegistro) {
		return repositorio.save(nuevoRegistro);
	}
	
	// GET para un registro específico
	@GetMapping("/registros/{id}")
	Registro one(@PathVariable Integer id) {
		return repositorio.findById(id).orElseThrow(() -> new RegisterNotFoundException(id));
	}
	
	// PUT para editar un registro
	@PutMapping("/registros/{id}")
	Registro editarRegistro(@RequestBody Registro nuevoRegistro, @PathVariable Integer id) {
		
		return repositorio.findById(id)
				.map(registro -> {
					registro.setTexto(nuevoRegistro.getTexto());
					return repositorio.save(registro);
				})
				.orElseGet(() -> {
					nuevoRegistro.setId(id);
					return repositorio.save(nuevoRegistro);
				});
	}
	
	@DeleteMapping("/registros/{id}")
	void removerRegistro(@PathVariable Integer id) {
		repositorio.deleteById(id);
	}
}



