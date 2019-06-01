package com.example.sintomedic;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue
    private Long id;



    @NotBlank
    private String Nombre;
    @NotBlank
    private String Apellidos;
    private String Localidad;

    private String  Correo ;
    private String Lugar_consulta;
    private String CompaniaAseguradora;
    private String  Telefono ;

    @NotBlank
    private String DNI_NIE;

    private String Num_colegiado;
    @NotBlank
    private Date Fecha_nacimiento;

    @NotBlank
    private String id_lista_enfermedades;

    private String Tratamiento ;

    @NotBlank
    private String id_lista_pacientes;
    @NotBlank
    private String id_lista_doctores;
    @NotBlank
    private String id_lista_proximas_consultas;
    @NotBlank
    private String id_lista_sintomas;
    @NotBlank
    private Boolean es_doctor ;
    @NotBlank
    private Boolean es_paciente ;

    private String link_foto_perfil ;
    @NotBlank
    private String  Contrasenia ;

    /* public Usuario(){
        super();
    }*/



    //sirve lo de @JSONProperty??
    public Usuario( @JsonProperty("contrasenia")String contrasenia, @JsonProperty("dni_nie") String dni_nie) {
        super();
        this.DNI_NIE = dni_nie;
        this.Contrasenia=contrasenia;
    }
    public String getLugar_consulta() {
        return Lugar_consulta;
    }

    public void setLugar_consulta(String lugar_consulta) {
        Lugar_consulta = lugar_consulta;
    }
    public String getId_lista_enfermedades() {
        return id_lista_enfermedades;
    }

    public void setId_lista_enfermedades(String id_lista_enfermedades) {
        this.id_lista_enfermedades = id_lista_enfermedades;
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

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getCompaniaAseguradora() {
        return CompaniaAseguradora;
    }

    public void setCompaniaAseguradora(String companiaAseguradora) {
        CompaniaAseguradora = companiaAseguradora;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDNI_NIE() {
        return DNI_NIE;
    }

    public void setDNI_NIE(String DNI_NIE) {
        this.DNI_NIE = DNI_NIE;
    }

    public String getNum_colegiado() {
        return Num_colegiado;
    }

    public void setNum_colegiado(String num_colegiado) {
        Num_colegiado = num_colegiado;
    }

    public Date getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        Fecha_nacimiento = fecha_nacimiento;
    }



    public String getTratamiento() {
        return Tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        Tratamiento = tratamiento;
    }

    public String getId_lista_pacientes() {
        return id_lista_pacientes;
    }

    public void setId_lista_pacientes(String id_lista_pacientes) {
        this.id_lista_pacientes = id_lista_pacientes;
    }

    public String getId_lista_doctores() {
        return id_lista_doctores;
    }

    public void setId_lista_doctores(String id_lista_doctores) {
        this.id_lista_doctores = id_lista_doctores;
    }

    public String getId_lista_proximas_consultas() {
        return id_lista_proximas_consultas;
    }

    public void setId_lista_proximas_consultas(String id_lista_proximas_consultas) {
        this.id_lista_proximas_consultas = id_lista_proximas_consultas;
    }

    public String getId_lista_sintomas() {
        return id_lista_sintomas;
    }

    public void setId_lista_sintomas(String id_lista_sintomas) {
        this.id_lista_sintomas = id_lista_sintomas;
    }

    public Boolean getEs_doctor() {
        return es_doctor;
    }

    public void setEs_doctor(Boolean es_doctor) {
        this.es_doctor = es_doctor;
    }

    public Boolean getEs_paciente() {
        return es_paciente;
    }

    public void setEs_paciente(Boolean es_paciente) {
        this.es_paciente = es_paciente;
    }

    public String getLink_foto_perfil() {
        return link_foto_perfil;
    }

    public void setLink_foto_perfil(String link_foto_perfil) {
        this.link_foto_perfil = link_foto_perfil;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        Contrasenia = contrasenia;
    }

    public void orElseThrow(Object o) {
    }
}
