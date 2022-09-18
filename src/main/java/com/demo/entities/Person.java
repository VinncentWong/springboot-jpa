package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ID_GENERATOR")
	@TableGenerator(name = "ID_GENERATOR", allocationSize = 25)
	private Long personNumber;
	
	public void setPersonNumber(Long personNumber) {
		this.personNumber = personNumber;
	}
	
//	@Id
//	@GeneratedValue(generator = "ID_GENERATOR", strategy = GenerationType.TABLE) // specify nama tabel dari generator yang akan digunakan // generator = "nama_tabel_yang_akan_generate_primary_key"
////	@SequenceGenerator(name = "ID_GENERATOR", sequenceName = "GET_PERSON_NUMBER") // spesifikasi nama sequence_generator nya, nama kolom, dsb.
//	@TableGenerator(name = "ID_GENERATOR", allocationSize = 25) // speisfikasi nama dari tabel_generator nya
	public Long getPersonNumber() {
		return this.personNumber;
	}
	// @Id juga bisa ditaruh pada accessor atau mutator atau getter, nanti akan dipanggil oleh Hibernate
	// Dalam case tertentu seperti case ini, akan sangat membantu kalau pakai @Id di mutator
}
