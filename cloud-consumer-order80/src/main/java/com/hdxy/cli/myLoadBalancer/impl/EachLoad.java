package com.hdxy.cli.myLoadBalancer.impl;

import com.hdxy.cli.myLoadBalancer.LoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wzh
 * @Description
 * @create 2020-12-28 16:12
 */
@Component
public class EachLoad implements LoadBalance {
    AtomicInteger count = new AtomicInteger(0);

    private int addRequestCount() {
        while (true) {
            int i = count.get();
            int temp = i + 1;
            if (temp>Integer.MAX_VALUE) {
                temp=0;
            }
            boolean b = count.compareAndSet(i, temp);
            if (b) {
                System.out.println("第"+i+"次请求");
                return i;
            }
        }
    }
    @Override
    public ServiceInstance getServerInstance(List<ServiceInstance> serviceInstances){
        int index=addRequestCount()%serviceInstances.size();
        return serviceInstances.get(index);
    }


}
