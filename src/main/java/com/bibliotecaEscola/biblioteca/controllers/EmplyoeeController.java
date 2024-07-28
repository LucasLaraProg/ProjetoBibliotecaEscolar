package com.bibliotecaEscola.biblioteca.controllers;

import com.bibliotecaEscola.biblioteca.entities.EmployeeEntity;
import com.bibliotecaEscola.biblioteca.requests.EmployeeRequest;
import com.bibliotecaEscola.biblioteca.services.EmployeeService;
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
public class EmplyoeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<EmployeeEntity> listarFuncionarios() {
        return service.findAll();
    }

    @PostMapping
    public EmployeeEntity createFuncionario(@RequestBody EmployeeRequest payload) {
        return service.createFuncionario(payload);
    }

    @PostMapping("/{id}")
    public Optional<EmployeeEntity> getFuncionarioById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public EmployeeEntity updateFuncionario(@PathVariable UUID id, @RequestBody EmployeeRequest payload) {
        return service.updateFuncionario(id, payload);
    }
    @DeleteMapping("{id}")
    public void deleteFuncionario(@PathVariable UUID id) {
        service.deleteFuncionario(id);
    }
}
