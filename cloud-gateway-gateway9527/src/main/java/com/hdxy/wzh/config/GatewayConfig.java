package com.hdxy.wzh.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wzh
 * @Description
 * @create 2020-12-30 22:18
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouter(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("guoji", r -> r.path("/mil").uri("http://news.baidu.com/mil")).build();
        return routes.build();
    }
}
