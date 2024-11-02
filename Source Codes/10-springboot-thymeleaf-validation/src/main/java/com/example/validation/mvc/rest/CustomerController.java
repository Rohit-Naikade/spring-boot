package com.example.validation.mvc.rest;

import com.example.validation.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
    @GetMapping("/show")
    public String showCustomer(Model model){

        model.addAttribute("customer", new Customer());
        return "show-form";
    }

    @PostMapping("/processform")
    public String processCustomer(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult theBindingResult){

        System.out.println("LastName: |"+customer.getLastName()+"|");
            if(theBindingResult.hasErrors()){
                return "show-form";
            }

           return "show-confirmation";
    }
}
