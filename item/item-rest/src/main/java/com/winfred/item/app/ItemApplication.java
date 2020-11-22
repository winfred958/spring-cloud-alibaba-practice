package com.winfred.item.app;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(value = {
        "com.winfred.item.config",
        "com.winfred.item.service",
        "com.winfred.item.rest"
})
public class ItemApplication {
  public static void main(String[] args) {
    SpringApplication springApplication = new SpringApplication(ItemApplication.class);
    springApplication.run(args);
  }
}
