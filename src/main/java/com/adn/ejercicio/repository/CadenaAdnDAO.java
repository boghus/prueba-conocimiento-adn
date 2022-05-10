package com.adn.ejercicio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adn.ejercicio.entities.CadenaAdn;

@Repository
public interface CadenaAdnDAO extends JpaRepository <CadenaAdn,Integer>{

	List<CadenaAdn> findAllByMutation(Boolean mutation);
	
}
