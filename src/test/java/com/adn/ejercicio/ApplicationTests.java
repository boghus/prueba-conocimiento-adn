package com.adn.ejercicio;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adn.ejercicio.controllers.MutableController;
import com.adn.ejercicio.services.MutationService;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	MutableController mutableController;
	
	@Autowired
	MutationService mutationService;
	
	@Test
	void contextLoads()throws Exception {
		 assertThat(mutableController).isNotNull();
	     assertThat(mutationService).isNotNull();
	
	}

}
