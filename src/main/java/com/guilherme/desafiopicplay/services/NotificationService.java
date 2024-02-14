package com.guilherme.desafiopicplay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.guilherme.desafiopicplay.dto.NotificationDto;
import com.guilherme.desafiopicplay.entities.User;
import com.guilherme.desafiopicplay.exceptions.OutOfServiceException;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message){
        String email = user.getEmail();
        NotificationDto notificationDto = new NotificationDto(email, message);

        ResponseEntity<String> response = restTemplate.postForEntity(
                "https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", notificationDto, String.class);

        if (!(response.getStatusCode() == HttpStatus.OK)) {
            throw new OutOfServiceException("email");
        }
    }
}
