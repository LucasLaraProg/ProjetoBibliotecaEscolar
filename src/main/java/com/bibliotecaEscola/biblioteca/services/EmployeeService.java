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

    public EmployeeEntity createEmplyoee(EmployeeRequest payload) {
        EmployeeEntity newEmplyoee = new EmployeeEntity(payload.name(), payload.office());
        return repository.save(newEmplyoee);
    }

    public EmployeeEntity updateEmplyoee(UUID id, EmployeeRequest payload) {
        EmployeeEntity emplyoeeToUpdate = repository.findById(id).orElseThrow(()-> new RuntimeException("Employee Not Found!!"));
        emplyoeeToUpdate.setNome(payload.name());
        emplyoeeToUpdate.setCargo(payload.office());
        return repository.save(emplyoeeToUpdate);
    }
    public void deleteEmplyoee(UUID id) {
        EmployeeEntity emplyoeeToDelete = repository.findById(id).orElseThrow(()-> new RuntimeException("Employee Not Found!!"));
        repository.delete(emplyoeeToDelete);

    }

}
