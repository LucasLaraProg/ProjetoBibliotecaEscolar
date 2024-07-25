package com.bibliotecaEscola.biblioteca.service;

import com.bibliotecaEscola.biblioteca.entity.FuncionarioEntity;
import com.bibliotecaEscola.biblioteca.repository.FuncionarioRepository;
import com.bibliotecaEscola.biblioteca.request.FuncionarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;
    public List<FuncionarioEntity> findAll() {
        return repository.findAll();
    }

    public Optional<FuncionarioEntity> findById(UUID id) {
        return repository.findById(id);
    }

    public FuncionarioEntity createFuncionario(FuncionarioRequest payload) {
        FuncionarioEntity newFuncionario = new FuncionarioEntity(payload.nome(), payload.cargo());
        return repository.save(newFuncionario);
    }
    public FuncionarioEntity updateFuncionario(UUID id, FuncionarioRequest payload) {
        FuncionarioEntity funcionarioToUpdate = repository.findById(id).orElseThrow(()-> new RuntimeException("Employee Not Found!!"));
        funcionarioToUpdate.setNome(payload.nome());
        funcionarioToUpdate.setCargo(payload.cargo());
        return repository.save(funcionarioToUpdate);
    }
    public void deleteFuncionario(UUID id) {
        FuncionarioEntity funcionarioToDelete = repository.findById(id).orElseThrow(()-> new RuntimeException("Employee Not Found!!"));
        repository.delete(funcionarioToDelete);

    }

}
