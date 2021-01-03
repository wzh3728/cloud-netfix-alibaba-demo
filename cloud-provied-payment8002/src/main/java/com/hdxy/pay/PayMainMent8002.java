package com.hdxy.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wzh
 * @Description
 * @create 2020-12-07 10:18
 */
@SpringBootApplication
@EnableEurekaClient
public class PayMainMent8002 {
    public static void main(String[] args) {
        SpringApplication.run(PayMainMent8002.class, args);
    }
}
