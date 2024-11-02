package com.rohit.hibernatemappings;

import com.rohit.hibernatemappings.dao.AppDAO;
import com.rohit.hibernatemappings.entity.Course;
import com.rohit.hibernatemappings.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernatemappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatemappingsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
				//CreateCourseAndStudents(appDAO);
				//getCourseAndStudents(appDAO);
			//getStudentAndCourses(appDAO);
			//updateStudent(appDAO);
			deleteCourse(appDAO);

		};
	}

	private void deleteCourse(AppDAO appDAO) {

		appDAO.deleteCourseById(1);
		System.out.println("Course Deleted!");
	}

	private void updateStudent(AppDAO appDAO) {

		Student student=appDAO.findStudentAndCoursesByStudentId(1);


		student.addCourse(new Course("C"));
		student.addCourse(new Course("C#"));
		System.out.println(student);
		appDAO.update(student);

		System.out.println("Student updated");
	}

	private void getStudentAndCourses(AppDAO appDAO) {
		Student student=appDAO.findStudentAndCoursesByStudentId(1);
		System.out.println(student);
		System.out.println(student.getCourses());
	}

	private void getCourseAndStudents(AppDAO appDAO) {
		Course course=appDAO.findCourseAndStudentsByCourseId(1);
		System.out.println(course);
		System.out.println(course.getStudents());
	}

	private void CreateCourseAndStudents(AppDAO appDAO) {

		Course tempCourse=new Course("Spring Boot");

		tempCourse.addStudent(new Student("rohit@gmail.com","Naikade","Rohit"));
		tempCourse.addStudent(new Student("kunal@gmail.com","Naikade","Kunal"));

		appDAO.saveCourse(tempCourse);

		System.out.println("Student saved");
	}

}