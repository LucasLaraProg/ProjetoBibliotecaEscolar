package com.bibliotecaEscola.biblioteca.responses;

import java.util.UUID;

public record BookResponse(UUID id, String titulo, String autor, int ano) {
}
