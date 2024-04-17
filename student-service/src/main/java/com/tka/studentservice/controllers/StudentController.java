package com.tka.studentservice.controllers;

import com.tka.studentservice.models.Student;
import com.tka.studentservice.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Create Student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    // Find Students By School
    @GetMapping("/school/{instituteId}")
    public ResponseEntity<List<Student>> findStudentsByInstitute(@PathVariable("instituteId") Integer instituteId) {
        return ResponseEntity.ok(studentService.findStudentsByInstitute(instituteId));
    }
}
