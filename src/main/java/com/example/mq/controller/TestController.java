package com.example.mq.controller;

import com.example.mq.sender.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianweichang
 * @date 2018-05-08 10:51
 **/
@RestController
public class TestController {
    @Autowired
    private RabbitSender rabbitSender;
    @GetMapping("/sender")
    public String helloWorld() {
        for(int i=0;i<1000;i++) {
            rabbitSender.sendMsg("name_"+System.currentTimeMillis());
        }
        return "success";
    }

}
