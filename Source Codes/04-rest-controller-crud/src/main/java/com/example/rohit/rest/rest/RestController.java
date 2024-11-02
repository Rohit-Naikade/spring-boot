package com.example.rohit.rest.rest;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/sayhello")
    public String sayHello(){
        return "Hello world";
    }
}
