package com.adn.ejercicio.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import com.adn.ejercicio.services.MutationService;


@Entity
public class CadenaAdn implements Serializable {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String[] cadenas;
	
	private Date dateCreated;
	
	private Boolean mutation;
	
	
	
	
	@PrePersist
	public void prePersist() {
		MutationService mutationService = new MutationService();
		this.mutation = mutationService.hasMutation(this.cadenas);
		this.dateCreated = new Date();
	}
	
	
	


	public CadenaAdn() {
	}
	
	
	
	public CadenaAdn(String[] cadenas) {
		super();
		this.cadenas = cadenas;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String[] getCadenas() {
		return cadenas;
	}
	public void setCadenas(String[] cadenas) {
		this.cadenas = cadenas;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}





	public Boolean getMutation() {
		return mutation;
	}





	public void setMutation(Boolean mutation) {
		this.mutation = mutation;
	}
}
