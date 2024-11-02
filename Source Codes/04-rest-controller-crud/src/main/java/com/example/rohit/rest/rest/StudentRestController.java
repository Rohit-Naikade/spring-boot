package com.example.rohit.rest.rest;

import com.example.rohit.rest.entity.Student;
import com.example.rohit.rest.entity.StudentErrorResponse;
import com.example.rohit.rest.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentRestController {

    List<Student> students=new ArrayList<>() ;

    @PostConstruct
    public void loadData(){

        students.add(new Student(1,"Rohit","Naikade"));
        students.add(new Student(2,"Omkar","Naikade"));
        students.add(new Student(3,"Kunal","Naikade"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable Integer studentId){

        Student tempStudent = null;

        for(Student temp: students){
            if(temp.getId()==studentId){
                tempStudent=temp;
            }
        }

        if(tempStudent==null){
            throw new StudentNotFoundException("Student Id not found -"+studentId);
        }
        return tempStudent;
    }
}
