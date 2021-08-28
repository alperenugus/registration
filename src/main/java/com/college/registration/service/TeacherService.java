package com.college.registration.service;

import com.college.registration.dto.TeacherDTO;
import com.college.registration.model.Course;
import com.college.registration.model.Teacher;
import com.college.registration.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseService courseService;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.getAllByOrderByFullName();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public TeacherDTO getTeacherById(Long teacherId) {

        Teacher teacher = teacherRepository.findById(teacherId).get();
        TeacherDTO teacherDTO = new TeacherDTO(teacher);

        List<Course> courses = courseService.getAllCoursesByTeacher(teacher.getTeacherId());

        for(Course course : courses){
            teacherDTO.getCourses().add(course);
        }

        return teacherDTO;
    }

}
