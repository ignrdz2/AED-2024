package com.example;

public class ColaCircular<T> {
    private int inicio;
    private int fin;
    private int capacidad;
    private T[] elementos;

    public ColaCircular(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = (T[]) new Object[capacidad];
        this.inicio = 0;
        this.fin = 0;
    }

    public boolean estaVacia() {
        return inicio == fin;
    }

    public boolean estaLlena() {
        return (fin + 1) % capacidad == inicio;
    }

    public void ponerEnCola(T elemento) {
        if (!estaLlena()) {
            elementos[fin] = elemento;
            fin = (fin + 1) % capacidad;
        } else {
            System.out.println("La cola está llena");
        }
    }

    public T quitarDeCola() {
        T elemento = null;
        if (!estaVacia()) {
            elemento = elementos[inicio];
            inicio = (inicio + 1) % capacidad;
        } else {
            System.out.println("La cola está vacía");
        }
        return elemento;
    }
}
