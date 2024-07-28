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
@RequestMapping("/alunos")
@Tag(name = "ALunos", description = "Endpoint para manipulação de alunos")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping
    public List<StudentEntity> listarAlunos() {
        return service.findAll();
    }

    @PostMapping("/{ra}")
    public Optional<StudentEntity>getAlunoByRa(@PathVariable long ra) {
        return service.findByRa(ra);
    }

    @PostMapping
    public StudentEntity createAluno(@RequestBody StudentEntity aluno) {
        return service.createAluno(aluno);
    }

    @PutMapping("/{ra}")
    public StudentEntity updateAluno(@PathVariable long ra, @RequestBody StudentRequest payload) {
        return service.updateAluno(ra,payload);
    }

    @DeleteMapping("/{ra}")
    public void deleteAluno(@PathVariable long ra){
        service.deleteAluno(ra);
        }


}
