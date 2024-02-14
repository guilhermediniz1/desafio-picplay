package com.guilherme.desafiopicplay.exceptions;

public class NotAuthorizedException extends RuntimeException {
    public NotAuthorizedException() {
        super("This transaction was not authorized.");
    }
}
