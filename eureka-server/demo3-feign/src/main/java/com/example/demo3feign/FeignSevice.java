package com.example.demo3feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FeignSevice {
    @Autowired
    EurekaClientFeign eurekaClientFeign;
    public String sayHi(String name){
        return eurekaClientFeign.sayhifromEurekaClient(name);
    }
}
