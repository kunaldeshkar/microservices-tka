package com.tka.studentservice.services;

import com.tka.studentservice.models.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    List<Student> findStudentsBySchool(Integer schoolId);
}
