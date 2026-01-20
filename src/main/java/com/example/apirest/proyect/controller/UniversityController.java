package com.example.apirest.proyect.controller;

import com.example.apirest.proyect.dto.UniversityDTO;
import com.example.apirest.proyect.service.UniversityServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/university")
public class UniversityController {

    @Autowired
    private UniversityServiceImp universityService;

    @GetMapping
    public ResponseEntity<List<UniversityDTO>> getUniversity() {
        return ResponseEntity.ok(universityService.listUniversity());
    }

    @PostMapping
    public ResponseEntity<UniversityDTO> createUni(@RequestBody UniversityDTO dto) {
        UniversityDTO created = universityService.createdUniversity(dto);
        return ResponseEntity.created(URI.create("/api/university/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UniversityDTO> updateUni(@PathVariable Long id, @RequestBody UniversityDTO dto) {
        return ResponseEntity.ok(universityService.updateUniversity(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUni(@PathVariable Long id) {
        universityService.deleteUniversity(id);
        return ResponseEntity.noContent().build();
    }
}
