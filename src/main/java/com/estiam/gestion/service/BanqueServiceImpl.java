
package com.estiam.gestion.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estiam.gestion.controller.errors.domain.MontantException;
import com.estiam.gestion.dao.ClientDao;
import com.estiam.gestion.dao.CompteDao;
import com.estiam.gestion.dao.OperationDao;
import com.estiam.gestion.entity.Client;
import com.estiam.gestion.entity.Compte;
import com.estiam.gestion.entity.CompteCourant;
import com.estiam.gestion.entity.Operation;
import com.estiam.gestion.entity.Retrait;
import com.estiam.gestion.entity.Versement;

@Service
public class BanqueServiceImpl implements BanqueService {
	@Autowired
	private ClientDao clientDao;

	@Autowired
	private CompteDao compteDao;

	@Autowired
	private OperationDao operationDao;

	@Override
	public Compte consulterCompte(String numCompte) {
		return compteDao.getById(numCompte);
	}

	@Override
	public Compte ajouterCompte(Compte compte) {
		return compteDao.save(compte);
	}

	@Override
	public List<Operation> consulterOperationsParCompte(String numCompte) {
		return operationDao.consulterOperationsParCompte(numCompte);
	}

	@Override
	public void verser(String numCompte, double montant) throws MontantException {
		if (montant <= 10_000 && montant > 0) {
			Compte compte = compteDao.getById(numCompte);
			compte.setSolde(compte.getSolde() + montant);
			LocalDate dateOperation = LocalDate.now();
			Operation v = new Versement();
			v.setCompte(compte);
			v.setDateOperation(dateOperation);
			v.setMontant(montant);
			operationDao.save(v);
			compteDao.saveAndFlush(compte);
		}else {
			throw new MontantException("montant sup a 10k ou inf a 0");
		}
	}

	@Override
	public void retirer(String numCompte, double montant) throws MontantException{
		if(montant > 0 && montant <= 3_000) {
			Compte compte = compteDao.getById(numCompte);
			if(compte instanceof CompteCourant) {
				LocalDate dateOperation = LocalDate.now();
				if(compte.getSolde() - montant > ((CompteCourant) compte).getDecouvert()) {
					Operation r = new Retrait();
					r.setCompte(compte);
					r.setDateOperation(dateOperation);
					r.setMontant(montant);
					operationDao.save(r);
					compte.setSolde(compte.getSolde() - montant);
					compteDao.saveAndFlush(compte);
				}
			}
		}else {
			throw new MontantException("montant doit etre inf a 3k ou sup a 0");
		}
	}

	@Override
	public void virement(String numCompteDebit, String numCompteCredit, double montant) throws MontantException{
		retirer(numCompteDebit, montant);
		verser(numCompteCredit, montant);
	}

	@Override
	public Client ajouterClient(Client client) {
		return clientDao.save(client);
	}

	@Override
	public List<Client> consulterLesClients() {
		return clientDao.findAll();
	}

	@Override
	public List<Client> rechercherClientsParMotCle(String motCle) {
		return clientDao.rechercheParMotCle(motCle);
	}

}
