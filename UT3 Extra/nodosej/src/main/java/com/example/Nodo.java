package com.example;

public class Nodo {
    private Cancion cancion;
    private Nodo siguiente;

    public Nodo(Cancion cancion){
        this.cancion = cancion;
        siguiente = null;
    }

    public Cancion getCancion(){
        return cancion;
    }
    public void setCancion(Cancion cancion){
        this.cancion = cancion;
    }
    public Nodo getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }
}
