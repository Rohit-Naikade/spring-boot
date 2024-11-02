package com.example.restapplication.employee.dao;

import com.example.restapplication.employee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager employeeManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery=employeeManager.createQuery("from Employee",
                Employee.class);

        List<Employee> employees=theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {

        Employee employee = employeeManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee employee=employeeManager.merge(theEmployee);

        return employee;
    }

    @Override
    public void delete(Employee employee) {
        employeeManager.remove(employee);
    }
}
