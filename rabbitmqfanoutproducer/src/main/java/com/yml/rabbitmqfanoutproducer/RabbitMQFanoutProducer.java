package com.yml.rabbitmqfanoutproducer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class RabbitMQFanoutProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${mq.fanout.exchangName}")
    private String exchangName;
    private String routeKey="";

    public void sendMessage(int i){
        String orderId= UUID.randomUUID().toString();
        String message="你的订单第【"+i+"】个信息是："+orderId+new Date().toString();
        System.out.println("正在发送---------------》》》》》》》："+message);
        rabbitTemplate.convertAndSend(exchangName,routeKey,message);
    }
}
