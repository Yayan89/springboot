package com.datson.springcloudstream.baldung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(MyProcessor.class)
public class ProcessorCustom {

    private final MyProcessor processor;

    @Autowired
    public ProcessorCustom(MyProcessor processor) {
        this.processor = processor;
    }

    public void routeValues(Integer val) {
        if (val < 10) {
            System.out.println("Less than 10: send them via default channel");
            processor.messageChannel().send(message(val));
        } else {
            System.out.println("More than 10: Send them via custom name channel");
            processor.myOutPutAnnotation().send(message(val));
        }
    }

    private static <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }
}
