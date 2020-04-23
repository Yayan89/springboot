package com.datson.springcloudconsumer.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ProducerBinding {

    @Input("")
    SubscribableChannel messageChannel();
}
