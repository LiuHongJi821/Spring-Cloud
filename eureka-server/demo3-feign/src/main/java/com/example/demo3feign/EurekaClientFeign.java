package com.example.demo3feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-client" , configuration = FeignConfig.class , fallback = EurekaClientFeign.HiHystrix.class)
public interface EurekaClientFeign {
    @GetMapping("/hi")
    String sayhifromEurekaClient(@RequestParam(value="name") String name);
    @Component
    public class HiHystrix implements EurekaClientFeign{
        @Override
        public String sayhifromEurekaClient(String name) {
            return "hi"+name+",this is error!";
        }
    }

}
