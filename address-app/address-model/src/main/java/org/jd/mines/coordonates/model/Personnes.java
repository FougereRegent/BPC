package org.jd.mines.coordonates.model;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

import java.lang.*;

@Entity
@Table(name = "Personnes")
public class Personnes {

	@Id
	private long id;
}
