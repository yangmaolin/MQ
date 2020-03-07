package com.yml.rabbitmqtopicconsumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class WXService {
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.topic.wx.queue}",
            autoDelete = "true"),
            exchange = @Exchange(value="${mq.topic.exchangName}",type= ExchangeTypes.TOPIC),
            key = "wx.*" //路由key
    ))
    @RabbitHandler
    public void sendMessage(String message){
        System.out.println("WX-log----------------->"+message);
    }
}
