package com.rohit.hibernatemappings.dao;

import com.rohit.hibernatemappings.entity.Instructor;
import com.rohit.hibernatemappings.entity.InstructorDetail;

public interface AppDAO {

    public void save(Instructor theInstructor);

    public Instructor findInstructorById(int id);

    public InstructorDetail findInstructorDetailById(int id);

    public void deleteInstructorById(int id);

    public void deleteInstructorDetailById(int id);
}
