package com.imadityak.springBootSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
        new Student(1, "Aditya", 100),
        new Student(2, "Rahul", 90),
        new Student(3, "Rohit", 80)
    ));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }
}