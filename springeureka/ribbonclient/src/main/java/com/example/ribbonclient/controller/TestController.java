package com.example.ribbonclient.controller;

import ch.qos.logback.core.joran.spi.DefaultClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private RibbonService ribbonService;
    @GetMapping("/hi")
    public String sayHi(@RequestParam(required = true,defaultValue = "dd") String name){
        return ribbonService.hi(name);
    }
}
