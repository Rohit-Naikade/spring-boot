package com.example.springboot.thymeleafdemo.controller;

import com.example.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    List<String> countries;

    @Value("${languages}")
    List<String> languages;

    @Value("${operatingSystems}")
    List<String> operatingSystems;

    @GetMapping("/getstudentform")
    public String getStudentForm(Model model){

        model.addAttribute("student",new Student());
        model.addAttribute("countries", countries);
        model.addAttribute("languages", languages);
        model.addAttribute("operatingSystems", operatingSystems);
        return "student-form";
    }

    @PostMapping("/processstudent")
    public String processStudentForm(@ModelAttribute("student") Student student, Model model){

        return "process-student";
    }
}
