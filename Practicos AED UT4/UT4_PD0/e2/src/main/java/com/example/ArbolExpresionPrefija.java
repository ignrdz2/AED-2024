package com.example;

import java.util.Stack;

public class ArbolExpresionPrefija {

    public static NodoArbol construirArbol(String expresion) {
        Stack<NodoArbol> pila = new Stack<>();

        for (int i = expresion.length() - 1; i >= 0; i--) {
            char caracter = expresion.charAt(i);

            if (esOperador(caracter)) {
                NodoArbol nodo = new NodoArbol(caracter);
                nodo.izquierda = pila.pop();
                nodo.derecha = pila.pop();
                pila.push(nodo);
            } 
            else {
                NodoArbol nodo = new NodoArbol(caracter);
                pila.push(nodo);
            }
        }

        return pila.pop();
    }

    private static boolean esOperador(char caracter) {
        return caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/';
    }

    public static void imprimirEnOrden(NodoArbol nodo) {
        if (nodo != null) {
            imprimirEnOrden(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            imprimirEnOrden(nodo.derecha);
        }
    }
}