package com.xma.springbootproduction.controllers;

import com.xma.springbootproduction.models.Message;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.web.bind.annotation.*;


import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/api")
public class Controller {

    private static final Logger logger = LogManager.getLogger(Controller.class);

    @GetMapping("/helloworld")
    public String say() {

        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            logger.debug("Your current IP address : " + ip);
            return "Hello World from "+ ip;
        } catch (UnknownHostException e) {
            logger.debug("Error: " + e.getMessage());
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @GetMapping("/message")
    Message send() {
        logger.info("Request to get first message");
        return new Message("first message");
    }

    @PostMapping("/message")
    Message echo (@RequestBody Message message) {
        logger.info("Request to post first message");
        return message;
    }
}
