package com.example.apirest.proyect.service;

import com.example.apirest.proyect.dto.CourseDTO;
import com.example.apirest.proyect.dto.RegistrationDTO;
import com.example.apirest.proyect.exception.NotFoundException;
import com.example.apirest.proyect.mapper.Mapper;
import com.example.apirest.proyect.model.Course;
import com.example.apirest.proyect.model.Registration;
import com.example.apirest.proyect.model.Student;
import com.example.apirest.proyect.model.University;
import com.example.apirest.proyect.repository.CourseRepository;
import com.example.apirest.proyect.repository.StudentRepository;
import com.example.apirest.proyect.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements CourseServiceImp {

    @Autowired
    public CourseRepository repoCourse;

    @Autowired
    public UniversityRepository repoUni;

    @Autowired
    public StudentRepository repoStud;

    @Override
    public List<CourseDTO> listCourses() {

        List<Course> course = repoCourse.findAll();
        List<CourseDTO> courseDTOS = new ArrayList<>();
        CourseDTO dto;

        for (Course c : course) {
            dto = Mapper.toDTO(c);
            courseDTOS.add (dto);
        }

        return courseDTOS;
    }

    @Override
    public CourseDTO createdCourse(CourseDTO courseDTO) {

        if (courseDTO == null) throw new RuntimeException("courseDTO is null");
        if (courseDTO.getIdUniversity() == null) throw new RuntimeException("must indicate the university");
        if (courseDTO.getRegistrations() == null || courseDTO.getRegistrations().isEmpty())
            throw new RuntimeException("you must indicate at least one course");

        //Buscar la universidad
        University uni = repoUni.findById(courseDTO.getIdUniversity()).orElse(null);
        if (uni == null)
            throw new NotFoundException("University not found");

        // Crear el curso
        Course cou = new Course();
        cou.setName(courseDTO.getName());
        cou.setCredits(courseDTO.getCredits());
        cou.setUniversity(uni);

        //Lista de registros
        //-> los estudiantes
        List<Registration> registrations = new ArrayList<>();

        for (RegistrationDTO regDTO : courseDTO.getRegistrations()) {
            //Busca curso por id (tu regDTO usa id como id de estudiante)
            Student s = repoStud.findById(regDTO.getStudentId()).orElse(null);
            if (s == null)
                throw new RuntimeException("Student not found: " + regDTO.getStudentId());

            //Crear registro
            Registration registration = new Registration();
            registration.setStudent(s);
            registration.setRegistrationDate(regDTO.getRegistrationDate());
            registration.setFinalGrade(regDTO.getFinalGrade());
            registration.setCourse(cou);

            registrations.add(registration);
        }

        //seteamos la lista de registro curso
        cou.setRegistrations(registrations);

        //guardamos en la BD
        repoCourse.save(cou);

        //Mapeo de salida
        CourseDTO exitCourse = Mapper.toDTO(cou);

        return exitCourse;
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        //buscar si el curso existe para actualizar
        Course c = repoCourse.findById(id).orElse(null);
        if (c == null) throw new RuntimeException("Course not found");

        if (courseDTO.getName() != null) {
            c.setName(courseDTO.getName());
        }

        if (courseDTO.getCredits() != null) {
            c.setCredits(courseDTO.getCredits());
        }

        if (courseDTO.getIdUniversity() != null) {
            University u = repoUni.findById(courseDTO.getIdUniversity()).orElse(null);
            if (u == null) throw new NotFoundException("University not found");
            c.setUniversity(u);
        }

        CourseDTO exitCourse = Mapper.toDTO(c);

        return exitCourse;
    }

    @Override
    public void deleteCourse(Long id) {

        Course cou = repoCourse.findById(id).orElse(null);
        if (cou == null) throw new RuntimeException("Course not found");
        repoCourse.delete(cou);
    }
}
