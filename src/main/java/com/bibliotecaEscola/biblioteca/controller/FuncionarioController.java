package com.bibliotecaEscola.biblioteca.controller;

import com.bibliotecaEscola.biblioteca.entity.FuncionarioEntity;
import com.bibliotecaEscola.biblioteca.request.FuncionarioRequest;
import com.bibliotecaEscola.biblioteca.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/funcionarios")
@Tag(name="Funcionarios", description = "Endpoint para manipulação de funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<FuncionarioEntity> listarFuncionarios() {
        return service.findAll();
    }

    @PostMapping
    public FuncionarioEntity createFuncionario(@RequestBody FuncionarioRequest payload) {
        return service.createFuncionario(payload);
    }

    @PostMapping("/{id}")
    public Optional<FuncionarioEntity> getFuncionarioById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public FuncionarioEntity updateFuncionario(@PathVariable UUID id, @RequestBody FuncionarioRequest payload) {
        return service.updateFuncionario(id, payload);
    }
    @DeleteMapping("{id}")
    public void deleteFuncionario(@PathVariable UUID id) {
        service.deleteFuncionario(id);
    }
}
