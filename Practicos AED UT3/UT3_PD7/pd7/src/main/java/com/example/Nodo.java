package com.example;

public class Nodo<T> {
    T elemento;
    Nodo<T> siguiente;

    public Nodo(T elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }
}
