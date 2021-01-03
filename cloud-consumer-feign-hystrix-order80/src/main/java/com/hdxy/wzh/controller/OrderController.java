package com.hdxy.wzh.controller;

import com.hdxy.wzh.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wzh
 * @Description
 * @create 2020-12-29 16:53
 */
@RestController
//@DefaultProperties(defaultFallback = "consumerGlobalFallBack")
public class OrderController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/order/ok/{id}")
    public String ok(@PathVariable("id") Integer id) {
        return "consumer:port:" + port + "\t" + paymentService.paymentInfo_ok(id);
    }

    @GetMapping("/order/timeout/{id}")
    @HystrixCommand
    public String timeOut(@PathVariable("id") Integer id) {
        return "consumer:port:" + port + "\t" + paymentService.paymentInfo_TimeOut(id);
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "fusingFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),   //达到一定的请求次数开始计数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  //在熔断后的多久开始尝试恢复
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率达到多少后跳闸（注意这是百分比）
    })
    @GetMapping("/fusingTest/{id}")
    public String fusingTest(@PathVariable("id") Integer id) {
        return 10 / id + "";
    }

    public String fusingFallBack(Integer id) {
        return "==========熔断了====";
    }

    //全局方法
    public String consumerGlobalFallBack() {
        return "===consumerGlobalFallBack====";
    }
}
