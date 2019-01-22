package com.example.feignclient.feignconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private FeignService feignService;
    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "张飞",required = false) String name){
        return feignService.sayHiByFeign(name);
    }
}
