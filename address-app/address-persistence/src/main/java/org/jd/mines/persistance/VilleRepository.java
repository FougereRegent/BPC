package org.jd.mines.persistance;

import org.jd.mines.coordonates.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface VilleRepository extends JpaRepository<Ville, Long> {
	Ville getByNom(String nom);
	Ville getById(Long id);
}
