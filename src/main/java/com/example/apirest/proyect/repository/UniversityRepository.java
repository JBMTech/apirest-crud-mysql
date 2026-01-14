package com.example.apirest.proyect.repository;

import com.example.apirest.proyect.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository <University, Long> {
}
