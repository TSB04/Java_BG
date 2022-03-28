package com.estiam.gestion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.estiam.gestion.entity.Operation;

public interface OperationDao extends JpaRepository<Operation, Long>{

	//CRUD
	
	//HQL
	/**
	 * Retourne les operations d'un compte par numero de compte
	 * 
	 * @param numCompte
	 * @return une liste d'operations
	 */
	@Query("select o from Operation o where o.compte.numCompte = :x order by o.dateOperation desc")
	List<Operation> consulterOperationsParCompte(@Param("x") String numCompte);
}
