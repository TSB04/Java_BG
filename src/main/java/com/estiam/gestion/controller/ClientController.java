package com.estiam.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estiam.gestion.entity.Client;
import com.estiam.gestion.service.BanqueService;
/**
 * 
 * @author TSB
 * 
 * Le controleur
 *
 */
@RestController
@RequestMapping("/clients")
public class ClientController {
	

	@Autowired
	private BanqueService banqueService;
	//localhost:8080/clients 
	
	@PostMapping
	public Client ajouterClient(@RequestBody Client client) {
		return banqueService.ajouterClient(client);
	}
	
	//localhost:8080/clients
	@GetMapping
	public List<Client> afficherClients(){
		System.out.println("je suis dans afficherClients()");
		return banqueService.consulterLesClients();
	}
	
	//localhost:8080/clients?MotCle=
	@GetMapping("/recherche")
	public List<Client> rechercheparMotCle(@RequestParam String motCle){
		System.out.println("Le mot cle est :" + motCle);
		return banqueService.rechercherClientsParMotCle(motCle);
	}

}
