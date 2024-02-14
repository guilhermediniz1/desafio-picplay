package com.guilherme.desafiopicplay.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.guilherme.desafiopicplay.entities.Transaction;
import com.guilherme.desafiopicplay.entities.User;
import com.guilherme.desafiopicplay.entities.Wallet;
import com.guilherme.desafiopicplay.exceptions.NotAuthorizedException;
import com.guilherme.desafiopicplay.repositories.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;
    @Autowired
    private WalletService walletService;
    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private NotificationService notificationService;

    public List<Transaction> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Transaction createTransaction(Long payerId, Long receiverId, Integer amount) {
        Wallet payerWallet = walletService.findByUser(payerId);
        Wallet receiverWallet = walletService.findByUser(receiverId);

        userService.validateTransaction(payerWallet, amount);

        boolean isAuthorized = this.authorizeTransaction(payerWallet.getUser(), amount);

        if(!isAuthorized) {
            throw new NotAuthorizedException();
        }

        Transaction transaction = new Transaction(null, payerWallet.getUser(), receiverWallet.getUser(), amount, LocalDateTime.now());

        walletService.debitMoney(payerWallet, amount);
        walletService.depositMoney(receiverWallet, amount);

        notificationService.sendNotification(userService.findById(payerId), "Pagamento realizado com sucesso!");
        notificationService.sendNotification(userService.findById(receiverId), "Novo pagamento recebido!");

        return repository.save(transaction);
    }

    public boolean authorizeTransaction(User payer, Integer value) {
        ResponseEntity<Map> authResponse = restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", Map.class);

        if(authResponse.getStatusCode() == HttpStatus.OK) {
            String message = (String) authResponse.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(message);
        } 

        return false;
    }
}
