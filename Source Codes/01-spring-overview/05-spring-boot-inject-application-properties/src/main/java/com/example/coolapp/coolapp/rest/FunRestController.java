package com.example.coolapp.coolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private  String coachName;

    @Value("${coach.surname}")
    private String coachSurname;

    @GetMapping("/coachinfo")
    public String teamInfo(){
        return coachName+" "+coachSurname;
    }
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/rohit")
    public String sayHellotoRohit(){
        return "Hello Rohit Naikade!";
    }
}
