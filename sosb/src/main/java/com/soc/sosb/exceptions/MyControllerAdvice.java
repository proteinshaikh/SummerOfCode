package com.soc.sosb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(MyException.class)
    public ResponseEntity<String> handleMyException(MyException e) {
        return new ResponseEntity<>("error" + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
