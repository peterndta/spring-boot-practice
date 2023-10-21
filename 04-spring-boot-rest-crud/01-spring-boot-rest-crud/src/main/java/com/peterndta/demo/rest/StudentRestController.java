package com.peterndta.demo.rest;

import com.peterndta.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> theStudents;

    // define @PostConstruct to load the student data only once!
    @PostConstruct
    public void loadData(){
        theStudents= new ArrayList<>();
        theStudents.add(new Student("Poornima", "John"));
        theStudents.add(new Student("Shree", "Patel"));
        theStudents.add(new Student("Cops", "Tom"));
    }

    // defne endpoints for students - return list students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return  theStudents;
    }

    // define endpoint /students/{studentId}
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // check the studentId nếu vượt lượng size
        if((studentId >= theStudents.size()) || studentId <0){
            throw new StudentNotFoundException("Cannot find studentId - " + studentId);
        }
        return theStudents.get(studentId);
    }

}
