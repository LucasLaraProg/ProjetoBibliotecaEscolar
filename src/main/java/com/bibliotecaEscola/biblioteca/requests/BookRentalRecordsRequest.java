package com.bibliotecaEscola.biblioteca.requests;

import java.time.LocalDateTime;

public record BookRentalRecordsRequest(LocalDateTime dataParaEntrega, LocalDateTime dataDeEntrega) {
}
