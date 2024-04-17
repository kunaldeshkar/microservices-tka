package com.tka.studentservice.repositories;

import com.tka.studentservice.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllByInstituteId(Integer instituteId);
}
