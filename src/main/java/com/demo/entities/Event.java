package com.demo.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Event {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	// strategy mengarah pada kelas Generator nya
	// Kelas nya itu menyediakan cara buat generate identifier, dalam kasus ini dia menyediakan cara buat generate UUID
	private UUID id;
}
