package com.hdxy.wzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wzh
 * @Description
 * @create 2021-01-02 8:40
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaNacosConfigMain {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaNacosConfigMain.class,args);
    }
}
