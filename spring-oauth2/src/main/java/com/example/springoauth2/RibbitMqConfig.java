package com.example.springoauth2;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RibbitMqConfig {
    public static final String queueName="springcloud-server-bus-mq";
    public Queue rabbitMqQueue(){
        return new Queue(queueName);
    }
}
