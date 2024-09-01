package com.rupicodes.Rest.API.Rest;

import com.rupicodes.Rest.API.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    }


    @GetMapping("/student")
    public List<Student> getStudent() {
        return students;
    }
}
