package com.yml.activemqpubsubprovider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ActiveMQPubSubProviderController {
    @Resource
    private ActiveMQPubSubprovider activeMQPubSubprovider;

    @RequestMapping("/setMessage")
    public String setMessage(){
        activeMQPubSubprovider.setMessage();
        return "chenggong";
    }
}
