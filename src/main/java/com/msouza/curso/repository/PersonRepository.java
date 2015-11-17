package com.msouza.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msouza.curso.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	// busca por fistName igual ao parametro
	List<Person> findByFirstNameLike(String firstName);

	// busca por fistName diferente do parametro
	List<Person> findByFirstNameNotLike(String firstName);

	// busca por age igual ao parametro fornecido
	List<Person> findByAge(Integer age);

	// busca por age diferente do parametro fornecido
	List<Person> findByAgeNot(Integer age);

}
