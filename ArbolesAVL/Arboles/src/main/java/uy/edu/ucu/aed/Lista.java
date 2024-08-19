package uy.edu.ucu.aed;

public class Lista<T> {
    private Nodo<T> cabeza;

    private static class Nodo<T> {
        private T dato;
        private Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public Lista() {
        this.cabeza = null;
    }

    // Método para agregar un elemento al inicio de la lista
    public void agregarAlInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    // Método para remover y retornar el primer elemento de la lista
    public T removerDelInicio() {
        if (cabeza != null) {
            T dato = cabeza.dato;
            cabeza = cabeza.siguiente;
            return dato;
        }
        return null;
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }
}
