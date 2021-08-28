package com.college.registration.service;

import com.college.registration.dto.StudentDTO;
import com.college.registration.model.Course;
import com.college.registration.model.Student;
import com.college.registration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseService courseService;

    public List<Student> getAllStudents(){
        return studentRepository.getAllByOrderByFullName();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public StudentDTO getStudentById(Long studentId){
        Student student = studentRepository.findById(studentId).get();

        StudentDTO studentDTO = new StudentDTO(student);

        List<Course> courses = courseService.getAllCoursesByStudent(student.getStudentId());

        for(Course course : courses){
            studentDTO.getRegisteredCourses().add(course);
        }

        return studentDTO;
    }

}
