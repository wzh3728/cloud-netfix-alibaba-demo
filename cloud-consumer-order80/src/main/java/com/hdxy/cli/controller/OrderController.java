package com.hdxy.cli.controller;

import com.hdxy.cli.myLoadBalancer.impl.EachLoad;
import com.hdxy.pay.pojo.CommonResult;
import com.hdxy.pay.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author wzh
 * @Description
 * @create 2020-12-25 21:34
 */
@RestController
public class OrderController {
    //    private final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EachLoad eachLoad;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/creat")
    public CommonResult<Payment> creatOrder(Payment payment) {
        CommonResult result = restTemplate.postForObject(PAYMENT_URL + "/payment/add", payment, CommonResult.class);
        return result;
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getOrder(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return result;
    }

    @GetMapping("/consumer/payment/get/lb/{id}")
    public CommonResult getLbTest(@PathVariable("id") Long id) {
        //根据服务名称获取所有实例集合
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        //获取经过计算应该使用服务的实例
        ServiceInstance serverInstance = eachLoad.getServerInstance(instances);
        URI uri = serverInstance.getUri();
        System.out.println(uri);
        CommonResult result = restTemplate.getForObject(uri + "/payment/get/" + id, CommonResult.class);
        return result;
    }
}
