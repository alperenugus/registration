package com.college.registration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;

    @Column(name = "fullName")
    private String fullName;

    @JsonIgnore
    @ManyToMany(mappedBy = "registeredStudents")
    private Set<Course> registeredCourses = new HashSet<>();

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
