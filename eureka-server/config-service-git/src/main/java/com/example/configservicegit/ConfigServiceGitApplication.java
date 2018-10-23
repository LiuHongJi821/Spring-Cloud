package com.example.configservicegit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServiceGitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceGitApplication.class, args);
    }
}
