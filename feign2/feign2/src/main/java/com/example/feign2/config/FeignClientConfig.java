package com.example.feign2.config;

import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeignClientConfig {
    Map<String, Collection<String>> headers = new HashMap<>();
    @Bean
    public RequestInterceptor requestInterceptor() {
        headers.put("custom-config-header1", List.of("FeignClientConfig1"));
        headers.put("custom-config-header2", List.of("FeignClientConfig2"));
        return requestTemplate -> requestTemplate.headers(headers);
    }
}
