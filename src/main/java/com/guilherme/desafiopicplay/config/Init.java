package com.guilherme.desafiopicplay.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.guilherme.desafiopicplay.entities.User;
import com.guilherme.desafiopicplay.enums.UserRole;
import com.guilherme.desafiopicplay.repositories.UserRepository;

@Configuration
public class Init implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User u1 = new User(null, "Caio", "Silva", "12345678909", "caio@gmail.com", "password", UserRole.USER);
        User u2 = new User(null, "João", "Láu", "09812383298", "joaozin@gmail.com", "password", UserRole.USER);
        User u3 = new User(null, "Isabela", "Almeida", "43287298796", "isabela@gmail.com", "password", UserRole.RETAILER);

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
    }
    
}
