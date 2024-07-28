package com.bibliotecaEscola.biblioteca.controllers;

import com.bibliotecaEscola.biblioteca.entities.BookEntity;
import com.bibliotecaEscola.biblioteca.requests.BookRequest;
import com.bibliotecaEscola.biblioteca.services.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
@Tag(name = "Books", description = "Endpoint for Managing Books")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping
    public List<BookEntity> showAllBooks() {
        return service.findAll();
    }

    @PostMapping("/{id}")
    public Optional<BookEntity>getBookById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public BookEntity createBook(@RequestBody BookRequest book) {
        return service.createBook(book);
    }

    @PutMapping("/{id}")
    public BookEntity updateBook(@PathVariable UUID id, @RequestBody BookRequest payload) {
        return service.updateBook(id,payload);

    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable UUID id) {
    service.deleteLivro(id);
    }
}
