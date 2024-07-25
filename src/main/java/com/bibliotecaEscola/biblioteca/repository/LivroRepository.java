package com.bibliotecaEscola.biblioteca.repository;

import com.bibliotecaEscola.biblioteca.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, UUID> {
}
