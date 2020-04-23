package com.datson.springcloudstream.baldung;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyProcessor {

    //input but we dont use them for now
    String INPUT = "Input";
    @Input
    SubscribableChannel myInput();

    @Output
    MessageChannel messageChannel();

    @Output("myOutPutAnnotation")
    MessageChannel myOutPutAnnotation();
}
