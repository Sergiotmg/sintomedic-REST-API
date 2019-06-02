package com.example.sintomedic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "sintomas")
public class Sintoma {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String descripcion;
    @NotBlank
    private int idPaciente;
    @NotBlank
    private int idDoctorEnviado;
    @NotBlank
    private Date fechaHora;
    private float temperatura;
    private float presionArterial;
    private String pulso;

    public Sintoma() {
        super();
    }

    public Sintoma(@NotBlank String descripcion, @NotBlank int idPaciente, @NotBlank int idDoctorEnviado, @NotBlank Date fechaHora) {
        super();
        this.descripcion = descripcion;
        this.idPaciente = idPaciente;
        this.idDoctorEnviado = idDoctorEnviado;
        this.fechaHora = fechaHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdDoctorEnviado() {
        return idDoctorEnviado;
    }

    public void setIdDoctorEnviado(int idDoctorEnviado) {
        this.idDoctorEnviado = idDoctorEnviado;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(float presionArterial) {
        this.presionArterial = presionArterial;
    }

    public String  getPulso() {
        return pulso;
    }

    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sintoma sintoma = (Sintoma) o;
        return idPaciente == sintoma.idPaciente &&
                idDoctorEnviado == sintoma.idDoctorEnviado &&
                Float.compare(sintoma.temperatura, temperatura) == 0 &&
                Float.compare(sintoma.presionArterial, presionArterial) == 0 &&
                id.equals(sintoma.id) &&
                descripcion.equals(sintoma.descripcion) &&
                Objects.equals(fechaHora, sintoma.fechaHora) &&
                Objects.equals(pulso, sintoma.pulso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, idPaciente, idDoctorEnviado, fechaHora, temperatura, presionArterial, pulso);
    }

    @Override
    public String toString() {
        return "Sintoma{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", idPaciente=" + idPaciente +
                ", idDoctorEnviado=" + idDoctorEnviado +
                ", fechaHora=" + fechaHora +
                ", temperatura=" + temperatura +
                ", presionArterial=" + presionArterial +
                ", pulso='" + pulso + '\'' +
                '}';
    }
}
