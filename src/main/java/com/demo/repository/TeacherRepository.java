package com.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long>{}
