package com.example.sintomedic.exception;

public class UsuarioNotFoundException extends Exception {
    public UsuarioNotFoundException(Long id) {
        super(String.format("Usuario con id : '%s' no encontrado", id));
    }
}
