package com.yml.rabbitmqdirectconsumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class WxService {
//会把申请的队列和交换机进行绑定
//确定消息的模式 fanout  direct topic
//确定队列queue的持久性 autoDelete = "false"：代表持久化
    @RabbitListener(
            bindings = @QueueBinding(value = @Queue(value = "${mq.direct.wx.queue}",
                    autoDelete = "false"),
                    exchange = @Exchange(value = "${mq.direct.exchangName}",type = ExchangeTypes.DIRECT),
                    key = "wx" //路由Key
            ))
    @RabbitHandler
    public void sendMessage(String message){
        System.out.println("wx-log----------->"+message);
    }
}
