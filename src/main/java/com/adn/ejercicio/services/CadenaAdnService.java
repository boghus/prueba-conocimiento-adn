package com.adn.ejercicio.services;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.math3.util.Precision;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import com.adn.ejercicio.entities.CadenaAdn;
import com.adn.ejercicio.repository.CadenaAdnDAO;

@Service
public class CadenaAdnService {
	
	static Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	
	CadenaAdnDAO cadenaAdnDAO;
	
	 public CadenaAdnService(CadenaAdnDAO cadenaAdnDAO) {
	        this.cadenaAdnDAO = cadenaAdnDAO;
	}
	
	public CadenaAdn create (CadenaAdn cadena) {
		return cadenaAdnDAO.save(cadena);
	}
	
	public Iterable<CadenaAdn> findAll(){
		return cadenaAdnDAO.findAll();
	}
	
	public Long  count() {
		return cadenaAdnDAO.count();
	}
	
	public Integer totalMutationTrue(){
		return cadenaAdnDAO.findAllByMutation(true).size();
	}	
	
	public Integer totalMutationFalse(){
		return cadenaAdnDAO.findAllByMutation(false).size();
	}
	
	
	public Map<String, Object> getStatus() {
		HashMap<String, Object> result = new HashMap<>();
		int numMutation = totalMutationTrue();
		int numNoMutation = totalMutationFalse();
		long ratio;
		
		try {
			 ratio = numMutation / numNoMutation;
	    }catch (ArithmeticException e) {
	    	 ratio = 0l;
		}
		
		result.put("count_mutations", numMutation);
		result.put("count_no_mutation",numNoMutation);
		result.put("ratio",Precision.round(ratio,2));
		
		return result;
		
	}


	public Map<String, Object> getMapMutation(Boolean mutation) {
		HashMap<String, Object> result = new HashMap<>();
		
		List<CadenaAdn> cadena = cadenaAdnDAO.findAllByMutation(mutation);
		result.put("total", cadena.size());
		result.put("data", cadena);
		return result;
		
	}

	public String[] generateRandomAdn(){

		Random r = 	new Random();

		int vLength = r.nextInt(10)+1;
		int hLength = r.nextInt(10)+1; 
		
		String[] adn =  new String[vLength];
		StringBuilder cadena;

		for (int i=0; i<vLength; i++){
			cadena = new StringBuilder();
			for(int j=0; j<hLength; j++){
				cadena.append(String.valueOf(r.nextInt(4)+1));
			}
			adn[i] = cadena.toString()
					.replace("1","A")
					.replace("2","T")
					.replace("3","G")
					.replace("4","C");
		}
		return adn; 
	} 
}
