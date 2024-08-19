package com.example;

public class ListaEnlazada<T> {
    Nodo<T> primero;

    public ListaEnlazada() {
        this.primero = null;
    }

    public void agregar(T elemento) {
        Nodo<T> nodo = new Nodo<T>(elemento);
        if (primero == null) {
            primero = nodo;
        } else {
            Nodo<T> nodoActual = primero;
            while (nodoActual.siguiente != null) {
                nodoActual = nodoActual.siguiente;
            }
            nodoActual.siguiente = nodo;
        }
    }

    public T buscar(T elemento) {
        Nodo<T> nodoActual = primero;
        while (nodoActual != null) {
            if (nodoActual.elemento.equals(elemento)) {
                return nodoActual.elemento;
            }
            nodoActual = nodoActual.siguiente;
        }
        return null;
    }

    public void quitar(T elemento) {
        if (primero == null) {
            return;
        }
        if (primero.elemento.equals(elemento)) {
            primero = primero.siguiente;
            return;
        }
        Nodo<T> nodoActual = primero;
        while (nodoActual.siguiente != null) {
            if (nodoActual.siguiente.elemento.equals(elemento)) {
                nodoActual.siguiente = nodoActual.siguiente.siguiente;
                return;
            } else {
                nodoActual = nodoActual.siguiente;
            }
        }
    }

    public void listar() {
        Nodo<T> nodoActual = primero;
        while (nodoActual != null) {
            System.out.println(nodoActual.elemento);
            nodoActual = nodoActual.siguiente;
        }
    }

    public int cantidad() {
        int contador = 0;
        Nodo<T> nodoActual = primero;
        while (nodoActual != null) {
            contador++;
            nodoActual = nodoActual.siguiente;
        }
        return contador;
    }

    public boolean estaVacia() {
        return primero == null;
    }
}
