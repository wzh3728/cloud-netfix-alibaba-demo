package com.hdxy.pay.controller;

import com.hdxy.pay.service.PaymentService;
import com.hdxy.pay.pojo.CommonResult;
import com.hdxy.pay.pojo.Payment;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 * @author wzh
 * @Description
 * @create 2020-12-07 16:48
 */
@RestController
@Log
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    //查询付款记录
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        CommonResult<Payment> result = new CommonResult<>(401, "没有查询到记录", null);
        log.info("查询结果为" + payment);
        if (payment != null) {
             result.setStatus(200);
             result.setMessage("查询成功,端口号为"+port);
             result.setData(payment);
             return result;
        }
        log.info("查询结果为***"+result.toString());
        return result;
    }
    //查询付款记录演示超时
    @GetMapping("/payment/get/timeout/{id}")
    public CommonResult getPaymentByIdTimeOut(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        CommonResult<Payment> result = new CommonResult<>(401, "没有查询到记录", null);
        log.info("查询结果为" + payment);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (payment != null) {
            result.setStatus(200);
            result.setMessage("查询成功,端口号为"+port);
            result.setData(payment);
            return result;
        }
        log.info("查询结果为***"+result.toString());
        return result;
    }

    //添加付款记录
    @PostMapping("/payment/add")
    public CommonResult add( @RequestBody Payment payment) {
        log.info("插入对象为***"+payment);

        Integer addCount = paymentService.add(payment);
        log.info("插入数据为***" + addCount);
        CommonResult result = new CommonResult(401, "插入失败", addCount);
        if (addCount > 0) {
            result.setStatus(200);
            result.setMessage("插入成功,端口号为"+port);
            result.setData(addCount);
            return result;
        }
        return result;
    }
}
