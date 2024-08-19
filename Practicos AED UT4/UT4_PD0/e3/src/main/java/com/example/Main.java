package com.example;

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        String expresion = "*+ab-cd";

        arbol.construirArbol(expresion);
        double resultado = arbol.evaluarExpresion();
        System.out.println("El resultado de la expresión es: " + resultado); 
    }
}