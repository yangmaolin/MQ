package com.yml.activemqpubsubprovider;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ActiveMQPubSubprovider {
    @Resource
    private JmsTemplate jmsTemplate;

    public void setMessage(){
        //创建主题
        ActiveMQTopic topic=new ActiveMQTopic("boot_topic");
        //springboot默认是队列，topic需要如下设置
        jmsTemplate.setPubSubDomain(true);
        //发送消息
        jmsTemplate.convertAndSend(topic,"消息：主题topic");
    }
}
