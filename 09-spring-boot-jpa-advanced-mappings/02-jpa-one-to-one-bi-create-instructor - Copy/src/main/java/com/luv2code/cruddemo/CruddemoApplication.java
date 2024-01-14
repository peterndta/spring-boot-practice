package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 8;
		System.out.println("Delete Instructor Detail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// get instructor detail object
		int theId = 7;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print instructor detail
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);
		// print instructor
		System.out.println("Instructor associate: " + tempInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Delete Instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 7;
		System.out.println("ID tìm là: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("instructorDetail liên quan: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		// create instructor
		Instructor tempInstructor = new Instructor("Chad", "Darby", "example@gmail.com");

		// create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("testlink", "Play game");

		// associate object together
		tempInstructor.setInstructorDetail((tempInstructorDetail));

		// save instructor
		// Dòng thứ 2 ở dưới sẽ save detail object
		// vì có cơ chế CascadeType.ALL
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done");
	}

}








