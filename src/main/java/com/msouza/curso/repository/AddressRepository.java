package com.msouza.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.msouza.curso.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	@Query(value = "select funcConcatAddress(?1)", nativeQuery = true)
	String functionNativeQueryConcatenaEndereco(Long id);
	
	// usando functiom com @NamedNativQuery
	String functionConcatenaEndereco(Long ig);
	
	
	@Query( value = "select * from Address where city like ?1 and street like ?2",
			nativeQuery = true)
	Address buscaPorCidadeRua(String city, String street);
	
	// usando @NameNativeQueries
	Address buscarPorEndereco(String city, String street);
	
	// usando @NamedQuery na entidade
	List<Address> buscaPorCidade(String city);
	
	// busca por city e orena por type desc
	List<Address> findByCityOrderByTypeDesc(String city);
	
	// busca por city ou street conforme a igualdade da sequência de carcteres
	List<Address> findByCityStartingWithOrStreetEndingWith(String city, String street);
	
	// busca por street conforme o parametro conhecida com qualquer parte do campo street
	List<Address> findByStreetContaining(String street);
	
	// busca por street conforme o termino da palavra
	List<Address> findByStreetEndingWith(String street);

	// busca por city conforme o início da palavra
	List<Address> findByCityStartingWith(String city);

}
