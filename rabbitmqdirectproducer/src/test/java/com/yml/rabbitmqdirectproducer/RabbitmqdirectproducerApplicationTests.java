package com.yml.rabbitmqdirectproducer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqdirectproducerApplicationTests {
    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        try{
            for (int i = 0; i < 10; i++) {
                orderService.saveUser(i);
                Thread.sleep(2);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
