package com.guilherme.desafiopicplay.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.desafiopicplay.entities.Wallet;
import com.guilherme.desafiopicplay.exceptions.NotEnoughBalanceException;
import com.guilherme.desafiopicplay.exceptions.ResourceNotFoundException;
import com.guilherme.desafiopicplay.repositories.WalletRepository;


@Service
public class WalletService {
    @Autowired
    private WalletRepository repository;

    public List<Wallet> findAll() {
        return repository.findAll();
    }

    public Wallet findByUser(Long userId) {
        return repository.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException(userId));
    }

    public Integer getBalanceByUser(Long userId) {
        Wallet wallet = findByUser(userId);
        return wallet.getBalance();
    }

    public void debitMoney(Wallet wallet, Integer amount) {
        if(wallet.getBalance() < amount) {
            throw new NotEnoughBalanceException();
        }

        wallet.setBalance(wallet.getBalance() - amount);
        repository.save(wallet);
    }

    public void depositMoney(Wallet wallet, Integer amount) {
        wallet.setBalance(wallet.getBalance() + amount);
        repository.save(wallet);
    }
}
