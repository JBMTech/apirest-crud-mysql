package com.example.apirest.proyect.repository;

import com.example.apirest.proyect.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Long> {
}
