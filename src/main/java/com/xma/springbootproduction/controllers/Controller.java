package com.xma.springbootproduction.controllers;

import com.xma.springbootproduction.models.Message;
import org.springframework.web.bind.annotation.*;
//import com.amazonaws.util.EC2MetadataUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/helloworld")
    public String say() {
        // Getting EC2 private IP
        //String privateIP = EC2MetadataUtils.getInstanceInfo().getPrivateIp();
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            System.out.println("Your current IP address : " + ip);
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
