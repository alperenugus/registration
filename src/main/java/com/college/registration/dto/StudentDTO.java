package com.college.registration.dto;

import com.college.registration.model.Course;
import com.college.registration.model.Student;

import java.util.HashSet;
import java.util.Set;

public class StudentDTO {

    private long studentId;
    private String fullName;
    private Set<Course> registeredCourses = new HashSet<>();

    public StudentDTO(Student student){
        this.studentId = student.getStudentId();
        this.fullName = student.getFullName();
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(Set<Course> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }
}
