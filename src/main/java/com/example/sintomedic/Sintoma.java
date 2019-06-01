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
    private int presionArterial;
    private int pulso;

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

    public int getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(int presionArterial) {
        this.presionArterial = presionArterial;
    }

    public int getPulso() {
        return pulso;
    }

    public void setPulso(int pulso) {
        this.pulso = pulso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sintoma)) return false;
        Sintoma sintoma = (Sintoma) o;
        return idPaciente == sintoma.idPaciente &&
                idDoctorEnviado == sintoma.idDoctorEnviado &&
                Float.compare(sintoma.temperatura, temperatura) == 0 &&
                presionArterial == sintoma.presionArterial &&
                pulso == sintoma.pulso &&
                Objects.equals(id, sintoma.id) &&
                Objects.equals(descripcion, sintoma.descripcion) &&
                Objects.equals(fechaHora, sintoma.fechaHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, idPaciente, idDoctorEnviado, fechaHora, temperatura, presionArterial, pulso);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nSintoma");
        sb.append("\nid=").append(id);
        sb.append(", descripcion='").append(descripcion).append("\n");
        sb.append(", idPaciente=").append(idPaciente);
        sb.append(", idDoctorEnviado=").append(idDoctorEnviado);
        sb.append(", fechaHora=").append(fechaHora);
        sb.append(", temperatura=").append(temperatura);
        sb.append(", presionArterial=").append(presionArterial);
        sb.append(", pulso=").append(pulso);
        sb.append("]");
        return sb.toString();
    }
}
