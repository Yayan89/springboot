//package com.datson.springcloudstream.baldung;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.messaging.Processor;
//import org.springframework.cloud.stream.test.binder.MessageCollector;
//import org.springframework.core.log.LogMessage;
//import org.springframework.messaging.support.MessageBuilder;
//
//import static org.junit.Assert.assertEquals;
//
//public class BaeldungTutorial {
//
//    @Autowired
//    private Processor pipe;
//
//    @Autowired
//    private MessageCollector messageCollector;
//
//    @Test
//    public void whenSendMessage_thenResponseShouldUpdateText() {
//        pipe.input()
//            .send(MessageBuilder.withPayload(new LogMessage("This is my message"))
//                .build());
//
//        Object payload = messageCollector.forChannel(pipe.output())
//            .poll()
//            .getPayload();
//
//        assertEquals("[1]: This is my message", payload.toString());
//    }
//}
