package com.adn.ejercicio.controllers;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.ejercicio.entities.CadenaAdn;
import com.adn.ejercicio.repository.CadenaAdnDAO;
import com.adn.ejercicio.services.CadenaAdnService;


@CrossOrigin("*")
@RestController
@RequestMapping("/mutation")
public class MutableController {
	
	@Autowired
	private CadenaAdnService cadenaAdnService;
	
	CadenaAdnDAO cadenaAdnDAO;
	
	 public MutableController(CadenaAdnDAO cadenaAdnDAO) {
	        this.cadenaAdnDAO = cadenaAdnDAO;
	}
	
	
	@PostMapping(value= {"", "/index"})
	public ResponseEntity<Object> index(@RequestBody  Map<String, Object> params){
		
		List<String> dna =  (List<String>) params.get("dna");
				
		String[] cadenasAdn = new String[dna.size()];
		cadenasAdn = dna.toArray(cadenasAdn);
		
		boolean hasMutation = cadenaAdnService.create(new CadenaAdn(cadenasAdn)).getMutation();
			
		if (Boolean.TRUE.equals(hasMutation)) {
			return ResponseEntity.status(200).build();
		}else {
			return ResponseEntity.status(403).build();
		}	
	}
	
	@GetMapping(value= "/status")
	public ResponseEntity<Object> status(){
		return ResponseEntity.ok(cadenaAdnService.getStatus());
	}
}

