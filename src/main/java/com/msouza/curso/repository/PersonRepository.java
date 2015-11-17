package com.msouza.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msouza.curso.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	// busca por firstNa me maior que o valor informado
	List<Person> findByFirstNameGreaterThan(String firstName);
	
	// busca por age menor ou igual que so parametro
	List<Person> findByAgeLessThanEqual(Integer age);

	// busca por age maioe e igual ao parametro
	List<Person> findByAgeGreaterThanEqual(Integer age);

	// busca por age menor queo parametro
	List<Person> findByAgeLessThan(Integer age);

	// busca por age maior queo parametro
	List<Person> findByAgeGreaterThan(Integer age);

	// busca por lastName and age between
	List<Person> findByLastNameAndAgeBetween(String lastName, int min, int max);

	// busca por age usando between
	List<Person> findByAgeBetween(int min, int max);

	// busca por age or firstName via parametros
	List<Person> findByAgeOrFirstName(Integer age, String firstName);

	// busca por firstName and lastName via parametros
	Person findByFirstNameAndLastName(String firstName, String lastName);

	// busca por fistName igual ao parametro
	List<Person> findByFirstNameLike(String firstName);

	// busca por fistName diferente do parametro
	List<Person> findByFirstNameNotLike(String firstName);

	// busca por age igual ao parametro fornecido
	List<Person> findByAge(Integer age);

	// busca por age diferente do parametro fornecido
	List<Person> findByAgeNot(Integer age);

}
