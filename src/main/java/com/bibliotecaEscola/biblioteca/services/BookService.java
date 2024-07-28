package com.bibliotecaEscola.biblioteca.services;

import com.bibliotecaEscola.biblioteca.entities.BookEntity;
import com.bibliotecaEscola.biblioteca.repositories.BookRepository;
import com.bibliotecaEscola.biblioteca.requests.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;
    public List<BookEntity> findAll() {
        return repository.findAll();
    }

    public Optional<BookEntity> findById(UUID id) {
        return repository.findById(id);
    }

    public BookEntity createBook(BookRequest payload) {
        BookEntity newBook = new BookEntity(payload.title(), payload.author(), payload.year(),payload.amount());
        return repository.save(newBook);
    }
    public BookEntity updateBook(UUID id, BookRequest payload) {
        BookEntity bookToUpdate = repository.findById(id).orElseThrow(()-> new RuntimeException("Book Not Found!!"));
        bookToUpdate.setTitle(payload.title());
        bookToUpdate.setAuthor(payload.author());
        bookToUpdate.setYear(payload.year());
        bookToUpdate.setAmount(payload.amount());
        return repository.save(bookToUpdate);
    }
    public void deleteLivro(UUID id) {
        BookEntity bookToDelete = repository.findById(id).orElseThrow(()->new RuntimeException("Book Not Found!!"));
        repository.delete(bookToDelete);

    }
}
