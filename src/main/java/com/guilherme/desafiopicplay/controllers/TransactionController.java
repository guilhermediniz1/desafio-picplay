package com.guilherme.desafiopicplay.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.desafiopicplay.entities.Transaction;
import com.guilherme.desafiopicplay.services.TransactionService;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @GetMapping
    public ResponseEntity<List<Transaction>> getWallets() {
        return ResponseEntity.ok(service.findAll());
    }

}
