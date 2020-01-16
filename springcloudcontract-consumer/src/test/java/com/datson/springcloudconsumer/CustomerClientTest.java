package com.datson.springcloudconsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.http.HttpHeaders;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringcloudconsumerApplication.class)
@AutoConfigureWireMock(port = 8080)
@AutoConfigureJson
public class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Autowired
    ObjectMapper objectMapper;

    String jsonForCustomer(Customer... customers) throws JsonProcessingException {
        List<Customer> customerList = Arrays.asList(customers);
        return this.objectMapper.writeValueAsString(customerList);
    }

    @Test
    public void clientShouldReturnAllCustomers() throws JsonProcessingException {
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/customers"))
            .willReturn(
                WireMock.aResponse()
                    .withStatus(200)
                    .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .withBody(jsonForCustomer(new Customer(0L, "Jane"), new Customer(2L, "Bob")))

            ));

        BDDAssertions.then(this.client.getAllCustomers()).size().isEqualTo(2);
    }
}
