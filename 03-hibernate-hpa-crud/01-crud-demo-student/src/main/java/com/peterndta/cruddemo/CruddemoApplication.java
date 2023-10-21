package com.peterndta.cruddemo;

import com.peterndta.cruddemo.dao.StudentDAO;
import com.peterndta.cruddemo.entity.Student;
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
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//			createStudent(studentDAO);

			createMultipleStudent(studentDAO);

//			readStudent(studentDAO);

//            queryForStudents(studentDAO);
//            queryStudentsByLastName(studentDAO);

//            updateStudent(studentDAO);
            
//            deleteStudent(studentDAO);
//        deleteAllStudent(studentDAO);

        };
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println("Delete all........");
        int numberRows = studentDAO.deleteAll();
        System.out.println("Rows deleted: " + numberRows);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        // lấy student dựa id
        int studentID = 1;

        // Display
        System.out.println("Delete Student ID: " + studentID);

        studentDAO.delete(studentID);
    }

    private void updateStudent(StudentDAO studentDAO) {
        // lấy student dựa id
        int studentID = 1;
        System.out.println("Get student with id: " + studentID);
        Student student = studentDAO.findById(studentID);

        // change firstName
        System.out.println("Update student....");
        student.setFirstName("Scooby");

        // update student
        studentDAO.update(student);

        // display
        System.out.println("Update Student: " +student);
    }

    private void queryStudentsByLastName(StudentDAO studentDAO) {
        // get list students
        List<Student> students = studentDAO.findByLastName("Duck");

        // display
        for (Student tempStudent : students){
            System.out.println(tempStudent);
        }

    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get list students
        List<Student> students = studentDAO.findAll();

        // display
        for (Student tempStudent : students) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // create student object
        Student tempStudent = new Student("Daffy", "duck", "daffy@gmail.com");
        System.out.println("Create student.......");
        // save the student
        studentDAO.save(tempStudent);
        System.out.println("Save student.......");
        // display id of the saved student
        System.out.println("Student ID: " + tempStudent.getId());

        // lấy student dựa trên id (primary key)
        Student student = studentDAO.findById(tempStudent.getId());

        // show student
        System.out.println("Student Found: " + student);

        // Gọp lại bược lấy và print
//		System.out.println("Student Found: " + studentDAO.findById(tempStudent.getId()));
    }

    private void createMultipleStudent(StudentDAO studentDAO) {
        Student tempStudent1 = new Student("Mary", "Jos", "mary@gmail.com");
        Student tempStudent2 = new Student("Peter", "Apple", "pater@gmail.com");
        Student tempStudent3 = new Student("Monita", "Pen", "monity@gmail.com");
        System.out.println("Create success 3 student.......");

        System.out.println("Save the students..........");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    // Method cho save student xuống DB
    private void createStudent(StudentDAO studentDAO) {
        // create student object
        Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");
        System.out.println("Create success.......");
        // save student object
        studentDAO.save(tempStudent);
        System.out.println("Save success.......");
        // display id của student vừa save
        System.out.println("Student ID: " + tempStudent.getId());
    }
}
