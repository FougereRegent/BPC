package org.jd.mines.coordonates.model;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;
import lombok.Data;

import java.lang.*;
import java.util.*;

@Entity
@Table(name = "Personnes")
public class Personnes {

	@Id
	private long id;
	private String nom;
	private String prenom;
	private Date naissanceDate;
	private String telNumero;
	private String mail;
}
