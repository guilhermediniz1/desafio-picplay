package com.guilherme.desafiopicplay.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.desafiopicplay.entities.Wallet;
import com.guilherme.desafiopicplay.services.WalletService;

@RestController
@RequestMapping(value = "/wallets")
public class WalletController {
    @Autowired
    private WalletService service;

    @GetMapping
    public ResponseEntity<List<Wallet>> getWallets() {
        return ResponseEntity.ok(service.findAll());
    }

}
