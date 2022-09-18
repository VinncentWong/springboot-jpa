package com.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{}
