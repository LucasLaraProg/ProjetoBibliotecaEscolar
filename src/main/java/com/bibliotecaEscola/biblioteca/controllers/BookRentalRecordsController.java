package com.bibliotecaEscola.biblioteca.controllers;

import com.bibliotecaEscola.biblioteca.entities.BookRentalRecordsEntity;
import com.bibliotecaEscola.biblioteca.requests.BookRentalRecordsRequest;
import com.bibliotecaEscola.biblioteca.services.BookRentalRecordsService;
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
public class BookRentalRecordsController {
    @Autowired
    private BookRentalRecordsService service;

    @GetMapping
    public List<BookRentalRecordsEntity> listarRegistros() {
        return service.findAll();
    }

    @PostMapping("/{ra}/{idLivro}/{idFuncionario}")
    @Operation(description = "Save book rental records by Ra Student,Id book and Id Employee")
    public BookRentalRecordsEntity createRegistro(@PathVariable long ra, UUID idLivro, UUID idFuncionario, @RequestBody BookRentalRecordsRequest payload) {
        return service.createRegistroAluguel(payload, ra, idLivro, idFuncionario);
    }

    @PostMapping("/{id}")
    public Optional<BookRentalRecordsEntity> getRegistroById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public BookRentalRecordsEntity updateRegistro(@PathVariable UUID id, @RequestBody BookRentalRecordsRequest payload) {
        return service.updateRegistroAluguel(id, payload);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistro(@PathVariable UUID id) {
        service.deleteAluguel(id);
    }
}
