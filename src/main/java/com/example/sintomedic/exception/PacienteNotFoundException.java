package com.example.sintomedic.exception;

public class PacienteNotFoundException extends Exception {
    private long id;
    public PacienteNotFoundException(Long id) {
        super(String.format("Paciente con id : '%s' no encontrado", id));
    }
}
