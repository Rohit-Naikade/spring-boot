package com.example.restapplication.employee.dao;

import com.example.restapplication.employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee employee);

    public void delete(Employee employee);
}
