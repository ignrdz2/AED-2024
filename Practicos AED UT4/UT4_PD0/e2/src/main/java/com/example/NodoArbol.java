package com.example;

public class NodoArbol {
    char valor;
    NodoArbol izquierda;
    NodoArbol derecha;

    // Constructor para nodo con operador
    NodoArbol(char valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }
}
