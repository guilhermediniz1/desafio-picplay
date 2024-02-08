package com.guilherme.desafiopicplay.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.desafiopicplay.entities.Wallet;
import com.guilherme.desafiopicplay.repositories.WalletRepository;

@Service
public class WalletService {
    @Autowired
    private WalletRepository repository;

    public List<Wallet> findAll() {
        return repository.findAll();
    }
}
