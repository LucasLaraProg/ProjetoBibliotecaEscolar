package com.bibliotecaEscola.biblioteca.controller;

import com.bibliotecaEscola.biblioteca.entity.LivroEntity;
import com.bibliotecaEscola.biblioteca.request.LivroRequest;
import com.bibliotecaEscola.biblioteca.service.LivroService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/livros")
@Tag(name = "Livros", description = "Endpoint para manipulação de livros")
public class LivroController {
    @Autowired
    private LivroService service;

    @GetMapping
    public List<LivroEntity> listarLivros() {
        return service.findAll();
    }

    @PostMapping("/{id}")
    public Optional<LivroEntity>getLivroById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public LivroEntity createLivro(@RequestBody LivroRequest livro) {
        return service.createLivro(livro);
    }

    @PutMapping("/{id}")
    public LivroEntity updateLivro(@PathVariable UUID id, @RequestBody LivroRequest payload) {
        return service.updateLivro(id,payload);

    }
    @DeleteMapping("/{id}")
    public void deleteLivro(@PathVariable UUID id) {
    service.deleteLivro(id);
    }
}
