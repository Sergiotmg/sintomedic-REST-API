package com.example.sintomedic.exception;

import java.util.function.Supplier;

public class UsuarioNotFoundException extends Exception  {
    public UsuarioNotFoundException(int id) {
        super(String.format("Usuario con id : '%s' no encontrado", id));
    }

}
