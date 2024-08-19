package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Unit test for simple App.
 */
public class PruebasExpresion {

    public static void main(String[] args) {
        Expresion expresion = new Expresion();

        List<Character> expresionCorrecta1 = new ArrayList<>(Arrays.asList('{', '}', '{', '{', '}', '}'));
        System.out.println("Es una secuencia bien formada: " + expresion.controlCorchetes(expresionCorrecta1));  // Debería devolver true

        List<Character> expresionCorrecta2 = new ArrayList<>(Arrays.asList('{', '{', '{', '}', '}', '}'));
        System.out.println("Es una secuencia bien formada: " + expresion.controlCorchetes(expresionCorrecta2));  // Debería devolver true

        List<Character> expresionCorrecta3 = new ArrayList<>(Arrays.asList('{', '{', '}', '{', '{', '}', '}'));
        System.out.println("Es una secuencia bien formada: " + expresion.controlCorchetes(expresionCorrecta3));  // Debería devolver true

        List<Character> expresionCorrecta4 = new ArrayList<>(Arrays.asList('{', '}', '{', '{', '}', '{', '}', '}'));
        System.out.println("Es una secuencia bien formada: " + expresion.controlCorchetes(expresionCorrecta4));  // Debería devolver true

        // Pruebas con expresiones incorrectas
        List<Character> expresionIncorrecta1 = new ArrayList<>(Arrays.asList('{', '{', '}', '{', '{', '}'));
        System.out.println("Es una secuencia mal formada: " + expresion.controlCorchetes(expresionIncorrecta1));  // Debería devolver false

        List<Character> expresionIncorrecta2 = new ArrayList<>(Arrays.asList('{', '{', '}', '}', '{', '}'));
        System.out.println("Es una secuencia mal formada: " + expresion.controlCorchetes(expresionIncorrecta2));  // Debería devolver false

        List<Character> expresionIncorrecta3 = new ArrayList<>(Arrays.asList('{', '{', '}', '{', '{', '}', '}'));
        System.out.println("Es una secuencia mal formada: " + expresion.controlCorchetes(expresionIncorrecta3));  // Debería devolver false

        List<Character> expresionIncorrecta4 = new ArrayList<>(Arrays.asList('{', '}', '{', '{', '}', '{', '}'));
        System.out.println("Es una secuencia mal formada: " + expresion.controlCorchetes(expresionIncorrecta4));  // Debería devolver false
    }
}

