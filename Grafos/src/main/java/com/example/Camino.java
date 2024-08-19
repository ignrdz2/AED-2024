package com.example;

import java.util.ArrayList;
import java.util.List;

public class Camino {
    public List<Vertice> vertices; 
    private double costo;

    public Camino() {
        this.vertices = new ArrayList<>();
        this.costo = 0.0;
    }

    public void agregarVertice(Vertice vertice, double costo) { 
        this.vertices.add(vertice);
        this.costo += costo;
    }

    public List<Vertice> getVertices() {
        return this.vertices;
    }

    public double getCosto() {
        return this.costo;
    }
}