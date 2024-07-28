package com.bibliotecaEscola.biblioteca.services;

import com.bibliotecaEscola.biblioteca.entities.EmployeeEntity;
import com.bibliotecaEscola.biblioteca.repositories.EmployeeRepository;
import com.bibliotecaEscola.biblioteca.requests.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    public List<EmployeeEntity> findAll() {
        return repository.findAll();
    }

    public Optional<EmployeeEntity> findById(UUID id) {
        return repository.findById(id);
    }

    public EmployeeEntity createFuncionario(EmployeeRequest payload) {
        EmployeeEntity newFuncionario = new EmployeeEntity(payload.nome(), payload.cargo());
        return repository.save(newFuncionario);
    }
    public EmployeeEntity updateFuncionario(UUID id, EmployeeRequest payload) {
        EmployeeEntity funcionarioToUpdate = repository.findById(id).orElseThrow(()-> new RuntimeException("Employee Not Found!!"));
        funcionarioToUpdate.setNome(payload.nome());
        funcionarioToUpdate.setCargo(payload.cargo());
        return repository.save(funcionarioToUpdate);
    }
    public void deleteFuncionario(UUID id) {
        EmployeeEntity funcionarioToDelete = repository.findById(id).orElseThrow(()-> new RuntimeException("Employee Not Found!!"));
        repository.delete(funcionarioToDelete);

    }

}
