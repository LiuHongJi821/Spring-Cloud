package com.example.springoauth2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RibbitMqConfig.queueName)
public class Customer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RabbitHandler
    public void customer(String message){
         logger.info("从队列获取到的消息：{}",message);
    }
}
