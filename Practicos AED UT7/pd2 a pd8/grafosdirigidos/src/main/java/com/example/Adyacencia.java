package com.example;

public class Adyacencia {
    private Comparable etiqueta;
    private double costo;
    private Vertice destino;
    
    public Adyacencia(double costo, Vertice destino){
        this.etiqueta = destino.getEtiqueta();
        this.costo = costo;
        this.destino = destino;
    }

    public Comparable getEtiqueta(){
        return this.etiqueta;
    }

    public double getCosto(){
        return this.costo;
    }

    public Vertice getDestino(){
        return this.destino;
    }
}
