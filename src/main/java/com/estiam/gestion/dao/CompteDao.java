package com.estiam.gestion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estiam.gestion.entity.Compte;

public interface CompteDao extends JpaRepository<Compte, String> {

}
