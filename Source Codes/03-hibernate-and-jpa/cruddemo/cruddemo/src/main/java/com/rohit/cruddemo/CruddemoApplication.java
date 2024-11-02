package com.rohit.cruddemo;

import com.rohit.cruddemo.dao.studentDAO;
import com.rohit.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(studentDAO studentDAO){
		return  runner->{

			createMultipleStudents(studentDAO);
			//retrieveStudent(studentDAO);
			//getStudents(studentDAO);
			//getByFirstName(studentDAO);
			//getByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(studentDAO studentDAO) {

		System.out.println("Students before delete:");
		List<Student> theStudents=studentDAO.findAll();

		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
		studentDAO.deleteAll();
		System.out.println("Students after delete:");
		studentDAO.findAll();
	}

	private void deleteStudent(studentDAO studentDAO) {

		studentDAO.deleteStudent(1);

		System.out.println("Remaining Students:");

		List<Student> students=studentDAO.findAll();
		for(Student tempStudent: students){
			System.out.println(tempStudent);
		}
	}

	private void updateStudent(studentDAO studentDAO) {

		Student theStudent=studentDAO.find(1);

		System.out.println("Retrieved Object: "+theStudent);
		theStudent.setFirstName("Siddharth");
		theStudent.setEmail("siddharth@gmail.com");

		System.out.println("Updating Object:");

		studentDAO.updateStudent(theStudent);

		System.out.println("Updated Object:"+studentDAO.find(1));
	}

	private void getByLastName(studentDAO studentDAO) {

		List<Student> theStudents=studentDAO.findByLastName("Naikade");

		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void getByFirstName(studentDAO studentDAO) {
		List<Student> theStudents=studentDAO.findByFirstName("Rohit");

		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void createMultipleStudents(studentDAO studentDAO) {

		System.out.println("Creating students..");

		Student student1=new Student("omkar@gmail.com","Naikade","Omkar");
		Student student2=new Student("kunal@gmail.com","Naikade","Kunal");
		Student student3=new Student("ganesh@gmail.com","Naikade","Ganesh");
		Student student4=new Student("rohit@gmail.com","Naikade","Rohit");
		Student student5=new Student("siddharth@gmail.com","Naikade","Siddharth");


		System.out.println("Saving students..");

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		studentDAO.save(student4);
		studentDAO.save(student5);
	}

	private void getStudents(studentDAO studentDAO) {

		List<Student> students=studentDAO.findAll();

		for(Student tempStudent: students){
			System.out.println(tempStudent);
		}
	}

	private void retrieveStudent(studentDAO studentDAO) {

		System.out.println("Creating a new student:");

		Student student=new Student("rohit@gmail.com","Naikade","Rohit");

		System.out.println("Saving a student..");

		studentDAO.save(student);

		System.out.println("Saved student with id"+student.getId());

		Student retrievedStudent= studentDAO.find(student.getId());
		System.out.println("Retrieved Object: "+retrievedStudent);
	}

}
