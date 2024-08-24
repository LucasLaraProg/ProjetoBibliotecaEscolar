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

    public StudentEntity createStudent(StudentEntity student) {
        try {
            if (repository.findById(student.getRa()).isPresent()) {
                throw new RuntimeException("Student already exists");
            } else {
                return repository.save(student);
            }
        } finally {

        }
    }

    public StudentEntity updateStudent(long ra, StudentRequest student) {
        StudentEntity studentToUpdate = repository.findById(ra).orElseThrow(()-> new RuntimeException("Student Not Found!!"));
        studentToUpdate.setName(student.name());
        studentToUpdate.setSchoolGrade(student.schoolGrade());
        return repository.save(studentToUpdate);
    }

    public void deleteStudent(long ra) {
        StudentEntity studentToDelete = repository.findById(ra).orElseThrow(()-> new RuntimeException("Student Not Found!!"));
        repository.delete(studentToDelete);

    }
}
