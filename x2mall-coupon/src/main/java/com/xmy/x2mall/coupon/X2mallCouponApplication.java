package com.xmy.x2mall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class X2mallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(X2mallCouponApplication.class, args);
    }

}
