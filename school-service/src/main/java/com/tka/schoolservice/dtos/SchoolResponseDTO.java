package com.tka.schoolservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SchoolResponseDTO {
    private String name;
    private String email;
    private List<StudentDTO> students;
}
