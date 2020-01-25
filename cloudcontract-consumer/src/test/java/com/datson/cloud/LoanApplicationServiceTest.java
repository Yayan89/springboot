package com.datson.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureStubRunner(
    stubsMode = StubRunnerProperties.StubsMode.CLASSPATH,
    ids = "com.datson:cloudcontract-producer:+:stubs:0.0.1:8090"
)
@AutoConfigureMockMvc
public class LoanApplicationServiceTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void check_fraudCheck() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.put("/fraudcheck")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.['fraudCheckStatus']").value("FRAUD"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.['rejection.reason']").value("Amount too high"))
        ;
    }
}
