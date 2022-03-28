package com.estiam.gestion.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Benali
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COMPTE",
discriminatorType = DiscriminatorType.STRING, length = 2)// "CC" "CE"
public abstract class Compte {
	
	@Id
	@NonNull
	private String numCompte;
	
	@NonNull
	private LocalDate dateCreation;
	
	private double solde;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name = "CODE_CLIENT")
	private Client client;
	
	@OneToMany(mappedBy = "compte")
	private List<Operation> operations;

}
