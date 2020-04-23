package com.datson.springcloudconsumer.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(HelloBinding.class)
public class HelloListener {

    @StreamListener(value = HelloBinding.GREETING, condition = "payload < 10")
    public void processHelloChannelGreeting(String msg) {
        System.out.println(msg);
    }
}
