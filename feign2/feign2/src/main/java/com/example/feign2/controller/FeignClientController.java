package com.example.feign2.controller;

import com.example.feign2.controller.dto.Result;
import com.example.feign2.service.FeignClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FeignClientController {
    private final FeignClientService feignClientService;

    @GetMapping("/feign")
    public ResponseEntity<Result> feignClientTest(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String header,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "status", required = false) Integer status) {
        log.info("feign 호출");
        Result info = feignClientService.getInfo(header, name, age, status);
        return ResponseEntity.ok(info);
    }
}
