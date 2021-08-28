package com.college.registration.service;

import com.college.registration.model.Course;
import com.college.registration.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return courseRepository.getAllByOrderByName();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public List<Course> getAllCoursesByStudent(Long studentId){
        return courseRepository.getAllCoursesByStudent(studentId);
    }

    public List<Course> getAllCoursesByTeacher(Long teacherId) {
        return courseRepository.getAllCoursesByTeacher(teacherId);
    }

    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).get();
    }
}
