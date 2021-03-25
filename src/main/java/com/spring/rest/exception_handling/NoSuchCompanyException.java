package com.spring.rest.exception_handling;

public class NoSuchCompanyException extends RuntimeException {

    public NoSuchCompanyException(String message) {
        super(message);
    }
}
