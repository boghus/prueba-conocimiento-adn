package com.adn.ejercicio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class LoginController {

	
	@RequestMapping("/login")
	public String getLogin() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (null != authentication && !("anonymousUser").equals(authentication.getName())){
			return "redirect:/inicio";
		}else {
			return "login";
		}
	}
}	