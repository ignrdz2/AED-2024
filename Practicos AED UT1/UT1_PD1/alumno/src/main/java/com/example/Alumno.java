package com.example;

public class Alumno {
    private String nombre;

    public Alumno () {
        nombre = "Ignacio";
    }

    public String getNombre(){
        return nombre;
    }
    public String getNombreAdmiracion() {
        return nombre.concat("!");
    }

}
