package com.example.ribbonclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;
    public String hi(String name){
        return restTemplate.getForObject("http://admin-client/hi?name="+name,String.class);
    }
}
