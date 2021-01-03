package com.hdxy.roule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wzh
 * @DescriptionF
 * @create 2020-12-28 12:15
 */
@Configuration
public class MyRule {
    @Bean
    public IRule mySelfRule() {
        return new RandomRule();
    }

}
