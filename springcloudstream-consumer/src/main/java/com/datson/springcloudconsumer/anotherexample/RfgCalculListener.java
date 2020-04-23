package com.datson.springcloudconsumer.anotherexample;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(RfgCalculBinding.class)
public class RfgCalculListener {
    @StreamListener(target = "rfgCalculsChannel")
    public void process_rfgCalculsChannel(String msg) {
        System.out.println(msg);
    }
}
