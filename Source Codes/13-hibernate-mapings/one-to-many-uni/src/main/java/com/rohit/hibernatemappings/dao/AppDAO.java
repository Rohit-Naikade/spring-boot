package com.rohit.hibernatemappings.dao;

import com.rohit.hibernatemappings.entity.Course;
import com.rohit.hibernatemappings.entity.Instructor;
import jakarta.persistence.TypedQuery;

import java.util.List;

public interface AppDAO {

    public void save(Instructor theInstructor);

    public Instructor findInstructorById(int id);

    public void deleteInstructorById(int id);

    public List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    public void updateInstructor(Instructor theInstructor);

    public void updateCourse(Course course);

    public Course findCourseById(int id);

    public void deleteCourseById(int id);

    public void saveCourse(Course course);

    public Course getCourseById(int id);
}
