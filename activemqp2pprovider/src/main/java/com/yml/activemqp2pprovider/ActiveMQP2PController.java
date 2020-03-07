package com.yml.activemqp2pprovider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ActiveMQP2PController {
    @Resource
    private ActiveMQP2Pprovider activeMQP2Pprovider;

    @RequestMapping("/setMessage")
    public String setMessage(){
        activeMQP2Pprovider.setMessage();
        return "成功";
    }
}
