package com.hdxy.wzh.conreoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author wzh
 * @Description
 * @create 2020-12-31 13:08
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String port;
    @StreamListener(Sink.INPUT)
    public void listenerMessage(Message<String> message){
        log.info("消费者8802--port"+port+"------接收的message："+message.getPayload());
    }
}
