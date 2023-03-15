package org.jd.mines.persistance;

import org.jd.mines.coordonates.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface MaisonRepository extends JpaRepository<Maison, Long> {
	List<Maison> findAllByAdresse(Adresse adresse);
	Maison getById(Long id);
}
