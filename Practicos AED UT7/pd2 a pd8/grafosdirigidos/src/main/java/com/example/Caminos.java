package com.example;

import java.util.ArrayList;
import java.util.List;

public class Caminos {
    public List<Camino> caminos;

    public Caminos() {
        this.caminos = new ArrayList<>();
    }

    public void agregarCamino(Camino camino) {
        this.caminos.add(camino);
    }

    public List<Camino> getCaminos() {
        return this.caminos;
    }
}
