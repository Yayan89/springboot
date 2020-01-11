package com.datyan.testingunits;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest
@AutoConfigureWireMock(port = 9999)
public class TestWireMock_WithoutSpringCloud {

    @Test
    public void testwithout_springcloudWireMock() {
        stubFor(get(urlEqualTo("/body-file"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBodyFile("stub1.json")));

//        assertThat("this service will call something /body-file");
    }
}
