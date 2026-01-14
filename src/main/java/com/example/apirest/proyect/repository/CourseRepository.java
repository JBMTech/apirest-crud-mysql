package com.example.apirest.proyect.repository;

import com.example.apirest.proyect.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository <Course, Long> {
}
