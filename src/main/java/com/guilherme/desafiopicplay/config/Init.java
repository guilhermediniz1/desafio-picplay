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
        

        Wallet w1 = new Wallet(null, new BigDecimal("5000.98"), null);
        Wallet w2 = new Wallet(null, new BigDecimal("1300.34"), null);
        Wallet w3 = new Wallet(null, new BigDecimal("10000.75"), null);

        User u1 = new User(null, "Caio", "Silva", "12345678909", "caio@gmail.com", "password", UserRole.USER, w1);
        User u2 = new User(null, "João", "Láu", "09812383298", "joaozin@gmail.com", "password", UserRole.USER, w2);
        User u3 = new User(null, "Isabela", "Almeida", "43287298796", "isabela@gmail.com", "password",
                UserRole.RETAILER, w3);

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Transaction t1 = new Transaction(null, u1, u3, new BigDecimal("900.54"), LocalDateTime.now());
        Transaction t2 = new Transaction(null, u1, u2, new BigDecimal("200.98"), LocalDateTime.now());
        Transaction t3 = new Transaction(null, u2, u1, new BigDecimal("123.98"), LocalDateTime.now());
        Transaction t4 = new Transaction(null, u2, u3, new BigDecimal("657.20"), LocalDateTime.now());
        Transaction t5 = new Transaction(null, u2, u1, new BigDecimal("54.90"), LocalDateTime.now());

        transactionRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
    }

}
