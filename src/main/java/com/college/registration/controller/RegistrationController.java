package com.college.registration.controller;

import com.college.registration.model.Course;
import com.college.registration.model.Student;
import com.college.registration.model.Teacher;
import com.college.registration.repository.CourseRepository;
import com.college.registration.repository.StudentRepository;
import com.college.registration.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/registration")
public class RegistrationController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @PutMapping(value = "course/{courseId}/student/{studentId}")
    public void registerStudent(@PathVariable Long studentId, @PathVariable Long courseId){
        try{
            Student student = studentRepository.findById(studentId).get();
            Course course = courseRepository.findById(courseId).get();
            course.getRegisteredStudents().add(student);
            courseRepository.save(course);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    @PutMapping(value = "course/{courseId}/teacher/{teacherId}")
    public void registerTeacher(@PathVariable Long teacherId, @PathVariable Long courseId){

        try{
            Teacher teacher = teacherRepository.findById(teacherId).get();
            Course course = courseRepository.findById(courseId).get();

            course.setTeacher(teacher);
            courseRepository.save(course);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

    }

}
