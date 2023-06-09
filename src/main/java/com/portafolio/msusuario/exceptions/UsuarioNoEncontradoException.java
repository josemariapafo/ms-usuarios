package com.portafolio.msusuario.exceptions;

public class UsuarioNoEncontradoException  extends RuntimeException{

    public UsuarioNoEncontradoException(){
        super("Usuario no encontrado");
    }
}
