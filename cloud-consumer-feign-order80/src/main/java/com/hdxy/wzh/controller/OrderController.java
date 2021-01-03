package com.hdxy.wzh.controller;

import com.hdxy.pay.pojo.CommonResult;
import com.hdxy.pay.pojo.Payment;
import com.hdxy.wzh.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wzh
 * @Description
 * @create 2020-12-28 17:33
 */
@RestController
public class OrderController {
    @Resource
    private PaymentService paymentService;
    @GetMapping("/consumer/payment/creat")
    public CommonResult<Payment> creatOrder(Payment payment) {
        return paymentService.add(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getOrder(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }
    @GetMapping("/consumer/timeout/get/{id}")
    public CommonResult<Payment> getOrderTimeout(@PathVariable("id") Long id) {
        return paymentService.getPaymentByIdTimeOut(id);
    }
}
