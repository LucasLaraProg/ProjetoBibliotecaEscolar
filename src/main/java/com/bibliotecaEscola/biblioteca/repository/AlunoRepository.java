package com.bibliotecaEscola.biblioteca.repository;

import com.bibliotecaEscola.biblioteca.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity,Long> {
}
