package com.example.restapplication.employee.service;

import com.example.restapplication.employee.dao.EmployeeDAO;
import com.example.restapplication.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class employeeServiceImpl implements employeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public employeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void delete(Employee employee) {
            employeeDAO.delete(employee);
    }
}
