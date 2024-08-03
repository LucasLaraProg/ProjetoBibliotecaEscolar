package com.bibliotecaEscola.biblioteca.controllers;

import com.bibliotecaEscola.biblioteca.entities.StudentEntity;
import com.bibliotecaEscola.biblioteca.requests.StudentRequest;
import com.bibliotecaEscola.biblioteca.services.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/students")
@Tag(name = "Students", description = "Endpoint for Managing Students  ")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping
    public List<StudentEntity> showAllStudents() {
        return service.findAll();
    }

    @PostMapping("/{ra}")
    public Optional<StudentEntity>getStudentByRa(@PathVariable long ra) {
        return service.findByRa(ra);
    }

    @PostMapping
    public StudentEntity createStudent(@RequestBody StudentEntity student) {
        return service.createStudent(student);
    }

    @PutMapping("/{ra}")
    public StudentEntity updateStudent(@PathVariable long ra, @RequestBody StudentRequest payload) {
        return service.updateStudent(ra,payload);
    }

    @DeleteMapping("/{ra}")
    public void deleteStudent(@PathVariable long ra){
        service.deleteStudent(ra);
        }


}
