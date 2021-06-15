package com.xmy.x2mall.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.xmy.x2mall.ware.dao")
@SpringBootApplication
public class X2mallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(X2mallWareApplication.class, args);
    }

}
