package com.bibliotecaEscola.biblioteca.service;

import com.bibliotecaEscola.biblioteca.entity.AlunoEntity;
import com.bibliotecaEscola.biblioteca.entity.FuncionarioEntity;
import com.bibliotecaEscola.biblioteca.entity.LivroEntity;
import com.bibliotecaEscola.biblioteca.entity.RegistrosAluguelEntity;
import com.bibliotecaEscola.biblioteca.repository.AlunoRepository;
import com.bibliotecaEscola.biblioteca.repository.FuncionarioRepository;
import com.bibliotecaEscola.biblioteca.repository.LivroRepository;
import com.bibliotecaEscola.biblioteca.repository.RegistrosAluguelRepository;
import com.bibliotecaEscola.biblioteca.request.RegistrosAluguelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegistrosAluguelService {
    @Autowired
    private RegistrosAluguelRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    public List<RegistrosAluguelEntity> findAll(){
        return repository.findAll();
    }
    public Optional<RegistrosAluguelEntity> findById(UUID id){
        return repository.findById(id);
    }
    public RegistrosAluguelEntity createRegistroAluguel(RegistrosAluguelRequest payload,long ra,UUID idLivro,UUID idFuncionario){
        LocalDateTime dateNow = LocalDateTime.now();
        Optional<LivroEntity> livro= Optional.ofNullable(livroRepository.findById(idLivro).orElseThrow(() -> new RuntimeException("Book Not Found!!")));
        Optional<FuncionarioEntity> funcionario= Optional.ofNullable(funcionarioRepository.findById(idFuncionario).orElseThrow(() -> new RuntimeException("Employee Not Found!!")));
        Optional<AlunoEntity>  aluno= Optional.ofNullable(alunoRepository.findById(ra).orElseThrow(() -> new RuntimeException("Student Not Found!!")));
        if (livro.isPresent() && funcionario.isPresent() && aluno.isPresent()){
            LivroEntity rawLivro=livro.get();
            FuncionarioEntity rawFuncionario=funcionario.get();
            AlunoEntity rawAluno=aluno.get();
            RegistrosAluguelEntity newRegistroAluguel = new RegistrosAluguelEntity(dateNow,payload.dataParaEntrega(),rawAluno,rawLivro,rawFuncionario);
            return repository.save(newRegistroAluguel);
        }

        return null;
    }
    public RegistrosAluguelEntity updateRegistroAluguel(UUID id, RegistrosAluguelRequest payload) {
        RegistrosAluguelEntity registroToUpadte = repository.findById(id).orElseThrow(()-> new RuntimeException("Book rental records Not Found!!"));
        registroToUpadte.setDataParaEntrega(payload.dataParaEntrega());
        registroToUpadte.setDataDeEntrega(payload.dataDeEntrega());
        return repository.save(registroToUpadte);
    }
    public void deleteAluguel(UUID id) {
        RegistrosAluguelEntity registroToDelete = repository.findById(id).orElseThrow(()-> new RuntimeException("Book rental records Not Found!!"));
        repository.delete(registroToDelete);

    }

}
