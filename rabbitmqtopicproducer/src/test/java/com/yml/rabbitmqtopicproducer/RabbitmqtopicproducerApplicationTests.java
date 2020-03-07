package com.yml.rabbitmqtopicproducer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqtopicproducerApplicationTests {

    @Autowired
    private OrderService producer;

    @Test
    void contextLoads() {
        try{
            for (int i = 0; i < 1; i++) {
                producer.QQ(i);
                producer.WX(i);
                Thread.sleep(2);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
