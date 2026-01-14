package com.example.apirest.proyect.service;

import com.example.apirest.proyect.dto.UniversityDTO;

import java.util.List;

public interface UniversityServiceImp {

    List<UniversityDTO> listUniversity();

    UniversityDTO createdUniversity(UniversityDTO universityDTO);
    UniversityDTO updateUniversity(Long id, UniversityDTO universityDTO);
    void deleteUniversity(Long id);

}
