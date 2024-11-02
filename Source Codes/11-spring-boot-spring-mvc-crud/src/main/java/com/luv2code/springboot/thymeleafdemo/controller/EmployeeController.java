package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService theEmployeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        theEmployeeService=employeeService;
    }

    @GetMapping("/list")
    public String getEmployees(Model theModel){
        List<Employee> employees=theEmployeeService.findAll();

        theModel.addAttribute("employees",employees);

        return "employees/list-employees";
    }

    @GetMapping("/addemployee")
    public String addEMployee(Model model){
        Employee theEmployee=new Employee();
        model.addAttribute("employee",theEmployee);
        return "employees/employeeform";
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model){
        Employee theEmployee=theEmployeeService.findById(id);
        model.addAttribute("employee",theEmployee);
        return "employees/employeeform";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        theEmployeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId){

        theEmployeeService.deleteById(theId);
        return "redirect:/employees/list";
    }
}
