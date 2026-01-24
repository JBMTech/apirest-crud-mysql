package com.example.apirest.proyect.service;

import com.example.apirest.proyect.dto.UniversityDTO;
import com.example.apirest.proyect.exception.NotFoundException;
import com.example.apirest.proyect.mapper.Mapper;
import com.example.apirest.proyect.model.University;
import com.example.apirest.proyect.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService implements UniversityServiceImp {

    @Autowired
    private UniversityRepository repo;

    @Override
    public List<UniversityDTO> listUniversity() {

        return repo.findAll()
                .stream()
                .map(Mapper::toDTO)
                .toList();
    }

    @Override
    public UniversityDTO createdUniversity(UniversityDTO universityDTO) {

        University uni = University.builder()
                .name(universityDTO.getName())
                .address(universityDTO.getAddress())
                .build();

        return (Mapper.toDTO(repo.save(uni)));
    }

    @Override
    public UniversityDTO updateUniversity(Long id, UniversityDTO universityDTO) {

        University uni = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("University not found"));

        uni.setName(universityDTO.getName());
        uni.setAddress(universityDTO.getAddress());

        return Mapper.toDTO(repo.save(uni));
    }

    @Override
    public void deleteUniversity(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("University not found");
        }

        repo.deleteById(id);
    }
}
