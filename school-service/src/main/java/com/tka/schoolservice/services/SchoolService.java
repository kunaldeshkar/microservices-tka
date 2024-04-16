package com.tka.schoolservice.services;

import com.tka.schoolservice.dtos.SchoolResponseDTO;
import com.tka.schoolservice.models.School;

import java.util.List;

public interface SchoolService {
    School createSchool(School school);

    List<School> getSchools();

    SchoolResponseDTO findAllStudentsBySchoolId(Integer schoolId) throws Exception;
}
