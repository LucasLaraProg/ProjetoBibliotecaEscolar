package com.bibliotecaEscola.biblioteca.response;

import java.util.UUID;

public record LivroResponse(UUID id,String titulo,String autor,int ano) {
}
