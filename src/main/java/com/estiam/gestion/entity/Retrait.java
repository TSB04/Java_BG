package com.estiam.gestion.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@DiscriminatorValue("R")
public class Retrait extends Operation {

}
