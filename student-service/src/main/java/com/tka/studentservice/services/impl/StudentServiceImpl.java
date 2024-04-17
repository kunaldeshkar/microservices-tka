package com.tka.studentservice.services.impl;

import com.tka.studentservice.models.Student;
import com.tka.studentservice.repositories.StudentRepository;
import com.tka.studentservice.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findStudentsByInstitute(Integer instituteId) {
        return studentRepository.findAllByInstituteId(instituteId);
    }
}
