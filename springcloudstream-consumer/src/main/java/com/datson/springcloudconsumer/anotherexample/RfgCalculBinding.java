package com.datson.springcloudconsumer.anotherexample;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RfgCalculBinding {
    @Input
    SubscribableChannel rfgCalculsChannel();

    @Input
    SubscribableChannel DoIGetListenedTo();
}
