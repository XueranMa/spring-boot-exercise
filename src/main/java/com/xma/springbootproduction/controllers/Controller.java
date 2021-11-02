package com.xma.springbootproduction.controllers;

import com.xma.springbootproduction.models.Message;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

//import java.util.logging.*;
//import com.amazonaws.util.EC2MetadataUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/api")
public class Controller {

    Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/helloworld")
    public String say() {
        // Getting EC2 private IP
        //String privateIP = EC2MetadataUtils.getInstanceInfo().getPrivateIp();
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            logger.info("Your current IP address : " + ip);
            return "Hello World from "+ ip;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @GetMapping("/message")
    Message send() {
        return new Message("first message");
    }

    @PostMapping("/message")
    Message echo (@RequestBody Message message) {
        return message;
    }
}
