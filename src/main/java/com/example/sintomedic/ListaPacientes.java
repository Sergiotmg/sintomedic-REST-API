package com.example.sintomedic;

import java.util.Objects;

public class ListaPacientes {
    private int id;
    private int  	IdPaciente1;
    private int  	IdPaciente2;
    private int  	IdPaciente3;
    private int  	IdPaciente4;
    private int  	IdPaciente5;
    private int  	IdPaciente6;
    private int  	IdPaciente7;
    private int  	IdPaciente8;
    private int  	IdPaciente9;
    private int  	IdPaciente10;
    public ListaPacientes() {
    }

    public ListaPacientes(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPaciente1() {
        return IdPaciente1;
    }

    public void setIdPaciente1(int idPaciente1) {
        IdPaciente1 = idPaciente1;
    }

    public int getIdPaciente2() {
        return IdPaciente2;
    }

    public void setIdPaciente2(int idPaciente2) {
        IdPaciente2 = idPaciente2;
    }

    public int getIdPaciente3() {
        return IdPaciente3;
    }

    public void setIdPaciente3(int idPaciente3) {
        IdPaciente3 = idPaciente3;
    }

    public int getIdPaciente4() {
        return IdPaciente4;
    }

    public void setIdPaciente4(int idPaciente4) {
        IdPaciente4 = idPaciente4;
    }

    public int getIdPaciente5() {
        return IdPaciente5;
    }

    public void setIdPaciente5(int idPaciente5) {
        IdPaciente5 = idPaciente5;
    }

    public int getIdPaciente6() {
        return IdPaciente6;
    }

    public void setIdPaciente6(int idPaciente6) {
        IdPaciente6 = idPaciente6;
    }

    public int getIdPaciente7() {
        return IdPaciente7;
    }

    public void setIdPaciente7(int idPaciente7) {
        IdPaciente7 = idPaciente7;
    }

    public int getIdPaciente8() {
        return IdPaciente8;
    }

    public void setIdPaciente8(int idPaciente8) {
        IdPaciente8 = idPaciente8;
    }

    public int getIdPaciente9() {
        return IdPaciente9;
    }

    public void setIdPaciente9(int idPaciente9) {
        IdPaciente9 = idPaciente9;
    }

    public int getIdPaciente10() {
        return IdPaciente10;
    }

    public void setIdPaciente10(int idPaciente10) {
        IdPaciente10 = idPaciente10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaPacientes that = (ListaPacientes) o;
        return id == that.id &&
                IdPaciente1 == that.IdPaciente1 &&
                IdPaciente2 == that.IdPaciente2 &&
                IdPaciente3 == that.IdPaciente3 &&
                IdPaciente4 == that.IdPaciente4 &&
                IdPaciente5 == that.IdPaciente5 &&
                IdPaciente6 == that.IdPaciente6 &&
                IdPaciente7 == that.IdPaciente7 &&
                IdPaciente8 == that.IdPaciente8 &&
                IdPaciente9 == that.IdPaciente9 &&
                IdPaciente10 == that.IdPaciente10;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, IdPaciente1, IdPaciente2, IdPaciente3, IdPaciente4, IdPaciente5, IdPaciente6, IdPaciente7, IdPaciente8, IdPaciente9, IdPaciente10);
    }

    @Override
    public String toString() {
        return "ListaPacientes{" +
                "id=" + id +
                ", IdPaciente1=" + IdPaciente1 +
                ", IdPaciente2=" + IdPaciente2 +
                ", IdPaciente3=" + IdPaciente3 +
                ", IdPaciente4=" + IdPaciente4 +
                ", IdPaciente5=" + IdPaciente5 +
                ", IdPaciente6=" + IdPaciente6 +
                ", IdPaciente7=" + IdPaciente7 +
                ", IdPaciente8=" + IdPaciente8 +
                ", IdPaciente9=" + IdPaciente9 +
                ", IdPaciente10=" + IdPaciente10 +
                '}';
    }
}
