package com.tka.instituteservice.services;

import com.tka.instituteservice.dtos.InstituteResponseDTO;
import com.tka.instituteservice.models.Institute;

import java.util.List;

public interface InstituteService {
    Institute createInstitute(Institute school);

    List<Institute> getInstitutes();

    InstituteResponseDTO findAllStudentsByInstituteId(Integer schoolId) throws Exception;
}
