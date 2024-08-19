package uy.edu.ucu.aed;

public class PilaNodos<T> {
    private Nodo<T> cima;

    private static class Nodo<T> {
        private T dato;
        private Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public PilaNodos() {
        this.cima = null;
    }

    // Método para agregar un elemento a la cima de la pila
    public void apilar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
    }

    // Método para remover y retornar el elemento en la cima de la pila
    public T desapilar() {
        if (cima != null) {
            T dato = cima.dato;
            cima = cima.siguiente;
            return dato;
        }
        return null;
    }

    // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        return cima == null;
    }
}
