package com.hdxy.pay.dao;

import com.hdxy.pay.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author wzh
 * @Description
 * @create 2020-12-07 16:46
 */
@Mapper
public interface PaymentDao {
    Integer add(Payment payment);
    Payment getPaymentById(Long id);
}
