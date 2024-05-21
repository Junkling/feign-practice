package com.example.feign2.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException{
    private ErrorCode errorCode;

    @Override
    public String getMessage() {
        return errorCode.getMessage();
    }
}