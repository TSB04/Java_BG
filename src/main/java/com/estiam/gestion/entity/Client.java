package com.estiam.gestion.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Client {
	
	@Id
	@GeneratedValue
	private Long codeClient;
	
	@NonNull
	private String nomClient;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Compte> comptesClient;

}
