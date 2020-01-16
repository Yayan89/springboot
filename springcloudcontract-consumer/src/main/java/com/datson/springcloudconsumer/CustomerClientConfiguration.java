package com.datson.springcloudconsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CustomerClientConfiguration {

    @Bean
    public CustomerClient client() {
        return new CustomerClient();
    }
}
