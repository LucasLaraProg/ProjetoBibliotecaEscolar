package com.bibliotecaEscola.biblioteca.services;

import com.bibliotecaEscola.biblioteca.entities.StudentEntity;
import com.bibliotecaEscola.biblioteca.entities.EmployeeEntity;
import com.bibliotecaEscola.biblioteca.entities.BookEntity;
import com.bibliotecaEscola.biblioteca.entities.BookRentalRecordsEntity;
import com.bibliotecaEscola.biblioteca.repositories.StudentRepository;
import com.bibliotecaEscola.biblioteca.repositories.EmployeeRepository;
import com.bibliotecaEscola.biblioteca.repositories.BookRepository;
import com.bibliotecaEscola.biblioteca.repositories.BookRentalRecordsRepository;
import com.bibliotecaEscola.biblioteca.requests.BookRentalRecordsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookRentalRecordsService {
    @Autowired
    private BookRentalRecordsRepository repository;

    @Autowired
    private StudentRepository alunoRepository;

    @Autowired
    private EmployeeRepository funcionarioRepository;

    @Autowired
    private BookRepository livroRepository;

    public List<BookRentalRecordsEntity> findAll(){
        return repository.findAll();
    }
    public Optional<BookRentalRecordsEntity> findById(UUID id){
        return repository.findById(id);
    }
    public BookRentalRecordsEntity createRegistroAluguel(BookRentalRecordsRequest payload, long ra, UUID idLivro, UUID idFuncionario){
        LocalDateTime dateNow = LocalDateTime.now();
        Optional<BookEntity> livro= Optional.ofNullable(livroRepository.findById(idLivro).orElseThrow(() -> new RuntimeException("Book Not Found!!")));
        Optional<EmployeeEntity> funcionario= Optional.ofNullable(funcionarioRepository.findById(idFuncionario).orElseThrow(() -> new RuntimeException("Employee Not Found!!")));
        Optional<StudentEntity>  aluno= Optional.ofNullable(alunoRepository.findById(ra).orElseThrow(() -> new RuntimeException("Student Not Found!!")));
        if (livro.isPresent() && funcionario.isPresent() && aluno.isPresent()){
            BookEntity rawLivro=livro.get();
            EmployeeEntity rawFuncionario=funcionario.get();
            StudentEntity rawAluno=aluno.get();
            BookRentalRecordsEntity newRegistroAluguel = new BookRentalRecordsEntity(dateNow,payload.dataParaEntrega(),rawAluno,rawLivro,rawFuncionario);
            return repository.save(newRegistroAluguel);
        }

        return null;
    }
    public BookRentalRecordsEntity updateRegistroAluguel(UUID id, BookRentalRecordsRequest payload) {
        BookRentalRecordsEntity registroToUpadte = repository.findById(id).orElseThrow(()-> new RuntimeException("Book rental records Not Found!!"));
        registroToUpadte.setDataParaEntrega(payload.dataParaEntrega());
        registroToUpadte.setDataDeEntrega(payload.dataDeEntrega());
        return repository.save(registroToUpadte);
    }
    public void deleteAluguel(UUID id) {
        BookRentalRecordsEntity registroToDelete = repository.findById(id).orElseThrow(()-> new RuntimeException("Book rental records Not Found!!"));
        repository.delete(registroToDelete);

    }

}
