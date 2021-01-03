package com.hdxy.wzh.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author wzh
 * @Description
 * @create 2020-12-29 16:03
 */
@Service
public class PaymentService {
    public String ok(Integer id) {
        return "请求成功ok方法，id" + id;
    }

    @HystrixCommand(fallbackMethod = "payment_runTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String runTimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "请求超时runTimeOut方法，睡眠三秒后返回，id" + id;
    }

    public String payment_runTimeOutHandler(Integer id) {
        return "请求超时或出错fallback方法payment_runTimeOutHandler，id" +
                id + "线程名：" + Thread.currentThread().getName();
    }
}
