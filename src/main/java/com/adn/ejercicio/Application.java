package com.adn.ejercicio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.adn.ejercicio.entities.Usuario;
import com.adn.ejercicio.repository.UsuarioDAO;

@SpringBootApplication
public class Application {
	
	private static final String USERNAME = "admin";  

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean
    public CommandLineRunner init(UsuarioDAO usuarioDAO) {
        return args -> { 
        		
          	Usuario  usuario;
        	usuario = usuarioDAO.findByUsername(USERNAME);
        	
        	if (usuario == null) {
	    		
	    		usuario = new Usuario();
	    		usuario.setUsername(USERNAME);
	    		usuario.setPassword(USERNAME);
	    		usuarioDAO.save(usuario);
	    	}
        };
    }
	

}
