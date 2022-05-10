package com.adn.ejercicio.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adn.ejercicio.entities.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository <Usuario,Integer>{

	Usuario findByUsername(String username);
	
}
