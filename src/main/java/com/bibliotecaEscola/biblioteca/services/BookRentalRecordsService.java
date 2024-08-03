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
    private StudentRepository studentRepository;

    @Autowired
    private EmployeeRepository emplyoeeRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<BookRentalRecordsEntity> findAll(){
        return repository.findAll();
    }

    public Optional<BookRentalRecordsEntity> findById(UUID id){
        return repository.findById(id);
    }

    public BookRentalRecordsEntity createRecord(BookRentalRecordsRequest payload, long ra, UUID idBook, UUID idEmplyoee){
        LocalDateTime dateNow = LocalDateTime.now();
        Optional<BookEntity> book= Optional.ofNullable(bookRepository.findById(idBook).orElseThrow(() -> new RuntimeException("Book Not Found!!")));
        Optional<EmployeeEntity> emplyoee= Optional.ofNullable(emplyoeeRepository.findById(idEmplyoee).orElseThrow(() -> new RuntimeException("Employee Not Found!!")));
        Optional<StudentEntity>  student= Optional.ofNullable(studentRepository.findById(ra).orElseThrow(() -> new RuntimeException("Student Not Found!!")));
        if (book.isPresent() && emplyoee.isPresent() && student.isPresent()){
            BookEntity rawBook=book.get();
            EmployeeEntity rawEmplyoee=emplyoee.get();
            StudentEntity rawStudent=student.get();
            BookRentalRecordsEntity newRecord = new BookRentalRecordsEntity(dateNow,payload.dataParaEntrega(),rawStudent,rawBook,rawEmplyoee);
            return repository.save(newRecord);
        }

        return null;
    }

    public BookRentalRecordsEntity updateRecord(UUID id, BookRentalRecordsRequest payload) {
        BookRentalRecordsEntity recordToUpadte = repository.findById(id).orElseThrow(()-> new RuntimeException("Book rental records Not Found!!"));
        recordToUpadte.setRecordDate(payload.dataParaEntrega());
        recordToUpadte.setDataDeEntrega(payload.dataDeEntrega());
        return repository.save(recordToUpadte);
    }

    public void deleteRecord(UUID id) {
        BookRentalRecordsEntity recordToDelete = repository.findById(id).orElseThrow(()-> new RuntimeException("Book rental records Not Found!!"));
        repository.delete(recordToDelete);

    }

}
