package com.example.feign2.service;

import com.example.feign2.config.FeignClientConfig;
import com.example.feign2.controller.dto.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "example", url = "http://localhost:8282", configuration = FeignClientConfig.class)
//@FeignClient(name = "example", url = "http://localhost:8282")
public interface FeignClientService {
    @GetMapping(value = "/test")
    Result getInfo(
            @RequestHeader(value = "Authorization", required = false) String token,
            @RequestParam(name = "name", required = false)String name,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "status" , required = false)Integer status);
}
