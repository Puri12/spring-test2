package com.example.intermediate.controller.error;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupException {
    private String message;
    private String field;
}
