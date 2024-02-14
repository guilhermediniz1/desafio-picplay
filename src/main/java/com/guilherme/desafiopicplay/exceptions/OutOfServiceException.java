package com.guilherme.desafiopicplay.exceptions;

public class OutOfServiceException extends RuntimeException {
    public OutOfServiceException(String service) {
        super("The " + service + "service is not working properly");
    }
}
