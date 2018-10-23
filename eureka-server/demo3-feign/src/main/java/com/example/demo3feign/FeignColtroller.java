package com.example.demo3feign;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignColtroller {
    @Autowired
    FeignSevice feignSevice;
    @GetMapping("/hi")
    //@HystrixCommand(fallbackMethod="sayhifromEurekaClient")
    public String sayHi(String name){
        return feignSevice.sayHi(name);
    }
    public String sayhifromEurekaClient(String name) {
        return "hi"+name+",this is error!";
    }
}
