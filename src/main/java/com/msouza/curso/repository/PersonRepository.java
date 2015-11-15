package com.msouza.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msouza.curso.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
