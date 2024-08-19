package com.example;

public class NodoOrdenado<T extends Comparable<T>> {
    private T dato;
    private NodoOrdenado<T> siguiente;

    public NodoOrdenado(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoOrdenado<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoOrdenado<T> siguiente) {
        this.siguiente = siguiente;
    }
}

