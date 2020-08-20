package com.xmy.x2mall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.xmy.x2mall.member.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class X2mallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(X2mallMemberApplication.class, args);
    }

}
