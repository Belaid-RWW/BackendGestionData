package com.competition.controllers;

import com.competition.entities.Sauveteur;
import com.competition.services.SauveteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/Sauveteur")

public class SauveteurController {

	
	private final com.competition.services.SauveteurService SauveteurService;
	@Autowired
	public SauveteurController(SauveteurService SauveteurService) {
		super();
		this.SauveteurService = SauveteurService;
	}

	@GetMapping("/getsauveteurs")
	public List<Sauveteur> getSauveteurs() {
		return SauveteurService.getSauveteurs();
	}
	
	@PostMapping("/register")
	public void registreNewSauveteur(@RequestBody Sauveteur Sauveteur) {
		 SauveteurService.addNewSauveteur(Sauveteur);
	}
	
	@DeleteMapping(path = "{SauveteurId}")
	public void deleteSauveteur(@PathVariable("SauveteurId") Long SauveteurId) {
		SauveteurService.deleteSauveteur(SauveteurId);
	}
	
	@PutMapping(path = "{SauveteurId}")
	public void updateSauveteur(@PathVariable("SauveteurId") Long SauveteurId,@RequestParam(required = false) String name,@RequestParam(required = false) String email) {
		SauveteurService.updateSauveteur(SauveteurId,name,email);
	}
}
