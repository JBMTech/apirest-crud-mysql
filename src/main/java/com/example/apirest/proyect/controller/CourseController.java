package com.example.apirest.proyect.controller;

import com.example.apirest.proyect.dto.CourseDTO;
import com.example.apirest.proyect.service.CourseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseServiceImp courseService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getCourse () {
        return ResponseEntity.ok(courseService.listCourses());
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO dto) {
        CourseDTO created = courseService.createdCourse(dto);
        return ResponseEntity.created(URI.create("/api/course/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public CourseDTO updateCourse(@PathVariable Long id, @RequestBody CourseDTO dto) {
        return courseService.updateCourse(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CourseDTO> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
