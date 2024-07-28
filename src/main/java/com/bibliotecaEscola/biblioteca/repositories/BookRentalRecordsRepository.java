package com.bibliotecaEscola.biblioteca.repositories;

import com.bibliotecaEscola.biblioteca.entities.BookRentalRecordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRentalRecordsRepository extends JpaRepository <BookRentalRecordsEntity, UUID>{
}
