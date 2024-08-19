package com.example;

public class Arista {
    private Comparable etiquetaOrigen;
    private Comparable etiquetaDestino;
    private double costo;

    public Arista(Comparable etiquetaOrigen, Comparable etiquetaDestino, double costo){
        this.etiquetaOrigen = etiquetaOrigen;
        this.etiquetaDestino = etiquetaDestino;
        this.costo = costo;
    }

    public Comparable getOrigen(){
        return this.etiquetaOrigen;
    }
    
    public void setOrigen(Comparable etiquetaOrigen){
        this.etiquetaOrigen = etiquetaOrigen;
    }

    public Comparable getDestino(){
        return this.etiquetaDestino;
    }

    public void setDestino(Comparable etiquetaDestino){
        this.etiquetaDestino = etiquetaDestino;
    }

    public double getCosto(){
        return this.costo;
    }

    public void setCosto(double costo){
        this.costo = costo;
    }
}
