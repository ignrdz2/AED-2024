package com.example;

public class TAlumno implements Comparable<TAlumno> {
    private int cedula;
    private String nombre;
    private String apellido;

    public TAlumno(int cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public int compareTo(TAlumno otroAlumno) {
        return Integer.compare(this.cedula, otroAlumno.getCedula());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TAlumno otroAlumno = (TAlumno) obj;
        return cedula == otroAlumno.getCedula();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(cedula);
    }

    @Override
    public String toString() {
        return "TAlumno{" +
               "cedula=" + cedula +
               ", nombre='" + nombre + '\'' +
               ", apellido='" + apellido + '\'' +
               '}';
    }
}

