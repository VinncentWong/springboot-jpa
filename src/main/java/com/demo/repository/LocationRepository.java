package com.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long>{}
