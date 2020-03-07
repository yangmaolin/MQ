package com.yml.rabbitmqdirectproducer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

//    1、定义交换机
    @Value("${mq.direct.exchangName}")
    private String exchangName;

//    保存用户
    public void saveUser(int i){
        //订单消息
        String orderId= UUID.randomUUID().toString();
        //消息
        String message="保存用户："+orderId+new Date().toString();
        System.out.println("正在发送user---------->>>>:"+message);
        //将消息通过路由发送到队列email
        rabbitTemplate.convertAndSend(exchangName,"email",message);
        //将消息通过路由发送到队列wx
        rabbitTemplate.convertAndSend(exchangName,"wx",message);
        //将消息通过路由发送到队列log
        rabbitTemplate.convertAndSend(exchangName,"log",message);
    }
}
