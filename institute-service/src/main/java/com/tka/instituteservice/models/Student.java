package com.tka.instituteservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private Integer schoolId;
}
