package org.jd.mines.persistance;

import org.jd.mines.coordonates.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PaysRepository extends JpaRepository<PaysRepository, Long> {
	PaysRepository getById(Long id);
	Pays getByNom(String nom);
}

