package com.xma.springbootproduction.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/helloworld")
public class Controller {

    @GetMapping
    public String say() {
        return "Hello World!";
    }
}
