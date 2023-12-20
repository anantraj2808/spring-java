package com.anantraj.demo.rest;

import com.anantraj.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

    //define @PostConstruct, like initState
    @PostConstruct
    public void loadData(){
        students = new ArrayList<Student>();
        students.add(new Student("Anant", "Raj"));
        students.add(new Student("Aditya", "Raj"));
        students.add(new Student("Ajay", "Sharma"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){

        if(studentId >= students.size() || studentId < 0){
            throw new StudentNotFoundException("Student ID not found - " + studentId);
        }

        return  students.get(studentId);
    }

    //Adding exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        //return response
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //to catch generic error
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleGenericException(Exception exc){
        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        //return response
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
