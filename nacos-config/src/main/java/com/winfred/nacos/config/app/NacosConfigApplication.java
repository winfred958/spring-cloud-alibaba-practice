package com.winfred.nacos.config.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NacosConfigApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(NacosConfigApplication.class);
        springApplication.run(args);
    }
}
