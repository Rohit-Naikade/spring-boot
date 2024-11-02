package com.rohit.hibernatemappings;

import com.rohit.hibernatemappings.dao.AppDAO;
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
			//findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		appDAO.deleteInstructorDetailById(2);
		System.out.println("Instructor Details deleted");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		InstructorDetail theInstructorDetail= appDAO.findInstructorDetailById(2);

		System.out.println("Instructor"+theInstructorDetail.getInstructor());
		System.out.println("Instructor Details"+theInstructorDetail);
	}

	private void deleteInstructor(AppDAO appDAO) {
		appDAO.deleteInstructorById(1);
		System.out.println("Instructor deleted");
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