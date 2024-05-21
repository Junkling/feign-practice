package com.example.feign2.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Builder
@Getter
public class ErrorCode {
    private final HttpStatus httpStatus;
    private final String message;
}
