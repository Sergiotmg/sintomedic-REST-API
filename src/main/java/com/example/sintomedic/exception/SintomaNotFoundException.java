package com.example.sintomedic.exception;

public class SintomaNotFoundException extends Exception {
    public SintomaNotFoundException(int id) {
        super(String.format("Sintoma con id : '%s' no encontrado", id));
    }

}
