package com.datson.springcloudstream.anotherexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculsController {

    final MessageChannel messageChannel;

    @Autowired
    public CalculsController(CalculProcessor calculProcessor) {
        this.messageChannel = calculProcessor.rfgCalculsChannel();
    }

    @GetMapping("/api/{number}")
    public void getCalcul(@PathVariable String number) {
        var message = "Creer Calcul" + number;
        Message<String> build = MessageBuilder.withPayload(message).build();

        messageChannel.send(build);
    }
}
