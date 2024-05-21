package com.example.feign2.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ErrorResponse {
    private int status;
    private String code;
    private String message;

    // 커스텀에서 사용시
    public static ResponseEntity<ErrorResponse> ofResponse(ErrorCode e) {
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(ErrorResponse.builder()
                        .status(e.getHttpStatus().value())
                        .code(e.getHttpStatus().name())
                        .message(e.getMessage())
                        .build()
                );
    }
    // 이외 익셉션
    public static ResponseEntity<ErrorResponse> ofResponse(Exception e, HttpStatus status) {
        return ResponseEntity
                .status(status)
                .body(ErrorResponse.builder()
                        .status(status.value())
                        .code(e.getClass().toString())
                        .message(e.getMessage())
                        .build()
                );
    }
}
