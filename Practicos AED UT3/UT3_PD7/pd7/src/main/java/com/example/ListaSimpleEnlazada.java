package com.example;

public class ListaSimpleEnlazada<T extends Comparable<T>> implements ILista<T> {
    protected Nodo<T> primero;

    public ListaSimpleEnlazada() {
        this.primero = null;
    }

    @Override
    public void agregar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (primero == null) {
            primero = nuevoNodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    @Override
    public boolean eliminar(T elemento) {
        if (primero == null) {
            return false;
        }

        if (primero.elemento.equals(elemento)) {
            primero = primero.siguiente;
            return true;
        }

        Nodo<T> anterior = primero;
        Nodo<T> actual = primero.siguiente;

        while (actual != null && !actual.elemento.equals(elemento)) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual != null) {
            anterior.siguiente = actual.siguiente;
            return true;
        }

        return false;
    }

    @Override
    public boolean contiene(T elemento) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.elemento.equals(elemento)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public void limpiar() {
        primero = null;
    }

    @Override
    public int longitud() {
        int contador = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    @Override
    public void listar() {
        Nodo<T> actual = primero;
        while (actual != null) {
            System.out.print(actual.elemento + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public Nodo<T> obtenerPrimero() {
        return this.primero;
    }
}

