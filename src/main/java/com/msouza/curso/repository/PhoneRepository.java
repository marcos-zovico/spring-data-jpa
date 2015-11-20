package com.msouza.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.msouza.curso.entity.Phone;
import com.msouza.curso.entity.Phone.TypePhone;

@Transactional(readOnly = true)// default
public interface PhoneRepository extends JpaRepository<Phone, Long> {

	@Modifying
	@Transactional(readOnly = false)
	@Query("delete from Phone p where p.number like ?1")
	int deleteByPhoneNumber(String number);
	
	@Modifying
	@Transactional(readOnly = false)
	@Query("update Phone p set p.number = ?1 where p.id = ?2")
	int setPhoneNumber(String number, Long id);
	
	@Modifying
	@Transactional(readOnly = false)
	@Query("update Phone p set p.type = ?1 where p.id = ?2")
	int setPhoneNumber(TypePhone type, Long id);
	

}
