package com.tka.instituteservice.services.impl;

import com.tka.instituteservice.dtos.InstituteResponseDTO;
import com.tka.instituteservice.dtos.InstituteDTO;
import com.tka.instituteservice.models.Institute;
import com.tka.instituteservice.models.Student;
import com.tka.instituteservice.repositories.InstituteRepository;
import com.tka.instituteservice.services.InstituteService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstituteServiceImpl implements InstituteService {
    private InstituteRepository instituteRepository;
    private RestTemplate restTemplate;

    public InstituteServiceImpl(InstituteRepository schoolRepository, RestTemplate restTemplate) {
        this.instituteRepository = schoolRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Institute createInstitute(Institute institute) {
        return instituteRepository.save(institute);
    }

    @Override
    public List<Institute> getInstitutes() {
        return instituteRepository.findAll();
    }

    public InstituteResponseDTO findAllStudentsByInstituteId(Integer instituteId) throws Exception {
        Optional<Institute> optional = instituteRepository.findById(instituteId);
        if (optional.isEmpty()){
            throw new Exception("School not found");
        }
        Student[] students = restTemplate.getForObject("http://localhost:8080/api/students/institute/" + instituteId, Student[].class);

        List<Student> studentList = List.of(students);

        Institute institute = optional.get();
        InstituteResponseDTO schoolResponseDTO = new InstituteResponseDTO();
        schoolResponseDTO.setName(institute.getName());
        schoolResponseDTO.setEmail(institute.getEmail());
        List<InstituteDTO> studentDTOList = new ArrayList<>();
        for (Student student:studentList){
            studentDTOList.add(convertToStudentDTO(student));
        }
        schoolResponseDTO.setStudents(studentDTOList);
        return schoolResponseDTO;
    }

    private InstituteDTO convertToStudentDTO(Student student) {
        InstituteDTO studentDTO = new InstituteDTO();
        studentDTO.setFirstname(student.getFirstname());
        studentDTO.setLastname(student.getLastname());
        studentDTO.setEmail(student.getEmail());
        return studentDTO;
    }
}
