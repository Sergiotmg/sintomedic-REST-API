package com.example.sintomedic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "enfermedad_de_paciente")
public class EnfermedadPaciente {

    @Id
    @GeneratedValue
    private  int id;
    @NotBlank
    private String Nombre;

    private String Descripcion;
    private Date fecha_inicio;
    private Date fecha_fin;
    @NotBlank
    private  int id_usuario;

    public EnfermedadPaciente(@NotBlank int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public EnfermedadPaciente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnfermedadPaciente that = (EnfermedadPaciente) o;
        return id == that.id &&
                id_usuario == that.id_usuario &&
                Objects.equals(Nombre, that.Nombre) &&
                Objects.equals(Descripcion, that.Descripcion) &&
                Objects.equals(fecha_inicio, that.fecha_inicio) &&
                Objects.equals(fecha_fin, that.fecha_fin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Nombre, Descripcion, fecha_inicio, fecha_fin, id_usuario);
    }

    @Override
    public String toString() {
        return "EnfermedadPaciente{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", id_usuario=" + id_usuario +
                '}';
    }
}

