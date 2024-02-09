package com.guilherme.desafiopicplay.config;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.guilherme.desafiopicplay.entities.Transaction;
import com.guilherme.desafiopicplay.entities.User;
import com.guilherme.desafiopicplay.entities.Wallet;
import com.guilherme.desafiopicplay.enums.UserRole;
import com.guilherme.desafiopicplay.repositories.TransactionRepository;
import com.guilherme.desafiopicplay.repositories.UserRepository;
import com.guilherme.desafiopicplay.repositories.WalletRepository;

@Configuration
public class Init implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        walletRepository.deleteAll();
        

        Wallet w1 = new Wallet(null, 500098, null);
        Wallet w2 = new Wallet(null, 130034, null);
        Wallet w3 = new Wallet(null, 1000075, null);

        User u1 = new User(null, "Caio", "Silva", "12345678909", "caio@gmail.com", "password", UserRole.USER, w1);
        User u2 = new User(null, "João", "Láu", "09812383298", "joaozin@gmail.com", "password", UserRole.USER, w2);
        User u3 = new User(null, "Isabela", "Almeida", "43287298796", "isabela@gmail.com", "password",
                UserRole.RETAILER, w3);

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Transaction t1 = new Transaction(null, u1, u3, 90054, LocalDateTime.now());
        Transaction t2 = new Transaction(null, u1, u2, 20098, LocalDateTime.now());
        Transaction t3 = new Transaction(null, u2, u1, 12398, LocalDateTime.now());
        Transaction t4 = new Transaction(null, u2, u3, 65720, LocalDateTime.now());
        Transaction t5 = new Transaction(null, u2, u1, 5490, LocalDateTime.now());

        transactionRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
    }

}
