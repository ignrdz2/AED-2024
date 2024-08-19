package com.example;

import java.util.HashMap;

public class ArbolExpresionAritmetica {
    public static NodoArbol sustituirVariables(NodoArbol raiz, HashMap<String, Double> variables) {
        if (raiz == null) {
            return null;
        }

        if (raiz.variable != null && variables.containsKey(raiz.variable)) {
            return new NodoArbol(variables.get(raiz.variable));
        }

        raiz.izquierda = sustituirVariables(raiz.izquierda, variables);
        raiz.derecha = sustituirVariables(raiz.derecha, variables);

        return raiz;
    }

    public static double evaluarExpresion(NodoArbol raiz) {
        if (raiz == null) {
            return 0;
        }

        if (raiz.operador == '+') {
            return evaluarExpresion(raiz.izquierda) + evaluarExpresion(raiz.derecha);
        } else if (raiz.operador == '-') {
            return evaluarExpresion(raiz.izquierda) - evaluarExpresion(raiz.derecha);
        } else if (raiz.operador == '*') {
            return evaluarExpresion(raiz.izquierda) * evaluarExpresion(raiz.derecha);
        } else if (raiz.operador == '/') {
            double valorDerecha = evaluarExpresion(raiz.derecha);
            if (valorDerecha == 0) {
                throw new ArithmeticException("División por cero");
            }
            return evaluarExpresion(raiz.izquierda) / valorDerecha;
        } else {
            return raiz.constante;
        }
    }
}