package com.hdxy.wzh.controller;

import com.hdxy.wzh.service.IMesssageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wzh
 * @Description
 * @create 2020-12-31 12:11
 */
@RestController
public class RabbitMQController {
    @Autowired
    private IMesssageProvider iMesssageProvider;
    @GetMapping("/sendMesssageMQ")
    public String sendMesssageMQ() {
        String message = iMesssageProvider.send();
        return message;
    }
}
