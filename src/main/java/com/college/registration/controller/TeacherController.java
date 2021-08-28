package com.college.registration.controller;

import com.college.registration.dto.TeacherDTO;
import com.college.registration.model.Teacher;
import com.college.registration.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @PostMapping
    public long addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return teacher.getTeacherId();
    }

    @GetMapping(value = "/{teacherId}")
    public TeacherDTO getTeacherById(@PathVariable Long teacherId){return teacherService.getTeacherById(teacherId);}

}
