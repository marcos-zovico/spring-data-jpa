package com.msouza.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msouza.curso.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	// busca por city ou street conforme a igualdade da sequência de carcteres
	List<Address> findByCityStartingWithOrStreetEndingWith(String city, String street);
	
	// busca por street conforme o parametro conhecida com qualquer parte do campo street
	List<Address> findByStreetContaining(String street);
	
	// busca por streer conforme o termino da palavra
	List<Address> findByStreetEndingWith(String street);

	// busca por city conforme o início da palavra
	List<Address> findByCityStartingWith(String city);

}
