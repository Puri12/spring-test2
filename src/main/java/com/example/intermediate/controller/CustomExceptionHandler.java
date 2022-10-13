package com.example.intermediate.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomExceptionHandler {
    private String message;
    private String field;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException exception) {
        String errorMessage = exception.getBindingResult()
                .getAllErrors()
                .get(0)
                .getDefaultMessage();

        CustomExceptionHandler customExceptionHandler = CustomExceptionHandler.builder()
                .field(exception.getBindingResult().getFieldError().getField())
                .message(errorMessage)
                .build();

        return new ResponseEntity<>(customExceptionHandler, HttpStatus.BAD_REQUEST);
    }

}