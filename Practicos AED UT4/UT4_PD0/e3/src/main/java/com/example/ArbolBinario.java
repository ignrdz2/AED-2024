package com.example;

import java.util.Stack;

public class ArbolBinario {
    private NodoArbol raiz;

    // Método para construir el árbol binario de expresión a partir de una expresión en notación prefija
    public void construirArbol(String expresion) {
        Stack<NodoArbol> pila = new Stack<>();

        // Recorremos la expresión en notación prefija de derecha a izquierda
        for (int i = expresion.length() - 1; i >= 0; i--) {
            char caracter = expresion.charAt(i);

            // Si el caracter actual es un operador, creamos un nuevo nodo y lo agregamos a la pila
            if (esOperador(caracter)) {
                NodoArbol nodo = new NodoArbol(caracter);
                nodo.izquierda = pila.pop();
                nodo.derecha = pila.pop();
                pila.push(nodo);
            }
            // Si es un operando, creamos un nodo y lo agregamos a la pila
            else {
                NodoArbol nodo = new NodoArbol(caracter);
                pila.push(nodo);
            }
        }

        // El último nodo en la pila es el nodo raíz del árbol
        this.raiz = pila.pop();
    }

    // Método para evaluar la expresión representada en el árbol
    public double evaluarExpresion() {
        return evaluarExpresion(this.raiz);
    }

    private double evaluarExpresion(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }

        if (nodo.valor == '+') {
            return evaluarExpresion(nodo.izquierda) + evaluarExpresion(nodo.derecha);
        } else if (nodo.valor == '-') {
            return evaluarExpresion(nodo.izquierda) - evaluarExpresion(nodo.derecha);
        } else if (nodo.valor == '*') {
            return evaluarExpresion(nodo.izquierda) * evaluarExpresion(nodo.derecha);
        } else if (nodo.valor == '/') {
            double valorDerecha = evaluarExpresion(nodo.derecha);
            if (valorDerecha == 0) {
                throw new ArithmeticException("División por cero");
            }
            return evaluarExpresion(nodo.izquierda) / valorDerecha;
        } else {
            // Si el nodo es un operando, convertimos su valor de carácter a un número
            return Character.getNumericValue(nodo.valor);
        }
    }

    // Método auxiliar para verificar si un carácter es un operador
    private boolean esOperador(char caracter) {
        return caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/';
    }
}