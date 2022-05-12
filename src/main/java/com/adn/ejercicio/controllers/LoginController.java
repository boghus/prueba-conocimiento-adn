package com.adn.ejercicio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class LoginController {

	
	@GetMapping(value= {"/index", "/login"})
	public String getLogin() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (null != authentication && !("anonymousUser").equals(authentication.getName())){
			return "redirect:/inicio";
		}else {
			return "login";
		}
	}
}	