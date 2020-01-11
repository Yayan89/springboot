package com.datyan.testingunits;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.WireMockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@SpringBootTest
public class TestWireMock_WithJunit5 {
    WireMockServer wm = new WireMockServer(options().port(2345));

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testWireMock() {
        WireMockRestServiceServer.with(this.restTemplate)
            .baseUrl("http://example.org")
            .stubs("classpath:/__files/stub1.json")
            .build();
    }
}
