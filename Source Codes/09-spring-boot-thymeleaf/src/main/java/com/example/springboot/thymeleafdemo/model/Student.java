package com.example.springboot.thymeleafdemo.model;

import java.util.List;

public class Student {

    private String firstName, lastName, country, programmingLanguage;
    private List<String> operatingSystems;
    public Student() {
    }

    public Student(String firstName, String lastName, String country, String programmingLanguage,
                   List<String> operatingSystems) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.programmingLanguage = programmingLanguage;
        this.operatingSystems = operatingSystems;
    }

    public List<String> getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(List<String> operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
