package com.yml.rabbitmqtopicproducer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

//    定义交换机
    @Value("${mq.topic.exchangName}")
    private String exchangName;

//    WX
    public void QQ(int i){
//        订单信息
        String orderId= UUID.randomUUID().toString();
//        消息
        String message="你的WX第【"+i+"】个消息是："+orderId;
        System.out.println("正在发送WX---------->:"+message);

//        通配符topic
        rabbitTemplate.convertAndSend(exchangName,"qq.log",message);
    }

    //QQ
    public void WX(int i){
//        订单信息
        String orderId= UUID.randomUUID().toString();
//        消息
        String message="你的QQ第【"+i+"】个消息是："+orderId;
        System.out.println("正在发送QQ---------->:"+message);

//        通配符topic
        rabbitTemplate.convertAndSend(exchangName,"wx.log",message);
    }
}
