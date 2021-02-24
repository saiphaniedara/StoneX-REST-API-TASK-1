package com.stonex.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoCurrencyDetailsFoundException extends RuntimeException {
    public NoCurrencyDetailsFoundException(String message) {
        super(message);
    }
}
