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
@RequestMapping("/emplyoees")
@Tag(name="Employees", description = "Endpoint for Managing Emplyoees")
public class EmplyoeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<EmployeeEntity> showAllEmployees() {
        return service.findAll();
    }

    @PostMapping
    public EmployeeEntity createEmplyoee(@RequestBody EmployeeRequest payload) {
        return service.createEmplyoee(payload);
    }

    @PostMapping("/{id}")
    public Optional<EmployeeEntity> getEmplyoeeById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public EmployeeEntity updateEmplyoee(@PathVariable UUID id, @RequestBody EmployeeRequest payload) {
        return service.updateEmplyoee(id, payload);
    }
    @DeleteMapping("{id}")
    public void deleteEmplyoee(@PathVariable UUID id) {
        service.deleteEmplyoee(id);
    }
}
