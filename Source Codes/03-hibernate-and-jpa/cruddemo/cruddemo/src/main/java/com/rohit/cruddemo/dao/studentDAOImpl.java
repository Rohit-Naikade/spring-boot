package com.rohit.cruddemo.dao;

import com.rohit.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class studentDAOImpl implements studentDAO{

    private EntityManager entityManager;

    @Autowired
    public studentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student find(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theStudents=entityManager.createQuery("FROM Student " +
                                                      "order by firstName DESC", Student.class);
        return theStudents.getResultList();
    }

    @Override
    public List<Student> findByFirstName(String firstName) {

        TypedQuery<Student> theStudents=entityManager.createQuery("from Student " +
                                                     " where firstName=:theData", Student.class);

        theStudents.setParameter("theData",firstName);
        return theStudents.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theStudents=entityManager.createQuery("from Student " +
                " where lastName=:theData", Student.class);

        theStudents.setParameter("theData",lastName);
        return theStudents.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {

        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void deleteStudent(Integer Id) {

        Student theStudent=find(1);
        System.out.println("Object to be deleted: "+theStudent);

        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public Integer deleteAll() {
        Integer noOfDeletedRows=entityManager.createQuery("Delete from Student").executeUpdate();

        return noOfDeletedRows;
    }
}
