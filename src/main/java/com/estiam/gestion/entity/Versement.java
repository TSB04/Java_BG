package com.estiam.gestion.entity;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@DiscriminatorValue("V")
public class Versement extends Operation {
	

}
