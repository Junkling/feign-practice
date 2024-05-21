package com.example.feign2.config;

import com.example.feign2.exception.CustomException;
import com.example.feign2.exception.ErrorCode;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;

import java.io.InputStreamReader;

@Slf4j
public class CustomFeignErrorDecoder implements ErrorDecoder {

    @SneakyThrows
    @Override
    public Exception decode(String s, Response response) {
        //HttpStatus
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());

        //메시지 파싱
        String requestUrl = response.request().url();
        Response.Body body = response.body();
        JSONParser jp = new JSONParser();
        JSONObject parseBody = (JSONObject) jp.parse(new InputStreamReader(body.asInputStream()));
        String message = "[URL] : " + requestUrl + " [Body] :" + parseBody.toString();

        if (responseStatus.is5xxServerError()) {
            //5xx 애러 핸들링
            return new CustomException(ErrorCode.builder().httpStatus(responseStatus).message(message).build());
        } else if (responseStatus.is4xxClientError()) {
            //4xx 애러 핸들링
            return new CustomException(ErrorCode.builder().httpStatus(responseStatus).message(message).build());
        } else {
            return new Exception("Generic exception");
        }
    }
}
