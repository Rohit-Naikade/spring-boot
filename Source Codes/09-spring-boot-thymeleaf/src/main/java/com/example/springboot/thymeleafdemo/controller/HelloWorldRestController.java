package com.example.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldRestController {

    @GetMapping("/showform")
    public String showForm(){
        return "show-form";
    }

    @RequestMapping("/processform")
    public String processForm(){
        return "process-helloworld";
    }

    @RequestMapping("/processformv2")
    public String letsShoutdude(HttpServletRequest request, Model model){
        String theName=request.getParameter("studentName");

        theName=theName.toUpperCase();

        String result="Yo! "+theName;
        model.addAttribute("message",result);
        return "hello-world";
    }

    @PostMapping("/processformv3")
    public String processv3(@RequestParam("studentName") String theName, Model model){

        theName=theName.toUpperCase();

        String result="Yo! "+theName;
        model.addAttribute("message",result);
        return "hello-world";
    }
}
