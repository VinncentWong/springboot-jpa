package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ID_GENERATOR")
	private Long id;
}
