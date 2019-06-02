package com.example.sintomedic.exception;

import java.util.function.Supplier;

public class UsuarioNotFoundException extends Exception implements Supplier {
    public UsuarioNotFoundException(Long id) {
        super(String.format("Usuario con id : '%s' no encontrado", id));
    }

    @Override
    public Object get() {
        return null;
    }
}
