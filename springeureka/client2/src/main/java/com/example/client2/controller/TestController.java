package com.example.client2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    String port;
    @RequestMapping("/hi")
    public String getString(){
        return "hi I am from " + port +" !";
    }
}
