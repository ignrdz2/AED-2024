package uy.edu.ucu.aed;

import java.util.LinkedList;

public class Fila<T> {
    private LinkedList<T> elementos;

    public Fila() {
        this.elementos = new LinkedList<>();
    }

    // Método para agregar un elemento al final de la fila
    public void encolar(T elemento) {
        this.elementos.addLast(elemento);
    }

    // Método para remover y retornar el primer elemento de la fila
    public T desencolar() {
        if (!estaVacia()) {
            return this.elementos.removeFirst();
        } else {
            return null;
        }
    }

    // Método para verificar si la fila está vacía
    public boolean estaVacia() {
        return this.elementos.isEmpty();
    }

    // Método para obtener el primer elemento de la fila sin removerlo
    public T primero() {
        if (!estaVacia()) {
            return this.elementos.getFirst();
        } else {
            return null;
        }
    }
}
