package com.msouza.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.msouza.curso.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

//	@Query("select d from Document d where d.cpf like :start%")
//	@Query("select d from docs d where d.cpf like :start%")
	@Query("select d from #{#entityName} d where d.cpf like :start%")
	List<Document> findByCpfStartWith(@Param("start")String start);
	
}
