package com.bibliotecaEscola.biblioteca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ExistingException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity ExistingException (Exception e){
        return new ResponseEntity("Error: "+e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
