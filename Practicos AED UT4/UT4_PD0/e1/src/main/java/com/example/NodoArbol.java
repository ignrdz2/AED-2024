package com.example;

public class NodoArbol {
    char operador;
    double constante;
    String variable;
    NodoArbol izquierda;
    NodoArbol derecha;

    NodoArbol(char operador, NodoArbol izquierda, NodoArbol derecha) {
        this.operador = operador;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    NodoArbol(double constante) {
        this.constante = constante;
    }

    NodoArbol(String variable) {
        this.variable = variable;
    }
}
