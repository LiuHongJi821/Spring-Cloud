package com.example.springbootmybatisdemo.controller;

import com.example.springbootmybatisdemo.service.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class TestController {

	@Autowired
    private TestServices testServices;
	
	@RequestMapping(value = "/show")
    public String show(){
        return testServices.show();
    }

    @RequestMapping(value = "/showDao")
    public Object showDao(){
        return testServices.showDao(66);
    }
    
    @RequestMapping(value = "/country/{country}")  
    public Object showDao(@PathVariable String country){
        return testServices.findByCountry(country);
    }
    
    
    
}
