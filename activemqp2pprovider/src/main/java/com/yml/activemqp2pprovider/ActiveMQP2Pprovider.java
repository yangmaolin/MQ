package com.yml.activemqp2pprovider;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ActiveMQP2Pprovider {
    //注入JMSTemplate
    @Resource
    private JmsTemplate jmsTemplate;

    public void setMessage(){
        //点对点创建队列
        ActiveMQQueue queue=new ActiveMQQueue("boot_queue");
        jmsTemplate.convertAndSend(queue,"提供者发出消息：我来了");
    }
}
