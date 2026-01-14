package com.example.apirest.proyect.service;

import com.example.apirest.proyect.dto.CourseDTO;

import java.util.List;

public interface CourseServiceImp {

    List<CourseDTO> listCourses();
    CourseDTO createdCourse(CourseDTO courseDTO);
    CourseDTO updateCourse(Long id, CourseDTO courseDTO);
    void deleteCourse(Long id);
}
