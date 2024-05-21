package com.example.feign2.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    @JsonProperty("headerResult")
    private List<String> headerResult = new ArrayList<>();
    @JsonProperty("parameterResult")
    private List<String> parameterResult = new ArrayList<>();
    @JsonProperty("body")
    private String body;
}