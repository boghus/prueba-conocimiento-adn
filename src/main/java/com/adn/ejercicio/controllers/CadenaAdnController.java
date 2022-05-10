package com.adn.ejercicio.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.ejercicio.entities.CadenaAdn;
import com.adn.ejercicio.services.CadenaAdnService;

@CrossOrigin("*")
@RestController
@RequestMapping("/cadenaAdn")
public class CadenaAdnController {
	
	@Autowired
	CadenaAdnService cadenaAdnService;
	
	@GetMapping(value= "/index")
	public ResponseEntity<Iterable<CadenaAdn>> index(){
		return ResponseEntity.ok(cadenaAdnService.findAll());
	}
	
	@PostMapping(value= "/create")
	public ResponseEntity<CadenaAdn> create(@RequestBody CadenaAdn cadena){
		CadenaAdn newCadena = new CadenaAdn(cadena.getCadenas());
		return ResponseEntity.ok(cadenaAdnService.create(newCadena));
	}

}
