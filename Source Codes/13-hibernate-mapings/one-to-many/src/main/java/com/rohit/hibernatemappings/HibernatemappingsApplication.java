package com.rohit.hibernatemappings;

import com.rohit.hibernatemappings.dao.AppDAO;
import com.rohit.hibernatemappings.entity.Course;
import com.rohit.hibernatemappings.entity.Instructor;
import com.rohit.hibernatemappings.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			//createInstructor(appDAO);
			//findInstructor(appDAO, 1);
			//deleteInstructor(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {

		appDAO.deleteCourseById(1);
		System.out.println("Course Deleted");
	}

	private void updateCourse(AppDAO appDAO) {

		Course course=appDAO.findCourseById(1);
		course.setTitle("CPP");
		appDAO.updateCourse(course);
		System.out.println("Course updated: "+course);
	}

	private void updateInstructor(AppDAO appDAO) {

		Instructor instructor=appDAO.findInstructorById(5);
		instructor.setFirstName("Kunal");
		instructor.setLastName("Naikade");
		instructor.setEmail("kunal@gmail.com");
		appDAO.updateInstructor(instructor);
		System.out.println("Instructor updated: "+instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		Instructor instructor=appDAO.findInstructorByIdJoinFetch(5);
		System.out.println(instructor);
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		System.out.println(appDAO.findCoursesByInstructorId(5));
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor=appDAO.findInstructorById(1);
		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor=
				new Instructor("Omkar", "Naikade","rohit@gmail.com");
		InstructorDetail temoInstructorDetail =
				new InstructorDetail("youtube.com","cricket");

		tempInstructor.setInstructorDetail(temoInstructorDetail);
		Course course1=new Course("Java");
		Course course2 =new Course("Python");
		tempInstructor.add(course1);
		tempInstructor.add(course2);

		System.out.println("Saving Instructor : "+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("done");
	}

	private void deleteInstructor(AppDAO appDAO) {
		appDAO.deleteInstructorById(5);
	}

	private void findInstructor(AppDAO appDAO, int i) {
		System.out.println(appDAO.findInstructorById(i));
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor tempInstructor=
				new Instructor("Rohit", "Naikade","rohit@gmail.com");
		InstructorDetail temoInstructorDetail =
				new InstructorDetail("youtube.com","cricket");

		tempInstructor.setInstructorDetail(temoInstructorDetail);

		System.out.println("Saving Instructor : "+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("done");
	}
}
