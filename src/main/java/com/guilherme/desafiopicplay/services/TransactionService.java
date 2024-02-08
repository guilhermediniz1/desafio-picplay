package com.guilherme.desafiopicplay.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.desafiopicplay.entities.Transaction;
import com.guilherme.desafiopicplay.repositories.TransactionRepository;
import com.guilherme.desafiopicplay.repositories.UserRepository;
import com.guilherme.desafiopicplay.repositories.WalletRepository;

@Service
public class TransactionService {
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }
}
