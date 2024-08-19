package com.example;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        String frase = "Si piensas que tu profesor es exijente,... espera a conocer a tu jefe !";
        ContadorPalabras contador = new ContadorPalabras();

        //Ejercicio 1
        System.out.println("Ejercicio 1");
        System.out.println("La frase tiene " + contador.contarPalabras(frase) + " palabras");

        System.out.println();

        //Ejrercicio 2
        System.out.println("Ejercicio 2");
        System.out.println("La frase tiene " + contador.GetConsonants(frase) + " consonantes");
        System.out.println("La frase tiene " + contador.GetVocals(frase) + " vocales");
        System.out.println("La frase tiene " + contador.palabraMayoresX(frase, 3) + " palabras de mas de 3 letras");

        System.out.println();
        
        //Ejercicio 3
        System.out.println("Ejercicio 3");

        String[] lineas = contador.obtenerLineas("./././src/UT1_TA3_ARCHIVO_EJEMPLO.txt");
        System.out.println(contador.cantPalabras(lineas));

        //Ejercicio 4
        String[] arr1 = {"Hola", "mundo", "de", "los", "algoritmos"};
        String[] arr2 = {"Hola", "mundo", "de", "la", "informática"};

        String[] intersection = contador.interStrings(arr1, arr2);
        System.out.println(Arrays.toString(intersection));

        // Ejercicio 5
        System.out.println("Ejercicio 5");

        String rutaArchivo = "./././src/UT1_TA3_ARCHIVO_EJEMPLO.txt";
        contador.procesarArchivo(rutaArchivo);
        }
}
