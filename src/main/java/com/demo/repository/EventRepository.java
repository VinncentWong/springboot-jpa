package com.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{}
