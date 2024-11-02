package com.example.coolapp.coolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/rohit")
    public String sayHellotoRohit(){
        return "Hello Rohit Naikade!";
    }
}
