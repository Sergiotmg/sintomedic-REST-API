package com.example.sintomedic;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "pacientes")

public class Paciente {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String Nombre;

    @NotBlank
    private String Apellidos;

    private String CompaniaAseguradora;

    @NotBlank
    private String DNI_NIE;

    private String Localidad;

    @NotBlank
    private String  Telefono ;

    @NotBlank
    private String  Correo ;


    public Paciente(){
        super();
    }
    public Paciente(Long id, String nombre) {
        super();
        Nombre = nombre;
        id=id;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getCompaniaAseguradora() {
        return CompaniaAseguradora;
    }

    public void setCompaniaAseguradora(String companiaAseguradora) {
        CompaniaAseguradora = companiaAseguradora;
    }

    public String getDNI_NIE() {
        return DNI_NIE;
    }

    public void setDNI_NIE(String DNI_NIE) {
        this.DNI_NIE = DNI_NIE;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
