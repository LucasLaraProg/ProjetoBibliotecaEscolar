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
    private LocalDateTime dataAluguel;

    @Column(nullable = false)
    private LocalDateTime dataParaEntrega;


    private LocalDateTime dataDeEntrega;

    private boolean devolvido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ra_aluno", referencedColumnName ="ra", nullable = false)
    private StudentEntity raAluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livro", referencedColumnName ="id", nullable = false)
    private BookEntity idlivro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcionario", referencedColumnName ="id", nullable = false)
    private EmployeeEntity idFuncionario;

   public BookRentalRecordsEntity(LocalDateTime dataAluguel, LocalDateTime dataParaEntrega, StudentEntity ra, BookEntity idLivro, EmployeeEntity idFuncionario){
       this.dataAluguel = dataAluguel;
       this.dataParaEntrega = dataParaEntrega;
       this.raAluno = ra;
       this.idlivro=idLivro;
       this.idFuncionario=idFuncionario;

    }


}
