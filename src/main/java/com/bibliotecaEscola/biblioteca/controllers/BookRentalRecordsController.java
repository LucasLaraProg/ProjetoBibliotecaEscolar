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
@RequestMapping("/bookrentalrecords")
@Tag(name = "Book Rental Records", description = "Endpoint for Managing Book rental records")
public class BookRentalRecordsController {
    @Autowired
    private BookRentalRecordsService service;

    @GetMapping
    public List<BookRentalRecordsEntity> showAllRecords() {
        return service.findAll();
    }

    @PostMapping("/{ra}/{idBook}/{idEmplyoee}")
    @Operation(description = "Save book rental records by Ra Student,Id book and Id Employee")

    public BookRentalRecordsEntity createRecord(@PathVariable long ra, UUID idBook, UUID idEmplyoee, @RequestBody BookRentalRecordsRequest payload) {
        return service.createRecord(payload, ra, idBook, idEmplyoee);
    }

    @PostMapping("/{id}")
    public Optional<BookRentalRecordsEntity> getRecordById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public BookRentalRecordsEntity updateRecord(@PathVariable UUID id, @RequestBody BookRentalRecordsRequest payload) {
        return service.updateRecord(id, payload);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable UUID id) {
        service.deleteRecord(id);
    }
}
