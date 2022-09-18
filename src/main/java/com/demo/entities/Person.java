package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Person {

	private String personNumber;
	
	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}
	
	@Id
	@GeneratedValue(generator = "ID_GENERATOR") // specify nama dari generator yang akan digunakan
	@SequenceGenerator(name = "ID_GENERATOR", sequenceName = "GET_PERSON_NUMBER")
	public String getPersonNumber() {
		return this.personNumber;
	}
	// @Id juga bisa ditaruh pada accessor atau mutator atau getter, nanti akan dipanggil oleh Hibernate
	// Dalam case tertentu seperti case ini, akan sangat membantu kalau pakai @Id di mutator
}
