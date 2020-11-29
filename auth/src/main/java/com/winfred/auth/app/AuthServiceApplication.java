package com.winfred.auth.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(
        scanBasePackages = {
                "com.winfred.auth.config",
                "com.winfred.auth.service",
                "com.winfred.auth.controller"
        }
)
//@EnableDiscoveryClient
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AuthServiceApplication.class);
        springApplication.run(args);
    }
}
