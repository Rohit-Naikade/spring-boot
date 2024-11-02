package com.rohit.hibernatemappings.dao;

import com.rohit.hibernatemappings.entity.Course;
import com.rohit.hibernatemappings.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    public EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor=entityManager.find(Instructor.class, id);

        List<Course> courses=instructor.getCourses();

        for(Course tempCourse: courses){
            tempCourse.setInstructor(null);
        }

        instructor.setCourses(courses);
        System.out.println("Instructor after removing associations: "+instructor);

        entityManager.remove(instructor);
    }

    public List<Course> findCoursesByInstructorId(int id){
        TypedQuery<Course> query=entityManager.createQuery("from Course where instructor.id = :data",
                Course.class);
        query.setParameter("data",id);
        List<Course> courses=query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {

        TypedQuery<Instructor> instructor=entityManager.createQuery("select i from Instructor i " +
                "JOIN FETCH i.courses where i.id= :data", Instructor.class);
        instructor.setParameter("data",id);

        return instructor.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor theInstructor) {
        entityManager.merge(theInstructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {

        Course course=entityManager.find(Course.class,id);
        return course;
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course=entityManager.find(Course.class,id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course getCourseById(int id) {

        TypedQuery<Course> query= entityManager.createQuery(
                "select c from Course c " +
                        "JOIN FETCH c.reviews " +
                        "where c.id= : data ", Course.class );
        query.setParameter("data",id);
        return query.getSingleResult();
    }
}
