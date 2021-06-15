package com.xmy.x2mall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.xmy.x2mall.member.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class X2mallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(X2mallMemberApplication.class, args);
    }

}
