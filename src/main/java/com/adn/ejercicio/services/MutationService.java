package com.adn.ejercicio.services;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class MutationService {
	
	static Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	public boolean hasMutation(String[] dna) {
		
		String[][] matrixDna = generateMatrix(dna);
		String[][] matrixReverse = generateMatrix(reverseDna(dna));
		
		if (findHorizontalMutation(dna)) {
			log.debug("mutacion horizontal: true");
			return true;
		}
		
		if(findVerticalMutation(matrixDna)) {
			log.debug("mutacion vertical: true");
			return true;
		}
		
		if(findDiagonalMutation(matrixDna)) {
			log.debug("mutacion diagonal up: true");
			return true;
		}
		
			
		if(findDiagonalMutation(matrixReverse)) {
			log.debug("mutacion diagonal down: true");
			return true;
		}
		
		return false;
	}
	
	
	
	public boolean findHorizontalMutation (String[] dna) {
		log.debug("busca de forma horizontal ...");
		for(String cadena  :  dna) {
			if (findMutation(cadena)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean findVerticalMutation(String[][] matrix) {
		log.debug("busca de forma vertical ...");
		
		Map<Integer, String> cadenas = generateCadenaVertical(matrix);
		for (Map.Entry<Integer,String> entry : cadenas.entrySet()) {
			if (findMutation(entry.getValue())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean findDiagonalMutation(String[][] matrix) {
		log.debug("busca de forma diagonal ...");
		Map	<Integer, String> cadenas = generateCadenaDiagnonal(matrix);
		for (Map.Entry<Integer,String> entry : cadenas.entrySet()) {
			if (findMutation(entry.getValue())) {
				return true;
			}
		}
		return false;
	}
	
	public String[] reverseDna (String[]adn) {
		
		String[] reverseDna = new String[adn.length];
		StringBuilder reverseCadena ;
	    
	    for (Integer i =0; i<adn.length; i++) {
	    	reverseCadena = new StringBuilder();
	    	reverseCadena.append(adn[i]);
	    	reverseDna[i] = reverseCadena.reverse().toString();
	   }
		
	    return reverseDna;
	}
	
	
	public String[][]  generateMatrix(String[]adn) {
		
		int n = adn.length; 
	    int m = adn[0].length();

	    String[][] matrix = new String[n][m];
	    
	    for (Integer i=0; i<n ; i++) {
	    	for (Integer j=0; j<m ; j++) {
	    		matrix[i][j] =String.valueOf(adn[i].charAt(j));
	    	}
	    }
	    
	    return matrix ;
	}   
	

		
	public Map<Integer, String> generateCadenaVertical(String[][] matrix) {
		
		HashMap<Integer, String> cadenasAdn = new HashMap<>();
				
		for (Integer r = 0; r < matrix.length; r++) {  
			for (Integer c = 0; c < matrix[r].length; c++) { 
							
				if (cadenasAdn.get(c) == null) {
					cadenasAdn.put(c,  matrix[r][c]);
				}else {
					cadenasAdn.put(c, cadenasAdn.get(c) + matrix[r][c]);
				}
		    }           
		}
		
		return cadenasAdn;
	}
	
	public Map<Integer, String>  generateCadenaDiagnonal(String[][] matrix) {
		
		int numberRow = matrix[0].length; 
	    int numerCol = matrix.length;
	    int i = 0;
		
	    HashMap<Integer, String> cadenasAdn = new HashMap<>();
		
		for( int k = 0 ; k <= numberRow + numerCol - 2; k++ ) {
	        for( int j = 0 ; j <= k ; j++ ) {
	            i = k - j;
	            if( i < numerCol && j < numberRow ) {
	                if (cadenasAdn.get(k) == null) {
						cadenasAdn.put(k,  matrix[i][j]);
					}else {
						cadenasAdn.put(k, cadenasAdn.get(k) + matrix[i][j]);
					}
	            }
	        }
	       
	    }
		return cadenasAdn;
	}
	
	
	public boolean findMutation(String cadena) {
		
		Pattern pat = Pattern.compile(".*T{4}|A{4}|C{4}|G{4}.*");
	    Matcher mat = pat.matcher(cadena.toUpperCase());   
	    
	    return mat.find();
	}

}
