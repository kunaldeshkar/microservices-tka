package com.tka.schoolservice.services.impl;

import com.tka.schoolservice.dtos.SchoolResponseDTO;
import com.tka.schoolservice.dtos.StudentDTO;
import com.tka.schoolservice.models.School;
import com.tka.schoolservice.models.Student;
import com.tka.schoolservice.repositories.SchoolRepository;
import com.tka.schoolservice.services.SchoolService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {
    private SchoolRepository schoolRepository;
    private RestTemplate restTemplate;

    public SchoolServiceImpl(SchoolRepository schoolRepository, RestTemplate restTemplate) {
        this.schoolRepository = schoolRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    public SchoolResponseDTO findAllStudentsBySchoolId(Integer schoolId) throws Exception {
        Optional<School> optional = schoolRepository.findById(schoolId);
        if (optional.isEmpty()){
            throw new Exception("School not found");
        }
        Student[] students = restTemplate.getForObject("http://localhost:8080/api/students/school/" + schoolId, Student[].class);

        List<Student> studentList = List.of(students);

        School school = optional.get();
        SchoolResponseDTO schoolResponseDTO = new SchoolResponseDTO();
        schoolResponseDTO.setName(school.getName());
        schoolResponseDTO.setEmail(school.getEmail());
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student student:studentList){
            studentDTOList.add(convertToStudentDTO(student));
        }
        schoolResponseDTO.setStudents(studentDTOList);
        return schoolResponseDTO;
    }

    private StudentDTO convertToStudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFirstname(student.getFirstname());
        studentDTO.setLastname(student.getLastname());
        studentDTO.setEmail(student.getEmail());
        return studentDTO;
    }
}
