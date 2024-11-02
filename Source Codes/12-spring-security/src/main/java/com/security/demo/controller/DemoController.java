package com.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        //return "plain-login";
        return "fancy-login";
    }

    @GetMapping("/leaders")
    public String leaders(){

        return "leaders";
    }

    @GetMapping("/systems")
    public String systems(){

        return "systems";
    }
    @GetMapping("/access-denied")
    public String accessDenied(){

        return "access-denied";
    }
}
