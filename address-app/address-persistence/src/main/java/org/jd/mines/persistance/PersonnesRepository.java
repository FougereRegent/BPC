package org.jd.mines.persistance;

import org.jd.mines.coordonates.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PersonnesRepository extends JpaRepository<Personnes, Long> {
	List<Personnes> findAllByNom(String nom);
	List<Personnes> findAllByNomAndPrenom(String nom, String prenom);
}
