package com.tka.instituteservice.controllers;

import com.tka.instituteservice.dtos.InstituteResponseDTO;
import com.tka.instituteservice.models.Institute;
import com.tka.instituteservice.services.InstituteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institutes")
public class InstituteController {
    private InstituteService instituteService;

    public InstituteController(InstituteService instituteService) {
        this.instituteService = instituteService;
    }

    @PostMapping()
    public ResponseEntity<Institute> createInstitute(@RequestBody Institute school) {
        return ResponseEntity.ok(instituteService.createInstitute(school));
    }

    @GetMapping()
    public ResponseEntity<List<Institute>> getAllInstitutes() {
        return ResponseEntity.ok(instituteService.getInstitutes());
    }

    @GetMapping("/students/{schoolId}")
    public ResponseEntity<InstituteResponseDTO> findAllStudentsByInstituteId(@PathVariable("schoolId") Integer instituteId) throws Exception {
         return ResponseEntity.ok(instituteService.findAllStudentsByInstituteId(instituteId));
    }

}
