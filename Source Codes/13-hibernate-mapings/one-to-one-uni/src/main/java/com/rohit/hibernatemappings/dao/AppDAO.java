package com.rohit.hibernatemappings.dao;

import com.rohit.hibernatemappings.entity.Instructor;

public interface AppDAO {

    public void save(Instructor theInstructor);

    public Instructor findInstructorById(int id);

    public void deleteInstructorById(int id);
}
