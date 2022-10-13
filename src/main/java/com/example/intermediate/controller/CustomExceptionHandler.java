package com.example.intermediate.controller;

import com.example.intermediate.controller.error.SignupException;
import com.example.intermediate.controller.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException exception) {
        String errorMessage = exception.getBindingResult()
                .getAllErrors()
                .get(0)
                .getDefaultMessage();

        SignupException signupException = SignupException.builder()
                .field(exception.getBindingResult().getFieldError().getField())
                .message(errorMessage)
                .build();

        return new ResponseEntity<>(signupException, HttpStatus.BAD_REQUEST);
    }

}