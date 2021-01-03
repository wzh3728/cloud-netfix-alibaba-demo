package com.hdxy.wzh.service;

import com.hdxy.wzh.service.impl.PaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wzh
 * @Description
 * @create 2020-12-29 16:54
 */
@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVER",fallback = PaymentServiceImpl.class)
public interface PaymentService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id) ;

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) ;
}
