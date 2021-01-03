package com.hdxy.wzh.service.impl;

import com.hdxy.wzh.service.PaymentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author wzh
 * @Description
 * @create 2020-12-29 18:22
 */
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "PaymentServiceImpl======================paymentInfo_ok";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentServiceImpl======================paymentInfo_TimeOut";
    }
}
