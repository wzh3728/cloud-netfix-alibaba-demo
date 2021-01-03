package com.hdxy.cli.controller;

import com.hdxy.pay.pojo.CommonResult;
import com.hdxy.pay.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wzh
 * @Description
 * @create 2020-12-25 21:34
 */
@RestController
public class OrderController {
//    private final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://cloud-payment-server";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/creat")
    public CommonResult<Payment> creatOrder(Payment payment) {
        CommonResult result = restTemplate.postForObject(PAYMENT_URL+"/payment/add", payment,CommonResult.class);
        return result;
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getOrder(@PathVariable("id") Long id){
        CommonResult result = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return result;
    }
}
