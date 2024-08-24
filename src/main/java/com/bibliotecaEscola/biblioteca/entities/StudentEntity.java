package com.bibliotecaEscola.biblioteca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentEntity {

    @Column(nullable = false)
    @Id
    private long ra;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String schoolGrade;

}
