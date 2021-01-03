package com.hdxy.wzh.service.impl;

import com.hdxy.wzh.service.IMesssageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author wzh
 * @Description
 * @create 2020-12-31 12:18
 */
@EnableBinding(Source.class)
@Slf4j
public class IMesssageProviderImpl implements IMesssageProvider {
    @Autowired
    private MessageChannel output;
    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        boolean send = output.send(MessageBuilder.withPayload(uuid).build());
        log.info(String.valueOf(send));
        return uuid;
    }
}
