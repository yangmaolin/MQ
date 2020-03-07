package com.yml.rabbitmqtopicconsumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class QQService {
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.topic.qq.queue}",
    autoDelete = "true"),
    exchange = @Exchange(value="${mq.topic.exchangName}",type= ExchangeTypes.TOPIC),
    key = "qq.*" //路由key
    ))
    @RabbitHandler
    public void sendMessage(String message1){
        System.out.println("QQ-log----------------->"+message1);
    }
}
