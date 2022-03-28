package com.estiam.gestion.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estiam.gestion.entity.Compte;
import com.estiam.gestion.service.BanqueService;

@RestController
@RequestMapping("/comptes")
public class CompteController {

	@Autowired
	private BanqueService banqueService;
	
	@PostMapping
	public Compte ajouterCompte(@RequestBody Compte compte) {
		return banqueService.ajouterCompte(compte);
	}

	@GetMapping
	public Compte consulterCompte(@RequestParam String numCompte){
		return banqueService.consulterCompte(numCompte);
	}
}
