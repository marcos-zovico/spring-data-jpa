package com.msouza.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msouza.curso.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
