package com.example.apirest.proyect.service;

import com.example.apirest.proyect.dto.StudentDTO;
import com.example.apirest.proyect.mapper.Mapper;
import com.example.apirest.proyect.model.Student;
import com.example.apirest.proyect.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceImp {

    @Autowired
    private StudentRepository repo;

    @Override
    public List<StudentDTO> listStudents() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public StudentDTO createdStudent(StudentDTO studentDTO) {
        var stud = Student.builder()
                .name(studentDTO.getName())
                .email(studentDTO.getEmail())
                .build();
        return Mapper.toDTO(repo.save(stud));
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {

        Student stud = repo.findById(id)
                .orElseThrow() -> new Not
    }

    @Override
    public void deleteStudent(Long id) {

    }
}
