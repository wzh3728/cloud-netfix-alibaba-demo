package com.hdxy.wzh.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hdxy.pay.pojo.CommonResult;
import com.hdxy.pay.pojo.Payment;

/**
 * @author wzh
 * @Description
 * @create 2021-01-02 22:27
 */
public class CustomerBlockHandler {
    public static CommonResult<Payment> globalFlow1(BlockException blockException){
            return new CommonResult<Payment>(444,"全局globalFlow2",new Payment("9999",9999));
    }
    public static CommonResult<Payment> globalFlow2(BlockException blockException){
        return new CommonResult<Payment>(444,"全局globalFlow1",new Payment("9999",9999));
    }
    public static String globalFlow3(BlockException blockException){
        return "globalFlow3";
    }
}
