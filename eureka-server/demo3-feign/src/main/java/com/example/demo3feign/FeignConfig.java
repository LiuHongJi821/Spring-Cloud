package com.example.demo3feign;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class FeignConfig {
    @Bean
    public Retryer feignRetryer(){ //设置响应超时重试时间
        return new Retryer.Default(100,SECONDS.toMillis(1),2);
    }
}
