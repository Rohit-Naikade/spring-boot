package com.example.validation.mvc.model;


import com.example.validation.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    @NotNull(message="is required")
    @Size(min=1,message="is required")
    private String firstName="";

    @CourseCode
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @NotNull(message="is required")
    @Size(min=1,message="is required")
    private String lastName="";

    @NotNull(message="is required")
    @Min(value=0,message="value must be grater or equals zero")
    @Max(value=10,message="value must be less than or equals ten")
    private Integer freePasses;

    @Pattern(regexp="^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;

    public @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits") String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits") String postalCode) {
        this.postalCode = postalCode;
    }

    @NotNull(message = "is required")
    @Min(value = 0, message = "value must be grater or equals zero")
    @Max(value = 10, message = "value must be less than or equals ten")
    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(@NotNull(message = "is required") @Min(value = 0, message = "value must be grater or equals zero") @Max(value = 10, message = "value must be less than or equals ten") Integer freePasses) {
        this.freePasses = freePasses;
    }

    public Customer() {
    }

    public Customer(String firstName, String lastName, Integer freePasses, String postalCode, String courseCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.freePasses = freePasses;
        this.postalCode = postalCode;
        this.courseCode = courseCode;
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
