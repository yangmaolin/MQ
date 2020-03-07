package com.yml.rabbitmqfanoutconsumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
//会把申请的队列和交换机进行绑定
//确定消息的模式 fanout direct topic
//确定队列queue的持久性
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.fanout.log.queue}",
autoDelete = "true"),
exchange = @Exchange(value = "${mq.fanout.exchangName}",type = ExchangeTypes.FANOUT)))
public class LogService {
    @RabbitHandler
    public void sendMessage(String message){
        System.out.println("log---------->"+message);
    }
}
