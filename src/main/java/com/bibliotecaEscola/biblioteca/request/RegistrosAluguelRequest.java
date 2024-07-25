package com.bibliotecaEscola.biblioteca.request;

import java.time.LocalDateTime;

public record RegistrosAluguelRequest(LocalDateTime dataParaEntrega, LocalDateTime dataDeEntrega) {
}
