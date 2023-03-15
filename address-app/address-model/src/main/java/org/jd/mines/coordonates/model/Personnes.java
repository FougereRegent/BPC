package org.jd.mines.coordonates.model;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

import java.lang.*;
import java.util.*;

@Entity
@Table(name = "Personnes")
public class Personnes {

	private long id;
	private String nom;
	private String prenom;
	private Date naissanceDate;
	private String telNumero;
	private String mail;


	@Id
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Column(name = "Prenom")
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name ="dateniassance")
	public Date getDate() {
		return naissanceDate;
	}

	public void setDate(Date naissanceDate) {
		this.naissanceDate = naissanceDate;
	}

	@Column(name = "numerotelephone")
	public String getTelNum() {
		return telNumero;
	}

	public void setTelNum(String telNumero) {
		this.telNumero = telNumero;
	}

	@Column(name = "mail")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
