package com.yml.activemqp2pconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@SpringBootApplication
public class Activemqp2pconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Activemqp2pconsumerApplication.class, args);
    }

    @JmsListener(destination = "boot_queue")
    public void getMessage(TextMessage message)throws JMSException{
        System.out.println("接收到的消息："+message.getText());
    }
}
