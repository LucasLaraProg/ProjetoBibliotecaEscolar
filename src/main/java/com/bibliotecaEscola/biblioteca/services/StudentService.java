package com.bibliotecaEscola.biblioteca.services;

import com.bibliotecaEscola.biblioteca.entities.StudentEntity;
import com.bibliotecaEscola.biblioteca.requests.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    @Autowired
    private com.bibliotecaEscola.biblioteca.repositories.StudentRepository repository;

    public List<StudentEntity> findAll() {
        return repository.findAll();
    }

    public Optional<StudentEntity> findByRa(long ra) {
        return repository.findById(ra);
    }

    public StudentEntity createAluno(StudentEntity aluno) {
       return repository.save(aluno);
    }
    public StudentEntity updateAluno(long ra, StudentRequest aluno) {
        StudentEntity alunoToUpdate = repository.findById(ra).orElseThrow(()-> new RuntimeException("Student Not Found!!"));
        alunoToUpdate.setNome(aluno.nome());
        alunoToUpdate.setSerie(aluno.serie());
        return repository.save(alunoToUpdate);
    }
    public void deleteAluno(long ra) {
        StudentEntity alunoToDelete = repository.findById(ra).orElseThrow(()-> new RuntimeException("Student Not Found!!"));
        repository.delete(alunoToDelete);

    }
}
