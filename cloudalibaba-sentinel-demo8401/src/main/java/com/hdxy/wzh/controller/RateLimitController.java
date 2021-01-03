package com.hdxy.wzh.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.hdxy.pay.pojo.CommonResult;
import com.hdxy.pay.pojo.Payment;
import com.hdxy.wzh.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wzh
 * @Description
 * @create 2021-01-02 22:33
 */
@RestController
public class RateLimitController {
    @SentinelResource(value = "customerBlockHandler", blockHandler = "globalFlow1", blockHandlerClass = CustomerBlockHandler.class)
    @RequestMapping("/customerBlockHandler")
    public CommonResult<Payment> customerBlockHandler() {
        return new CommonResult<>(200, "请求成功", new Payment("1", 1));
    }
}
