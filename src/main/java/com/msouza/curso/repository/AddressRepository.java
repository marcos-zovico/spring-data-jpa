package com.msouza.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msouza.curso.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
