package com.estiam.gestion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.estiam.gestion.entity.Client;

@Repository
public interface ClientDao extends JpaRepository<Client, Long>{

	//CRUD
	
	//HQL
	
	/**
	 * on recherche tous les clients par mot cle
	 * @param motCle
	 * @return une liste de clients
	 */
	@Query("select c from Client c where c.nomClient like %:motCle%")
	public List<Client> rechercheParMotCle(@Param("motCle") String motCle);
}
