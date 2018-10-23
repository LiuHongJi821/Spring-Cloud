package com.example.demo4turbine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;
    public String hi(String name){
        return restTemplate.getForObject("http://service-client/hi?name="+name, String.class);
    }

}
