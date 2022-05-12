package com.adn.ejercicio.controllers;

import com.adn.ejercicio.services.CadenaAdnService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AplicacionController {

    @Autowired
	CadenaAdnService cadenaAdnService;

    @RequestMapping("/inicio")
	public String getInicio() {
        return "inicio";

    }

    @RequestMapping("/mutation")
    public String mutation() {
        return "mutation";
    }

    @RequestMapping("/noMutation")
    public String noMutation() {
        return "noMutation";
    } 
}
