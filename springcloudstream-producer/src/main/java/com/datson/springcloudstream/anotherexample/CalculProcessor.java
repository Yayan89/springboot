package com.datson.springcloudstream.anotherexample;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CalculProcessor {
    @Output
    MessageChannel rfgCalculsChannel();

    @Output
    MessageChannel IaminJavaClassNotYml();
}
