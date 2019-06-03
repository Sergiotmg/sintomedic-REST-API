package com.example.sintomedic;

import java.util.Objects;

public class ListaDoctores {
    private int id;
    private int  	IDDoctor1;
    private int  	IDDoctor2;
    private int  	IDDoctor3;

    public ListaDoctores(int id) {
        this.id = id;
    }

    public ListaDoctores() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIDDoctor1() {
        return IDDoctor1;
    }

    public void setIDDoctor1(int IDDoctor1) {
        this.IDDoctor1 = IDDoctor1;
    }

    public int getIDDoctor2() {
        return IDDoctor2;
    }

    public void setIDDoctor2(int IDDoctor2) {
        this.IDDoctor2 = IDDoctor2;
    }

    public int getIDDoctor3() {
        return IDDoctor3;
    }

    public void setIDDoctor3(int IDDoctor3) {
        this.IDDoctor3 = IDDoctor3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaDoctores that = (ListaDoctores) o;
        return id == that.id &&
                IDDoctor1 == that.IDDoctor1 &&
                IDDoctor2 == that.IDDoctor2 &&
                IDDoctor3 == that.IDDoctor3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, IDDoctor1, IDDoctor2, IDDoctor3);
    }

    @Override
    public String toString() {
        return "ListaDoctores{" +
                "id=" + id +
                ", IDDoctor1=" + IDDoctor1 +
                ", IDDoctor2=" + IDDoctor2 +
                ", IDDoctor3=" + IDDoctor3 +
                '}';
    }
}
