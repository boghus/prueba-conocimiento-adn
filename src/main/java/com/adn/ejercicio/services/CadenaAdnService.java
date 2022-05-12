package com.adn.ejercicio.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		double ratio;
		
		try {
			 ratio = (double) numMutation / numNoMutation;
	    }catch (ArithmeticException e) {
	    	 ratio = 0;
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
}
