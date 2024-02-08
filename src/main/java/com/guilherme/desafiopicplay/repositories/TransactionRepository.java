package com.guilherme.desafiopicplay.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guilherme.desafiopicplay.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

}