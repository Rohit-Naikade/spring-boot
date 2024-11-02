package com.example.restapplication.employee.service;

import com.example.restapplication.employee.entity.Employee;
import com.example.restapplication.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class employeeServiceImpl implements employeeService{

    private EmployeeRepository theEmloyeeRepository;

    @Autowired
    public employeeServiceImpl(EmployeeRepository theEmloyeeRepository) {
        this.theEmloyeeRepository = theEmloyeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return theEmloyeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> employees= theEmloyeeRepository.findById(id);

        Employee theEmployee = null;

        if(employees.isPresent()){
            theEmployee=employees.get();
        }else{
            throw new RuntimeException("Employee not found with id-"+id);
        }

        return theEmployee;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return theEmloyeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void delete(Employee employee) {
        theEmloyeeRepository.delete(employee);
    }
}
