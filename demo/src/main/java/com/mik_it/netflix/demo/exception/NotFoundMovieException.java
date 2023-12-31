package com.mik_it.netflix.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundMovieException extends RuntimeException{
    public NotFoundMovieException(String message) {
        super(message);
    }
}
