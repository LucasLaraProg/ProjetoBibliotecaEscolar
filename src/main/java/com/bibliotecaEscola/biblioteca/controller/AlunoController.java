package com.bibliotecaEscola.biblioteca.controller;

import com.bibliotecaEscola.biblioteca.entity.AlunoEntity;
import com.bibliotecaEscola.biblioteca.request.AlunoRequest;
import com.bibliotecaEscola.biblioteca.service.AlunoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/alunos")
@Tag(name = "ALunos", description = "Endpoint para manipulação de alunos")
public class AlunoController {
    @Autowired
    private AlunoService service;

    @GetMapping
    public List<AlunoEntity> listarAlunos() {
        return service.findAll();
    }

    @PostMapping("/{ra}")
    public Optional<AlunoEntity>getAlunoByRa(@PathVariable long ra) {
        return service.findByRa(ra);
    }

    @PostMapping
    public AlunoEntity createAluno(@RequestBody AlunoEntity aluno) {
        return service.createAluno(aluno);
    }

    @PutMapping("/{ra}")
    public AlunoEntity updateAluno(@PathVariable long ra, @RequestBody AlunoRequest payload) {
        return service.updateAluno(ra,payload);
    }

    @DeleteMapping("/{ra}")
    public void deleteAluno(@PathVariable long ra){
        service.deleteAluno(ra);
        }


}
