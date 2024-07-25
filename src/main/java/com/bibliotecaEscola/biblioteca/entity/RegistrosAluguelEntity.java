package com.bibliotecaEscola.biblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrosAluguelEntity {
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
    private AlunoEntity raAluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livro", referencedColumnName ="id", nullable = false)
    private LivroEntity idlivro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcionario", referencedColumnName ="id", nullable = false)
    private FuncionarioEntity idFuncionario;

   public RegistrosAluguelEntity(LocalDateTime dataAluguel,LocalDateTime dataParaEntrega,AlunoEntity ra,LivroEntity idLivro,FuncionarioEntity idFuncionario){
       this.dataAluguel = dataAluguel;
       this.dataParaEntrega = dataParaEntrega;
       this.raAluno = ra;
       this.idlivro=idLivro;
       this.idFuncionario=idFuncionario;

    }


}
