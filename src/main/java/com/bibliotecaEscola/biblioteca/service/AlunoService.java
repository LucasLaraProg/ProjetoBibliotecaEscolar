package com.bibliotecaEscola.biblioteca.service;

import com.bibliotecaEscola.biblioteca.entity.AlunoEntity;
import com.bibliotecaEscola.biblioteca.repository.AlunoRepository;
import com.bibliotecaEscola.biblioteca.request.AlunoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;

    public List<AlunoEntity> findAll() {
        return repository.findAll();
    }

    public Optional<AlunoEntity> findByRa(long ra) {
        return repository.findById(ra);
    }

    public AlunoEntity createAluno(AlunoEntity aluno) {
       return repository.save(aluno);
    }
    public AlunoEntity updateAluno(long ra, AlunoRequest aluno) {
        AlunoEntity alunoToUpdate = repository.findById(ra).orElseThrow(()-> new RuntimeException("Student Not Found!!"));
        alunoToUpdate.setNome(aluno.nome());
        alunoToUpdate.setSerie(aluno.serie());
        return repository.save(alunoToUpdate);
    }
    public void deleteAluno(long ra) {
        AlunoEntity alunoToDelete = repository.findById(ra).orElseThrow(()-> new RuntimeException("Student Not Found!!"));
        repository.delete(alunoToDelete);

    }
}
