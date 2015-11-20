package com.msouza.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msouza.curso.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
