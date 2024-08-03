package com.bibliotecaEscola.biblioteca.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookRentalRecordsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime recordDate;

    @Column(nullable = false)
    private LocalDateTime deliveryDate;


    private LocalDateTime dataDeEntrega;

    private boolean devolvido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ra_student", referencedColumnName = "ra", nullable = false)
    private StudentEntity raStudent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_book", referencedColumnName = "id", nullable = false)
    private BookEntity idBook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_emplyoee", referencedColumnName = "id", nullable = false)
    private EmployeeEntity idEmplyoee;

    public BookRentalRecordsEntity(LocalDateTime recordDate, LocalDateTime deliveryDate, StudentEntity ra, BookEntity idBook, EmployeeEntity idEmplyooe) {
        this.recordDate = recordDate;
        this.deliveryDate = deliveryDate;
        this.raStudent = ra;
        this.idBook = idBook;
        this.idEmplyoee = idEmplyooe;

    }


}
