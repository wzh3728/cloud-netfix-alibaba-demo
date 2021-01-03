package com.hdxy.wzh.service;

import com.hdxy.pay.pojo.CommonResult;
import com.hdxy.pay.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wzh
 * @Description
 * @create 2020-12-28 17:29
 */
@Service
@FeignClient("CLOUD-PAYMENT-SERVER")
public interface PaymentService {
    @GetMapping("/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    //添加付款记录
    @PostMapping("/payment/add")
    CommonResult add(@RequestBody Payment payment);

    @GetMapping("/payment/get/timeout/{id}")
    CommonResult getPaymentByIdTimeOut(@PathVariable("id") Long id);

}
