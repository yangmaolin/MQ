package com.yml.rabbitmqfanoutproducer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqfanoutproducerApplicationTests {

    @Autowired
    private RabbitMQFanoutProducer rabbitMQFanoutProducer;

    @Test
    void contextLoads() {
        try{
            for(int i=0;i<10;i++){
                rabbitMQFanoutProducer.sendMessage(i);
                Thread.sleep(2);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
