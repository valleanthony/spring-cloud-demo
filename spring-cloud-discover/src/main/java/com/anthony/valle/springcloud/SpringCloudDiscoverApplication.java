package com.anthony.valle.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudDiscoverApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDiscoverApplication.class, args);
	}

}
