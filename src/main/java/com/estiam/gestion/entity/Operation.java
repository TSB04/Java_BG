package com.estiam.gestion.entity;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OP",
discriminatorType = DiscriminatorType.STRING, length = 1)
public abstract class Operation {
	
	@Id
	@GeneratedValue
	private Long numOperation;
	
	@NonNull
	private LocalDate dateOperation;
	
	@NonNull
	private double montant;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name = "NUM_COMPTE")
	private Compte compte;

}
