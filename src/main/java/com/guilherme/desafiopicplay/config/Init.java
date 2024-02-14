package com.guilherme.desafiopicplay.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.guilherme.desafiopicplay.entities.User;
import com.guilherme.desafiopicplay.entities.Wallet;
import com.guilherme.desafiopicplay.enums.UserRole;
import com.guilherme.desafiopicplay.repositories.UserRepository;
import com.guilherme.desafiopicplay.repositories.WalletRepository;

@Configuration
public class Init implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        walletRepository.deleteAll();

        Wallet w1 = new Wallet(null, 300000, null);
        Wallet w2 = new Wallet(null, 0, null);
        Wallet w3 = new Wallet(null, 0, null);

        User u1 = new User(null, "Caio", "Silva", "12345678909", "caio@gmail.com", "password", UserRole.USER, w1);
        User u2 = new User(null, "João", "Láu", "09812383298", "joaozin@gmail.com", "password", UserRole.USER, w2);
        User u3 = new User(null, "Isabela", "Almeida", "43287298796", "isabela@gmail.com", "password",
                UserRole.RETAILER, w3);

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
    }

}
