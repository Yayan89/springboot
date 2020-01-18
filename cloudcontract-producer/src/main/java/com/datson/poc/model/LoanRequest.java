package com.datson.poc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoanRequest {

    @JsonProperty("client.id")
    private String clientId;

    private Long loanAmount;


}