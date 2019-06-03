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
    private Date fechaHora;
    private float temperatura;
    private float presionArterialAlta;
    private float presionArterialBaja;
    private String pulso;

    public Sintoma() {
        super();
    }

    public Sintoma(@NotBlank String descripcion, @NotBlank int idPaciente) {
        super();
        this.descripcion = descripcion;
        this.idPaciente = idPaciente;

    }

    public float getPresionArterialAlta() {
        return presionArterialAlta;
    }

    public void setPresionArterialAlta(float presionArterialAlta) {
        this.presionArterialAlta = presionArterialAlta;
    }

    public float getPresionArterialBaja() {
        return presionArterialBaja;
    }

    public void setPresionArterialBaja(float presionArterialBaja) {
        this.presionArterialBaja = presionArterialBaja;
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
                Float.compare(sintoma.temperatura, temperatura) == 0 &&
                Float.compare(sintoma.presionArterialAlta, presionArterialAlta) == 0 &&
                Float.compare(sintoma.presionArterialBaja, presionArterialBaja) == 0 &&
                Objects.equals(id, sintoma.id) &&
                Objects.equals(descripcion, sintoma.descripcion) &&
                Objects.equals(fechaHora, sintoma.fechaHora) &&
                Objects.equals(pulso, sintoma.pulso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, idPaciente, fechaHora, temperatura, presionArterialAlta, presionArterialBaja, pulso);
    }

    @Override
    public String
    toString() {
        return "Sintoma{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", idPaciente=" + idPaciente +
                ", fechaHora=" + fechaHora +
                ", temperatura=" + temperatura +
                ", presionArterialAlta=" + presionArterialAlta +
                ", presionArterialBaja=" + presionArterialBaja +
                ", pulso='" + pulso + '\'' +
                '}';
    }
}
