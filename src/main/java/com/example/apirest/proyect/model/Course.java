package com.example.apirest.proyect.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer credits;
    @ManyToOne
    private University university;

    @OneToMany (mappedBy = "course")
    private List<Registration> registrations = new ArrayList<>();
}
