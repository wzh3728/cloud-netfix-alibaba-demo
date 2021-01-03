package com.hdxy.pay.service;

import com.hdxy.pay.pojo.Payment;


/**
 * @author wzh
 * @Description
 * @create 2020-12-07 16:46
 */
public interface PaymentService {
    Integer add(Payment payment);
    Payment getPaymentById(Long id);
}
