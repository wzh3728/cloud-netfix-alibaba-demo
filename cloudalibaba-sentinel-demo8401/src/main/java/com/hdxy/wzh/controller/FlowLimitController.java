package com.hdxy.wzh.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wzh
 * @Description
 * @create 2021-01-02 16:10
 */
@RestController
public class FlowLimitController {
    @RequestMapping("/testA")
    public String testA() {
        return "testA";
    }

    @RequestMapping("/testB")
    public String testB() {
        return "testB";
    }

    @RequestMapping("/hostKey")
    @SentinelResource(value = "hostKey",blockHandler = "fallBack")
    public String hostKey(@RequestParam(value = "p1", required = false) String p1,
                          @RequestParam(value = "p2", required = false) String p2) {
        int a=10/0;
        return "hostKey,p1=" + p1 + ",,,,p2=" + p2;
    }
    public String fallBack(String p1, String p2, BlockException blockException){
        return "fallback";
    }
}
