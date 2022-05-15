package com.cat.exception;

import org.springframework.http.HttpStatus;


public class BusinessErrorResponse extends Throwable {

    private String message;
    private HttpStatus errorMessageCode;

    public BusinessErrorResponse(String message) {
        this.message = message;
    }

    public BusinessErrorResponse(String message, HttpStatus errorMessageCode) {
        this.message = message;
        this.errorMessageCode = errorMessageCode;
    }
}
