package com.mik_it.netflix.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestMovieException extends RuntimeException{
    public BadRequestMovieException(String message) {
        super(message);
    }
}
