package com.bibliotecaEscola.biblioteca.controller;

import com.bibliotecaEscola.biblioteca.entity.RegistrosAluguelEntity;
import com.bibliotecaEscola.biblioteca.request.RegistrosAluguelRequest;
import com.bibliotecaEscola.biblioteca.service.RegistrosAluguelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/registrosAluguel")
@Tag(name = "Registros De Aluguel", description = "Endpoint para manipulação de registros de aluguéis de livros")
public class RegistrosAluguelController {
    @Autowired
    private RegistrosAluguelService service;

    @GetMapping
    public List<RegistrosAluguelEntity> listarRegistros() {
        return service.findAll();
    }

    @PostMapping("/{ra}/{idLivro}/{idFuncionario}")
    @Operation(description = "Save book rental records by Ra Student,Id book and Id Employee")
    public RegistrosAluguelEntity createRegistro(@PathVariable long ra, UUID idLivro, UUID idFuncionario, @RequestBody RegistrosAluguelRequest payload) {
        return service.createRegistroAluguel(payload, ra, idLivro, idFuncionario);
    }

    @PostMapping("/{id}")
    public Optional<RegistrosAluguelEntity> getRegistroById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public RegistrosAluguelEntity updateRegistro(@PathVariable UUID id, @RequestBody RegistrosAluguelRequest payload) {
        return service.updateRegistroAluguel(id, payload);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistro(@PathVariable UUID id) {
        service.deleteAluguel(id);
    }
}
