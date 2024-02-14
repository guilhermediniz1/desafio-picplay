package com.guilherme.desafiopicplay.exceptions;

public class NotPermittedActionException extends RuntimeException {
    public NotPermittedActionException() {
        super("This action is not permitted.");
    }
}
