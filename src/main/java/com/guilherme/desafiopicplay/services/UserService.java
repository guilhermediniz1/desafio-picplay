package com.guilherme.desafiopicplay.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.guilherme.desafiopicplay.entities.User;
import com.guilherme.desafiopicplay.entities.Wallet;
import com.guilherme.desafiopicplay.enums.UserRole;
import com.guilherme.desafiopicplay.exceptions.NotEnoughBalanceException;
import com.guilherme.desafiopicplay.exceptions.NotPermittedActionException;
import com.guilherme.desafiopicplay.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long userId) {
        return repository.findById(userId).get();
    }

    public void validateTransaction(Wallet payerWallet, Integer amount) {
        if (payerWallet.getUser().getRole() == UserRole.RETAILER) {
            throw new NotPermittedActionException();
        }

        if (payerWallet.getBalance().compareTo(amount) < 0) {
            throw new NotEnoughBalanceException();
        }
    }

}
