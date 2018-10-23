package com.example.configserviceeurake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ConfigServiceEurakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceEurakeApplication.class, args);
    }
}
