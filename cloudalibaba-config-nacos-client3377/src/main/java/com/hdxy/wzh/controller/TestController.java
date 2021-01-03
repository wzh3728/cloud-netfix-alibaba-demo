package com.hdxy.wzh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wzh
 * @Description
 * @create 2021-01-02 8:25
 */
@RestController
@RefreshScope
public class TestController {
    @Value("${config.info}")

    private String config;
    @RequestMapping("/test")
    public String testConfig(){
        return config;
    }
}
