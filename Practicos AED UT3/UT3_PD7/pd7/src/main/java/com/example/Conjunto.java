package com.example;

public class Conjunto<T extends Comparable<T>> extends ListaSimpleEnlazada<T> implements IConjunto<T> {

    @Override
    public IConjunto<T> union(IConjunto<T> otroConjunto) {
        Conjunto<T> nuevoConjunto = new Conjunto<>();

        Nodo<T> nodoActual = this.obtenerPrimero();
        while (nodoActual != null) {
            nuevoConjunto.agregar(nodoActual.elemento);
            nodoActual = nodoActual.siguiente;
        }

        nodoActual = otroConjunto.obtenerPrimero();
        while (nodoActual != null) {
            if (!nuevoConjunto.contiene(nodoActual.elemento)) {
                nuevoConjunto.agregar(nodoActual.elemento);
            }
            nodoActual = nodoActual.siguiente;
        }

        return nuevoConjunto;
    }

    @Override
    public IConjunto<T> interseccion(IConjunto<T> otroConjunto) {
        Conjunto<T> nuevoConjunto = new Conjunto<>();

        Nodo<T> nodoActual = this.obtenerPrimero();
        while (nodoActual != null) {
            if (otroConjunto.contiene(nodoActual.elemento)) {
                nuevoConjunto.agregar(nodoActual.elemento);
            }
            nodoActual = nodoActual.siguiente;
        }

        return nuevoConjunto;
    }
}

