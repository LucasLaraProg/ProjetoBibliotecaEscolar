package com.bibliotecaEscola.biblioteca.service;

import com.bibliotecaEscola.biblioteca.entity.LivroEntity;
import com.bibliotecaEscola.biblioteca.repository.LivroRepository;
import com.bibliotecaEscola.biblioteca.request.LivroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;
    public List<LivroEntity> findAll() {
        return repository.findAll();
    }

    public Optional<LivroEntity> findById(UUID id) {
        return repository.findById(id);
    }

    public LivroEntity createLivro(LivroRequest payload) {
        LivroEntity newLivro = new LivroEntity(payload.titulo(), payload.autor(), payload.ano(),payload.quantidade());
        return repository.save(newLivro);
    }
    public LivroEntity updateLivro(UUID id, LivroRequest payload) {
        LivroEntity livroToUpdate = repository.findById(id).orElseThrow(()-> new RuntimeException("Book Not Found!!"));
        livroToUpdate.setTitulo(payload.titulo());
        livroToUpdate.setAutor(payload.autor());
        livroToUpdate.setAno(payload.ano());
        return repository.save(livroToUpdate);
    }
    public void deleteLivro(UUID id) {
        LivroEntity livroToDelete = repository.findById(id).orElseThrow(()->new RuntimeException("Book Not Found!!"));
        repository.delete(livroToDelete);

    }
}
