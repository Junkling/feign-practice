package com.example.feign1.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<Result> getInfo(HttpServletRequest request , @RequestParam(name = "status", required = false, defaultValue = "200") int status) {
        Result result = new Result();
        request.getHeaderNames().asIterator().forEachRemaining((i) -> result.headerResult.add(i + " : " + request.getHeader(i)));
        request.getParameterNames().asIterator().forEachRemaining((i) -> result.parameterResult.add(i + " : " + request.getParameter(i)));
        HttpStatus httpStatus = HttpStatus.valueOf(status);
        return ResponseEntity.status(httpStatus).body(result);
    }
    @Data
    static class Result {
        List<String> headerResult = new ArrayList<>();
        List<String> parameterResult = new ArrayList<>();
        String body;
    }
}
