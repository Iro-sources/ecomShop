package com.ecommerce.shop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ApiException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ApiException(){

    }

    public ApiException(String message) {
        super(message);
    }


}
