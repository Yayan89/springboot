package com.datson.cloud.controller;

import com.datson.cloud.model.LoanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoanApplicationController {

    final RestTemplate restTemplate;

    @Autowired
    public LoanApplicationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PutMapping
    public String checkOddAndEven(@RequestBody LoanRequest loanRequest) {
        loanRequest.setLoanAmount(10001L);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        ResponseEntity<String> responseEntity = restTemplate.exchange(
            "http://localhost:8080/fraudcheck",
            HttpMethod.PUT,
            new HttpEntity<>(loanRequest, httpHeaders),
            String.class);

        return responseEntity.getBody();
    }
}
