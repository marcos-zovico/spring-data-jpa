package com.msouza.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msouza.curso.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
