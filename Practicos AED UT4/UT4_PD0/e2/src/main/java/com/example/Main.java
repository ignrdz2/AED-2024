package com.example;

public class Main {
    public static void main(String[] args) {
        String expresion1 = "*+ab-cd";
        String expresion2 = "+*abcd";

        NodoArbol arbol1 = ArbolExpresionPrefija.construirArbol(expresion1);
        NodoArbol arbol2 = ArbolExpresionPrefija.construirArbol(expresion2);

        System.out.print("Árbol 1 en orden: ");
        ArbolExpresionPrefija.imprimirEnOrden(arbol1);
        System.out.println();

        System.out.print("Árbol 2 en orden: ");
        ArbolExpresionPrefija.imprimirEnOrden(arbol2);
        System.out.println();
    }
}