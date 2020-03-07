package com.yml.activemqpubsubconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;
import javax.jms.JMSException;
import javax.jms.TextMessage;

@SpringBootApplication
public class ActivemqpubsubconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivemqpubsubconsumerApplication.class, args);
    }

    //springboot默认只配置queue类型消息，如果要使用topic类型的消息，则需要配置该bean
//   @Bean
//    public JmsListenerContainerFactory jmsTopicListenerContainerFactory(ConnectionFactory connectionFactory){
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        //这里必须设置为true，false则表示是queue类型
//        factory.setPubSubDomain(true);
//        return factory;
//    }

    //消费者消费消息
    @JmsListener(destination = "boot_topic")
    public void getMessage(TextMessage message) throws JMSException {
        System.out.println("接收到消息："+message.getText());
    }
}
