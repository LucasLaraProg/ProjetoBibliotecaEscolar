package com.bibliotecaEscola.biblioteca.repository;

import com.bibliotecaEscola.biblioteca.entity.RegistrosAluguelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RegistrosAluguelRepository extends JpaRepository <RegistrosAluguelEntity, UUID>{
}
