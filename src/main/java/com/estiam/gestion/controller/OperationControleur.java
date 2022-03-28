package com.estiam.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estiam.gestion.entity.Operation;
import com.estiam.gestion.service.BanqueService;

@RestController
@RequestMapping("/operations")
public class OperationControleur {
	
	@Autowired
	private BanqueService banqueService;
	
	@PostMapping("/verser")
	public void verser(String numCompte, double montant) throws Exception {
			banqueService.verser(numCompte, montant);

	}
	
	@PostMapping("/retirer")
	public void retirer(String numCompte, double montant) throws Exception {
			banqueService.retirer(numCompte, montant);
	}
	
	@PostMapping("/virement")
	public void virement(String numCompteDebit, String numCompteCredit, double montant) throws Exception {
			banqueService.virement(numCompteDebit, numCompteCredit, montant);

	}
	
	@GetMapping
	public List<Operation> consulterToutesLesOperations(@RequestParam String numCompte){
		return banqueService.consulterOperationsParCompte(numCompte);
	}

}
