package com.datson.springcloudcontract.controller;

import com.datson.springcloudcontract.Customer;
import com.datson.springcloudcontract.CustomerRepository;
import com.datson.springcloudcontract.CustomerRestController;
import com.datson.springcloudcontract.ProducerApplication;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApplication.class)
public class BaseClass {

    @Autowired
    private CustomerRestController customerRestController;

    @MockBean
    private CustomerRepository customerRepository;

    @Before
    public void before() {
        Mockito.when(this.customerRepository.findAll())
            .thenReturn(Arrays.asList(
                new Customer(1L, "Jane"),
                new Customer(2L, "Bob")));

        RestAssuredMockMvc.standaloneSetup(this.customerRestController);

    }
}
