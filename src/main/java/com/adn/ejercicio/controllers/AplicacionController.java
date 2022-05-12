package com.adn.ejercicio.controllers;

import com.adn.ejercicio.services.CadenaAdnService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AplicacionController {

    @Autowired
	CadenaAdnService cadenaAdnService;

    @GetMapping(value= "/inicio")
	public String getInicio() {
        return "inicio";

    }

    @GetMapping(value= "/mutation")
    public String mutation() {
        return "mutation";
    }

    @GetMapping(value= "/noMutation")
    public String noMutation() {
        return "noMutation";
    } 
}
