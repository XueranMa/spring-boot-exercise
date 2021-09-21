package com.xma.springbootproduction.controllers;

import com.xma.springbootproduction.models.Message;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/helloworld")
    public String say() {
        return "Hello World!";
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
