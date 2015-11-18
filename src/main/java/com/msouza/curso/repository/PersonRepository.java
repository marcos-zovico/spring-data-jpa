package com.msouza.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.msouza.curso.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("select p from Person p where p.firstName in :names order by p.age asc")
	List<Person> findByFirstNames(@Param("names") String... firstNames);
	
	@Query("select p from Person p where p.age >= :min and p.age <= :max")
	List<Person> findByAgeBetween(@Param("min") Integer start, @Param("max") Integer end);
	
	@Query("select p from Person p where p.document.cpf like %?1")
	List<Person> findByDocumentCPFEndsWith(String value);
	
	@Query("select p from Person p where p.firstName like ?1 and p.age = ?2")
	List<Person> findByFirstNameAndAge(String firstName, Integer age);
	
	@Query("select p from Person p where p.firstName like ?1 or p.age = ?2")
	List<Person> findByFirstNameOrAge(String firstName, Integer age);
	
	@Query("select p from Person p where p.firstName like ?1")
	List<Person> findByFirstName(String firstName);
	
	// busca por age e ordena por firstName de [a-z] e lastName de [a-z]
	List<Person> findByAgeGreaterThanOrderByFirstNameAscLastNameAsc(Integer age);
	
	// busca por number via phones mapeado em Person
	List<Person> findByPhonesNumberStartingWith(String number);
	
	// busca por linhas em person que tenham document_id diferentes de null
	List<Person> findByDocumentIsNotNull();

	// busca por linhas em person que tenham document id iguais a null
	List<Person> findByDocumentIsNull();

	// busca por fisrtNme ignorando letras maiúsculas e minúsculas
	List<Person> findByFirstNameIgnoreCase(String firstName);

	// busca por age baseado em uma lista de parametros que será negada
	List<Person> findByAgeNotIn(Integer... ages);

	// busca por age baseada em uma lista de parametros
	List<Person> findByAgeIn(Integer... ages);

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
