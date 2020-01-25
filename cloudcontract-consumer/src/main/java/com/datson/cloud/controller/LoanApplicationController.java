package com.datson.cloud.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoanApplicationController {

    final RestTemplate restTemplate;

    @Autowired
    public LoanApplicationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PutMapping("/fraudcheck")
    public Fraud checkFraud() {
        return new Fraud("FRAUD", "Amount too high");
    }
}

@Data
@AllArgsConstructor
class Fraud {
    @JsonProperty("fraudCheckStatus")
    private String string1;
    @JsonProperty("rejection.reason")
    private String string2;
}
