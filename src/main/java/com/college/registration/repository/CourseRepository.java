package com.college.registration.repository;

import com.college.registration.model.Course;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long>, JpaSpecificationExecutor<Course> {

    List<Course> getAllByOrderByName();

    @Query(value = "Select * FROM courses " +
            "WHERE course_id IN " +
            "(SELECT registered_courses_course_id " +
            "FROM courses_registered_students " +
            "WHERE registered_students_student_id = :id)", nativeQuery = true)
    List<Course> getAllCoursesByStudent(@Param("id") Long studentId);

    @Query(value = "Select * FROM courses " +
            "WHERE teacher_teacher_id = :id", nativeQuery = true)
    List<Course> getAllCoursesByTeacher(@Param("id") Long teacherId);
}
