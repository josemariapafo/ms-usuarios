package com.portafolio.msusuario.controllers;

import com.portafolio.msusuario.domain.Problem;
import com.portafolio.msusuario.exceptions.UsuarioNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerGlobalException {

    @ExceptionHandler(value = {UsuarioNoEncontradoException.class})
    public ResponseEntity<Problem> resourceNotFoundException(UsuarioNoEncontradoException error) {
        Problem problem = Problem.builder().title("Usuario no encontrado").description(error.getMessage()).statusCode("404").build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
    }
}
