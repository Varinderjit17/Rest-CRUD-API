package com.rupicodes.Rest.API.Rest;

import com.rupicodes.Rest.API.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestPojoController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        System.out.println("Array List data initialised");
        students = new ArrayList<>();
        students.add(new Student("Rupi" , "Sadhra"));
        students.add(new Student("Aish" , "Reet"));
        students.add(new Student("Avi" , "Taj"));
    }


    @GetMapping("/student")
    public List<Student> getStudent() {
        return students;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        if(studentId >= students.size() || studentId<0) {
            throw new StudentNotFoundException("Student ID not found  " + studentId);
        }
        return students.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        //create error response object
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(System.currentTimeMillis());

        //return Response Entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //Handle generic exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAllException(Exception exception) {
        //create error response object
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(System.currentTimeMillis());

        //return Response Entity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
