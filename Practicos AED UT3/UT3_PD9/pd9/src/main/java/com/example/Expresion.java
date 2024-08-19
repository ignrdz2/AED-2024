package com.example;

import java.util.List;
import java.util.Stack;

public class Expresion {

    public boolean controlCorchetes(List<Character> listaDeEntrada) {
        Stack<Character> pila = new Stack<>();

        for (char caracter : listaDeEntrada) {
            if (caracter == '{') {
                pila.push('{');
            } else if (caracter == '}') {
                if (pila.isEmpty()) {
                    return false;
                } else {
                    pila.pop();
                }
            }
        }

        return pila.isEmpty();
    }
}
