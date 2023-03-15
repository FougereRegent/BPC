package org.jd.mines.persistence;

import org.jd.mines.coordonates.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {
	
	List<Adresse> findAllByVille(Ville ville);
	List<Adresse> findAllByPays(Pays pays);
}
