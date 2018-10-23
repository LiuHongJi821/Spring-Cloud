package com.example.springoauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestfulController {
    @Autowired
    Prodecer prodecer;
    @GetMapping("/message")
    public String message(){
        prodecer.send();
        return "hi";
    }
}
