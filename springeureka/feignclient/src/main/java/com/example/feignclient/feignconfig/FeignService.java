package com.example.feignclient.feignconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeignService {
    @Autowired
    EurekaClientFeign eurekaClientFeign;

    /**
     * 这里只是启用feign调用远程的/hi接口
     * @param name
     * @return
     */
    public String sayHiByFeign(String name){
       return eurekaClientFeign.sayHiByFeign(name);
    }
}
