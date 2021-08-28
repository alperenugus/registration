package com.college.registration.controller;

import com.college.registration.dto.StudentDTO;
import com.college.registration.model.Student;
import com.college.registration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public long addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return student.getStudentId();
    }

    @GetMapping(value = "/{studentId}")
    public StudentDTO getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

}
