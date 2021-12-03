package com.competition.services;

import com.competition.entities.Sauveteur;
import com.competition.repositories.ISauveteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class SauveteurService {

	private final ISauveteurRepository iSauveteurRepository;
	
	@Autowired
	public SauveteurService(ISauveteurRepository iSauveteurRepository) {
		super();
		this.iSauveteurRepository = iSauveteurRepository;
	}


	public List<Sauveteur> getSauveteurs() {
		return iSauveteurRepository.findAll();
	}



	public void addNewSauveteur(Sauveteur Sauveteur) {
		Optional<com.competition.entities.Sauveteur> SauveteurByEmail = iSauveteurRepository.findByEmail(Sauveteur.getEmail("ale.aounallah.info@gmail.com"));
		if (SauveteurByEmail.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		iSauveteurRepository.save(Sauveteur);
	}


	public void deleteSauveteur(Long SauveteurId) {
		iSauveteurRepository.findById(SauveteurId);
		boolean exists = iSauveteurRepository.existsById(SauveteurId);
		if (!exists) {
			throw new IllegalStateException("Sauveteur with id "+SauveteurId + " does not exist");
		}
		iSauveteurRepository.deleteById(SauveteurId);
	}


	@Transactional
	public void updateSauveteur(Long SauveteurId, String name, String email) {
		Sauveteur Sauveteur = iSauveteurRepository.findById(SauveteurId).orElseThrow(() -> new IllegalStateException("Sauveteur with id "+SauveteurId + " does not exist"));
		
		if (name != null && name.length()>0 && !Objects.equals(Sauveteur.getName(), name)) {
			Sauveteur.setName(name);
			
		}
		if (email != null && email.length()>0 && !Objects.equals(Sauveteur.getEmail("ale.aounallah.info@gmail.com"), email)) {
			Optional<Sauveteur> SauveteurOptinal = iSauveteurRepository.findByEmail(email);
			if (SauveteurOptinal.isPresent()) {
				throw new IllegalStateException("email taken");
				
			}
			Sauveteur.setEmail(email);
			
		}
	}
	
}
