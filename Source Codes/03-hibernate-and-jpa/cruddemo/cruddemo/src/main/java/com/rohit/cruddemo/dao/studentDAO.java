package com.rohit.cruddemo.dao;

import com.rohit.cruddemo.entity.Student;

import java.util.List;

public interface studentDAO {

    public void save(Student theStudent);

    public Student find(Integer id);

    public List<Student> findAll();

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByLastName(String lastName);

    public void updateStudent(Student theStudent);

    public void deleteStudent(Integer Id);

    public Integer deleteAll();

}
