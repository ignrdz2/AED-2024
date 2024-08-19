package uy.edu.ucu.aed;

public class FilaNodos<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;

    private static class Nodo<T> {
        private T dato;
        private Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public FilaNodos() {
        this.cabeza = null;
        this.cola = null;
    }

    // Método para agregar un elemento al final de la fila
    public void encolar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (cola != null) {
            cola.siguiente = nuevoNodo;
        }
        cola = nuevoNodo;
        if (cabeza == null) {
            cabeza = cola;
        }
    }

    // Método para remover y retornar el primer elemento de la fila
    public T desencolar() {
        if (cabeza != null) {
            T dato = cabeza.dato;
            cabeza = cabeza.siguiente;
            if (cabeza == null) {
                cola = null;
            }
            return dato;
        }
        return null;
    }

    // Método para verificar si la fila está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }
}