package com.example.apirest.proyect.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationDTO {
    private Long id;

    //Student
    private Long studentId;
    //Course
    private Long courseId;

    private LocalDate registrationDate;
    private Integer finalGrade;
}
