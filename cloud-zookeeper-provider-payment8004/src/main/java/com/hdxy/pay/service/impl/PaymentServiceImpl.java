package com.hdxy.pay.service.impl;

import com.hdxy.pay.dao.PaymentDao;
import com.hdxy.pay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hdxy.pay.pojo.Payment;


/**
 * @author wzh
 * @Description
 * @create 2020-12-07 16:48
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Integer add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
