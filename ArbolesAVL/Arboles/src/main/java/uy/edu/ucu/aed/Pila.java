package uy.edu.ucu.aed;

import java.util.Stack;

public class Pila<T> {
    private Stack<T> elementos;

    public Pila() {
        this.elementos = new Stack<>();
    }

    // Método para agregar un elemento a la cima de la pila
    public void apilar(T elemento) {
        this.elementos.push(elemento);
    }

    // Método para remover y retornar el elemento en la cima de la pila
    public T desapilar() {
        if (!estaVacia()) {
            return this.elementos.pop();
        } else {
            return null;
        }
    }

    // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        return this.elementos.isEmpty();
    }

    // Método para obtener el elemento en la cima de la pila sin removerlo
    public T cima() {
        if (!estaVacia()) {
            return this.elementos.peek();
        } else {
            return null;
        }
    }
}
