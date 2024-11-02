package com.example.restapplication.employee.rest;

import com.example.restapplication.employee.dao.EmployeeDAO;
import com.example.restapplication.employee.entity.Employee;
import com.example.restapplication.employee.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    private employeeService theEmployeeService;

    @Autowired
    public EmployeeRestController(employeeService theEmployeeService) {
        this.theEmployeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return theEmployeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = theEmployeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee not found with id - "+employeeId);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        theEmployee.setId(0);

        Employee employee = theEmployeeService.save(theEmployee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee employee = theEmployeeService.save(theEmployee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee employee = theEmployeeService.findById(employeeId);

        if(employee==null){
            throw new RuntimeException("EMployee not present with id - "+employeeId);
        }

        theEmployeeService.delete(employee);
        return "Employee deleted = "+employee.getId();
    }

}
