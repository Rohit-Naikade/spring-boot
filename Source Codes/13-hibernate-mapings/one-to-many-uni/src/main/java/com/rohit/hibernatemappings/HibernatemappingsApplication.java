package com.rohit.hibernatemappings;

import com.rohit.hibernatemappings.dao.AppDAO;
import com.rohit.hibernatemappings.entity.Course;
import com.rohit.hibernatemappings.entity.Review;
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
			//saveCourseAndReviews(appDAO);
			//getCourseAndReviews(appDAO);
			deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		appDAO.deleteCourseById(1);
		System.out.println("Course Deleted");
	}

	private void getCourseAndReviews(AppDAO appDAO) {

		Course course=appDAO.getCourseById(1);

		System.out.println(course);
		System.out.println(course.getReviews());
	}

	private void saveCourseAndReviews(AppDAO appDAO) {

		Course course=new Course("Android");

		course.addReview(new Review("Great Course!"));
		course.addReview(new Review("Cool Course, good job!"));
		course.addReview(new Review("Bad Course!"));

		appDAO.saveCourse(course);
	}

}