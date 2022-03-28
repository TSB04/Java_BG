package com.estiam.gestion.service;

import java.util.List;

import com.estiam.gestion.controller.errors.domain.MontantException;
import com.estiam.gestion.entity.Client;
import com.estiam.gestion.entity.Compte;
import com.estiam.gestion.entity.Operation;

public interface BanqueService {
	
	Compte consulterCompte(String numCompte);
	Compte ajouterCompte(Compte compte);
	List<Operation> consulterOperationsParCompte(String numCompte);
	void verser(String numCompte, double montant) throws MontantException;
	void retirer(String numCompte, double montant) throws MontantException;
	void virement(String numCompteDebit, String numCompteCredit, double montant) throws MontantException;
	Client ajouterClient(Client client);
	List<Client> consulterLesClients();
	List<Client> rechercherClientsParMotCle(String motCle);

}
