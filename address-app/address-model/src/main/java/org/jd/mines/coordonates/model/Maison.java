package org.jd.mines.coordonates.model;

import jakarta.persistence.*;
import org.hibernate.annotations.*;

import java.util.*;
import java.util.UUID;

import org.jd.mines.coordonates.model.*;

public class Maison {
	private Long id;
	private String type;
	private List<Personnes> personnes;
	private Date constructionDate;
	private Adresse adresse;

	@Id
	public Long getId() {
		return id;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToMany
	public List<Personnes> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personnes> personnes) {
		this.personnes = personnes;
	}

	@Column(name = "dateconstruction")
	public Date getDateConstruction() {
		return constructionDate;
	}

	public void setDateConstruction(Date constructionDate) {
		this.constructionDate = constructionDate;
	}

	@OneToOne
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
}
