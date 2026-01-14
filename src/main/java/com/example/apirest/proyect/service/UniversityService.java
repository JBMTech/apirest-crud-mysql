package com.example.apirest.proyect.service;

import com.example.apirest.proyect.dto.UniversityDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService implements UniversityServiceImp {
    @Override
    public List<UniversityDTO> listUniversity() {
        return null;
    }

    @Override
    public UniversityDTO createdUniversity(UniversityDTO universityDTO) {
        return null;
    }

    @Override
    public UniversityDTO updateUniversity(Long id, UniversityDTO universityDTO) {
        return null;
    }

    @Override
    public void deleteUniversity(Long id) {

    }
}
