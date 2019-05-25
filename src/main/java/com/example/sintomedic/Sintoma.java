package com.example.sintomedic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "sintomas")
public class Sintoma {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String Descripcion;
    @NotBlank
    private int IdPaciente;
    @NotBlank
    private int IdDoctorEnviado;
    @NotBlank
    private Date  FechaHora ;
    private float Temperatura;
    private int  PresionArterial ;
    private int Pulso;
    public Sintoma(){
        super();
    }

    public Sintoma(@NotBlank String descripcion, @NotBlank int idPaciente, @NotBlank int idDoctorEnviado, @NotBlank Date fechaHora) {
        super();
        Descripcion = descripcion;
        IdPaciente = idPaciente;
        IdDoctorEnviado = idDoctorEnviado;
        FechaHora = fechaHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getIdPaciente() {
        return IdPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        IdPaciente = idPaciente;
    }

    public int getIdDoctorEnviado() {
        return IdDoctorEnviado;
    }

    public void setIdDoctorEnviado(int idDoctorEnviado) {
        IdDoctorEnviado = idDoctorEnviado;
    }

    public Date getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        FechaHora = fechaHora;
    }

    public float getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(float temperatura) {
        Temperatura = temperatura;
    }

    public int getPresionArterial() {
        return PresionArterial;
    }

    public void setPresionArterial(int presionArterial) {
        PresionArterial = presionArterial;
    }

    public int getPulso() {
        return Pulso;
    }

    public void setPulso(int pulso) {
        Pulso = pulso;
    }
}
