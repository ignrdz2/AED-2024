// Nodo.java
package com.example;

public class Nodo<T> implements INodo<T> {

    private T dato;
    private Comparable etiqueta;
    private Nodo<T> siguiente;

    public Nodo(T dato, Comparable etiqueta) {
        this.dato = dato;
        this.etiqueta = etiqueta;
        this.siguiente = null;
    }

    public void agregarIncompatibilidad(String identificadorSuero, T identificadorFarmaco) {
        Par<String, T> par = new Par<>(identificadorSuero, identificadorFarmaco);
        Nodo<T> nodo = new Nodo<>(par, par.hashCode());
        insertar(nodo);
    }

    public void insertar(Nodo<T> nuevoNodo) {
        if (this.siguiente == null) {
            this.siguiente = nuevoNodo;
        } else {
            Nodo<T> temp = this.siguiente;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    @Override
    public void setSiguiente(Nodo<T> nodo) {
        this.siguiente = nodo;
    }

    @Override
    public void imprimir() {
        System.out.print(dato + " ");
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.print(etiqueta + " ");
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }
}
