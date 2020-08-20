package com.xmy.x2mall.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class X2mallThirdPartyApplication {

	public static void main(String[] args) {
		SpringApplication.run(X2mallThirdPartyApplication.class, args);
	}

}
