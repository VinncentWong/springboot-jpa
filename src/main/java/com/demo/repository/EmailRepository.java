package com.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Email;

@Repository
public interface EmailRepository extends CrudRepository<Email, Long>{}
