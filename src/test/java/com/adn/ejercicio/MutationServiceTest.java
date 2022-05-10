package com.adn.ejercicio;




import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.adn.ejercicio.services.MutationService;

class MutationServiceTest {

	@Autowired
	private MutationService mutationService;
	
	private String[] horizontal = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG","TTTTTT"};
	private String[] vertical = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCTTA"};
	private String[] diagonalUp = {"ATTAGA","AAGTGC","TTATGT","AGAAAG","CGCTTA"};
	private String[] diagonalDown = {"CGCTTA","AGAAAG","TTATGT","AAGTGC","ATTAGA"};
	private String[] numerico = {"100000","010000","001000","000100","000010","000001"};
	
	@Test
	void testHasMutation() {
		
		mutationService = new MutationService();
		
		assertTrue(mutationService.hasMutation(horizontal) );
		assertTrue(mutationService.hasMutation(vertical) );
		assertTrue(mutationService.hasMutation(diagonalUp) );
		assertTrue(mutationService.hasMutation(diagonalDown) );
		assertFalse(mutationService.hasMutation(numerico) );
		
	}
}
