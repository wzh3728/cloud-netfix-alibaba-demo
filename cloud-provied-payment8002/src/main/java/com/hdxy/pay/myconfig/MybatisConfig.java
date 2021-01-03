package com.hdxy.pay.myconfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author wzh
 * @Description
 * @create 2020-12-25 17:33
 */
@Configuration
public class MybatisConfig {
        @Bean
        @ConfigurationProperties("spring.datasource")
        public DataSource dataSource() {
            return new DruidDataSource();
        }
}
