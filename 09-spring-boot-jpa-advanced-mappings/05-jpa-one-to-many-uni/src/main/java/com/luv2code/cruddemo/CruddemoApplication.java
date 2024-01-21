package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
//			createCourseAndReview(appDAO);
//			getCourseAndReview(appDAO);
			deleteCourseAndReview(appDAO);
		};
	}

	private void deleteCourseAndReview(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Delete course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done");
	}

	private void getCourseAndReview(AppDAO appDAO) {

		// get course and review
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewByCourseId(theId);

		// print course
		System.out.println(tempCourse);

		// print reviews
		System.out.println(tempCourse.getReviews());

		System.out.println("Done");
	}

	private void createCourseAndReview(AppDAO appDAO) {
		// create course
		Course course = new Course("How to play Valorant");

		// add review vào Course
		course.addReview(new Review("Course ngon lam"));
		course.addReview(new Review("Qua hay"));
		course.addReview(new Review("Review nay cho 5 sao"));

		// save course
		System.out.println("Save course:");
		System.out.println(course);
		System.out.println(course.getReviews());

		appDAO.save(course);
	}

	private void deleteCourseOneToMany(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Delete Course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done");
	}

	private void deleteInstructorOneToMany(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Delete Instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done");
	}

	private void udpateCourse(AppDAO appDAO) {
		int theId = 10;
		// find course
		System.out.println("Finding the course id: "+ theId);
		Course tempCourse = appDAO.findCourseById(theId);

		//update instructor
		System.out.println("Update Course");
		tempCourse.setTitle("Enjoy simple thing");

		appDAO.updateCourse(tempCourse);

		System.out.println("Done");
	}

	private void udpateInstructor(AppDAO appDAO) {
		int theId = 1;
		// find instructor
		System.out.println("Finding the instructor id: "+ theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		//update instructor
		System.out.println("Update Instructor");
		tempInstructor.setLastName("TESTER");

		appDAO.update(tempInstructor);

		System.out.println("Done");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId =1;
		System.out.println("Finding the instructor id: "+ theId);

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		System.out.println("The associated courses: " + tempInstructor.getCourses());

		System.out.println("Done");
	}

	private void findCourseForInstructor(AppDAO appDAO) {
		int theId =1;
		System.out.println("Finding the instructor id: "+ theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		// find Course cho instructor
		System.out.println("Finding course for instructor id: " + theId);
		List<Course> courseList = appDAO.findCourseByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courseList);

		System.out.println("The associated courses: " + tempInstructor.getCourses());

		System.out.println("Done");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId =1;
		System.out.println("Finding the instructor id: "+ theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// create instructor
		Instructor tempInstructor = new Instructor("Susan", "Nguyen", "example123@gmail.com");

		// create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com", "Read book");

		// associate object together
		tempInstructor.setInstructorDetail((tempInstructorDetail));


		// create courses
		Course tempCourse1 = new Course("Programming Class");
		Course tempCourse2 = new Course("Instrument");
		Course tempCourse3 = new Course("Hockey");

		// add course cho instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);

		// save instructor
		// cũng save luôn Courses
		// vì do CascadeType.PERSIST
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("Saving course: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done");
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








