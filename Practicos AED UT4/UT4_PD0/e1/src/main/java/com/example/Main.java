package com.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Construir un árbol de expresiones aritméticas: 3 * (a + b)
        NodoArbol variableA = new NodoArbol("a");
        NodoArbol variableB = new NodoArbol("b");
        NodoArbol nodoSuma = new NodoArbol('+', variableA, variableB);
        NodoArbol constante3 = new NodoArbol(3);
        NodoArbol nodoMultiplicacion = new NodoArbol('*', constante3, nodoSuma);

        HashMap<String, Double> variables = new HashMap<>();
        variables.put("a", 5.0);
        variables.put("b", 7.0);

        NodoArbol arbolSustituido = ArbolExpresionAritmetica.sustituirVariables(nodoMultiplicacion, variables);

        double resultado = ArbolExpresionAritmetica.evaluarExpresion(arbolSustituido);
        System.out.println("El resultado de la expresión es: " + resultado); // Salida esperada: 36.0
    }
}