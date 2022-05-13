package com.adn.ejercicio.controllers;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(value= "/getMutation")
	public ResponseEntity<Map<String, Object>> getMutation(){
		return ResponseEntity.ok(cadenaAdnService.getMapMutation(true));
	}
	
	@GetMapping(value= "/getNoMutation")
	public ResponseEntity<Map<String, Object>> getNoMutation(){
		return ResponseEntity.ok(cadenaAdnService.getMapMutation(false));
	}

}
