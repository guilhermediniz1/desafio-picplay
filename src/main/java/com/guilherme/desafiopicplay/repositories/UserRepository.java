package com.guilherme.desafiopicplay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.desafiopicplay.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

} 