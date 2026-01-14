package com.example.apirest.proyect.service;

import com.example.apirest.proyect.dto.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements CourseServiceImp {
    @Override
    public List<CourseDTO> listCourses() {
        return null;
    }

    @Override
    public CourseDTO createdCourse(CourseDTO courseDTO) {
        return null;
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {

    }
}
