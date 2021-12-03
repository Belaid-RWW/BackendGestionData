package com.competition.repositories;

import com.competition.entities.Sauveteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ISauveteurRepository extends JpaRepository<Sauveteur, Long> {

	@Query("select s from Sauveteur s where s.email = ?1")
	Optional<Sauveteur> findByEmail(String email);

}
