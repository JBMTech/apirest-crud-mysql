package com.example.apirest.proyect.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO {
    //datos del curos
    private Long id;
    private String name;
    private Integer credits;
    //dato de universidad
    private Long idUniversity;
    //lista registros
    private List<RegistrationDTO> registrations;
}
