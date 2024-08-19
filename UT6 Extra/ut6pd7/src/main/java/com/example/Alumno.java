package com.example;

import java.util.Objects;

public class Alumno {
    private int ID;
    private String fullName;
    private String email;

    // Constructor y otros métodos aquí...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return ID == alumno.ID &&
                Objects.equals(fullName, alumno.fullName) &&
                Objects.equals(email, alumno.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, fullName, email);
    }
}

