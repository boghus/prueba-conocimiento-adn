package com.adn.ejercicio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adn.ejercicio.entities.Usuario;
import com.adn.ejercicio.repository.UsuarioDAO;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Usuario usuario = usuarioDAO.findByUsername(username);
		
		 if (usuario == null)
	            throw new UsernameNotFoundException(username);
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("USER"));
		
		
		return new User (usuario.getUsername(), usuario.getPassword(), roles);
	}

	
	

}
