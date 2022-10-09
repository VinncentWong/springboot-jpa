package com.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "email")
public class Message2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String content;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Email email;
	
}

/*
 * Intiny adalah ketika kita set itu cascade type ALL, maka nanti ketika parent melakukan save, nanti children nya SEMUA AKAN DISAVE BARENGAN
 * mappedBy digunakan untuk menentukan bidirectional relationship yang nantinya parent tau children nya dan juga children tau parent nya
*/
