package com.example.apirest.proyect.service;

import com.example.apirest.proyect.dto.StudentDTO;

import java.util.List;

public interface StudentServiceImp {

    List<StudentDTO> listStudents();
    StudentDTO createdStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(Long id, StudentDTO studentDTO);
    void deleteStudent(Long id);
}
