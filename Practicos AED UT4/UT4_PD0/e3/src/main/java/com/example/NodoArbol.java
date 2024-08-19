package com.example;

class NodoArbol {
    char valor;
    NodoArbol izquierda;
    NodoArbol derecha;

    NodoArbol(char valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }
}