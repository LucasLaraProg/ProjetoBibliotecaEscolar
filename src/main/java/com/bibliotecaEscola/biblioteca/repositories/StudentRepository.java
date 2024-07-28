package com.bibliotecaEscola.biblioteca.repositories;

import com.bibliotecaEscola.biblioteca.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
