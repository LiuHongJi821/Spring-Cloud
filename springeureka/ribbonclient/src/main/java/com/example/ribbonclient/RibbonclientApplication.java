package com.example.ribbonclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RibbonclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonclientApplication.class, args);
    }

}

