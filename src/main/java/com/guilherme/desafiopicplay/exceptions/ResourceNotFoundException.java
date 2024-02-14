package com.guilherme.desafiopicplay.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Resource not found. ID: " + id);
    }
}
