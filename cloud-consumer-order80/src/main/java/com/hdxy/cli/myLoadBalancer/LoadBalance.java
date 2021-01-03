package com.hdxy.cli.myLoadBalancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author wzh
 * @Description
 * @create 2020-12-28 16:51
 */
public interface LoadBalance {
     ServiceInstance getServerInstance(List<ServiceInstance> serviceInstances);
}
