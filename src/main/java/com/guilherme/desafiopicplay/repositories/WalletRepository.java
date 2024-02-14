package com.guilherme.desafiopicplay.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.guilherme.desafiopicplay.entities.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {
    @Query
    public Optional<Wallet> findByUserId(Long userId);
}