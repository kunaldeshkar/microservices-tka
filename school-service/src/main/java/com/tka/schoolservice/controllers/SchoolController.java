package com.tka.schoolservice.controllers;

import com.tka.schoolservice.dtos.SchoolResponseDTO;
import com.tka.schoolservice.models.School;
import com.tka.schoolservice.services.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    private SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping()
    public ResponseEntity<School> createSchool(@RequestBody School school) {
        return ResponseEntity.ok(schoolService.createSchool(school));
    }

    @GetMapping()
    public ResponseEntity<List<School>> getAllSchools() {
        return ResponseEntity.ok(schoolService.getSchools());
    }

    @GetMapping("/students/{schoolId}")
    public ResponseEntity<SchoolResponseDTO> findAllStudentsBySchoolId(@PathVariable("schoolId") Integer schoolId) throws Exception {
         return ResponseEntity.ok(schoolService.findAllStudentsBySchoolId(schoolId));
    }

}
