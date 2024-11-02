package com.example.restapplication.employee.service;

import com.example.restapplication.employee.entity.Employee;

import java.util.List;

public interface employeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee employee);

    public void delete(Employee employee);
}
