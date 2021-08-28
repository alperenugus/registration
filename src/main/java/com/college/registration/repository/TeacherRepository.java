package com.college.registration.repository;

import com.college.registration.model.Teacher;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long>, JpaSpecificationExecutor<Teacher> {

    List<Teacher> getAllByOrderByFullName();

}

