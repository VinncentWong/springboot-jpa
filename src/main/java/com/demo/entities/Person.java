package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

	private String personNumber;
	
	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}
	
	@Id
	@GeneratedValue(generator = "uuid")
	public String getPersonNumber() {
		return this.personNumber;
	}
	// @Id juga bisa ditaruh pada accessor atau mutator atau getter, nanti akan dipanggil oleh Hibernate
	// Dalam case tertentu seperti case ini, akan sangat membantu kalau pakai @Id di mutator
}
