package com.bibliotecaEscola.biblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AlunoEntity {

    @Column(nullable = false)
    @Id
    private long ra;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String serie;

}
