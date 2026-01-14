package com.example.apirest.proyect.mapper;

import com.example.apirest.proyect.dto.CourseDTO;
import com.example.apirest.proyect.dto.RegistrationDTO;
import com.example.apirest.proyect.dto.StudentDTO;
import com.example.apirest.proyect.dto.UniversityDTO;
import com.example.apirest.proyect.model.Course;
import com.example.apirest.proyect.model.Student;
import com.example.apirest.proyect.model.University;

import java.util.stream.Collectors;

public class Mapper {

    //Mapeo de Student a StudentDTO;
    public static StudentDTO toDTO(Student s) {
        if (s == null) return null;

        return StudentDTO.builder()
                .id(s.getId())
                .name(s.getName())
                .email(s.getEmail())
                .build();
    }
    //Mappeo de University a UniversityDTO;
    public static UniversityDTO toDTO(University u) {
        if (u == null) return null;

        return UniversityDTO.builder()
                .id(u.getId())
                .name(u.getName())
                .address(u.getAddress())
                .build();
    }
    // Mapeo de Course a CourseDTO;
    public static CourseDTO toDTO(Course c) {
        if (c == null) return null;

        var registrations = c.getRegistrations().stream().map(reg ->
                RegistrationDTO.builder()
                        .id(reg.getId())
                        .studentId(reg.getStudent().getId())
                        .courseId(reg.getCourse().getId())
                        .registrationDate(reg.getRegistrationDate())
                        .finalGrade(reg.getFinalGrade())
                        .build()
        ).toList();

        return CourseDTO.builder()
                .id(c.getId())
                .name(c.getName())
                .credits(c.getCredits())
                .idUniversity(c.getUniversity().getId())
                .registrations(registrations)
                .build();
    }
}
