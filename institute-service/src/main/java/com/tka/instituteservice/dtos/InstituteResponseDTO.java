package com.tka.instituteservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InstituteResponseDTO {
    private String name;
    private String email;
    private List<InstituteDTO> students;
}
