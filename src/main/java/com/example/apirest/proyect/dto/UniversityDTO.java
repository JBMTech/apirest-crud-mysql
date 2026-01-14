package com.example.apirest.proyect.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UniversityDTO {
    private Long id;
    private String name;
    private String address;
}
