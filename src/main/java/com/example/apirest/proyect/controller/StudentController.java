package com.example.apirest.proyect.controller;

import com.example.apirest.proyect.dto.StudentDTO;
import com.example.apirest.proyect.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentServiceImp studentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getStudents () {
        return ResponseEntity.ok(studentService.listStudents());
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createdStudent(@RequestBody StudentDTO dto) {
        StudentDTO created = studentService.createdStudent(dto);
        return ResponseEntity.created(URI.create("/api/student/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent (@PathVariable Long id, @RequestBody StudentDTO dto) {
        return ResponseEntity.ok(studentService.updateStudent(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDTO> deleteStudent (@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
