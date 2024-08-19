package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class App 
{
    public static void main( String[] args )
    {
        List<Character> codigoFuenteBienFormado = Arrays.asList('{', '}', '{', '{', '}', '}');
        System.out.println(controlCorchetes(codigoFuenteBienFormado));  // Debería imprimir: true

        List<Character> codigoFuenteMalFormado = Arrays.asList('{', '{', '}', '{', '{', '}');
        System.out.println(controlCorchetes(codigoFuenteMalFormado));  // Debería imprimir: false
    }

    public static boolean controlCorchetes(List<Character> listaDeEntrada) {
        Stack<Character> pila = new Stack<>();

        for (Character ch : listaDeEntrada) {
            if (ch == '{') {
                pila.push(ch);
            } else if (ch == '}') {
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
