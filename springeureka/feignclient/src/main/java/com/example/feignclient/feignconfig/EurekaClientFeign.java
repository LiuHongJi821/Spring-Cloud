package com.example.feignclient.feignconfig;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="admin-client",configuration=FeignConfig.class)
public interface EurekaClientFeign {
    @GetMapping("/hi")
    String sayHiByFeign(@RequestParam(value = "张飞") String name);
}
