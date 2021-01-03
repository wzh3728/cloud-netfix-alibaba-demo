package com.hdxy.wzh.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wzh
 * @Description
 * @create 2020-12-28 19:05
 */
@Configuration
public class OpenFeignConFig {
    @Bean
    public Logger.Level feignLoggerLove(){
        return Logger.Level.FULL;
    }
}
