package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    
    public static void main(String[] args) {
        int[] arreglo = leerArchivo("././src/numeros.txt");
        int contador = bubbleSortConContador(arreglo);
        
        System.out.println("Largo N: " + arreglo.length);
        System.out.println("Contador: " + contador);
        System.out.println("Primer número: " + arreglo[0]);
        System.out.println("Último número: " + arreglo[arreglo.length - 1]);
    }

    public static int[] leerArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            int N = Integer.parseInt(br.readLine());
            int[] arreglo = new int[N];
            
            for (int i = 0; i < N; i++) {
                arreglo[i] = Integer.parseInt(br.readLine());
            }
            
            return arreglo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int bubbleSortConContador(int[] arreglo) {
        int contador = 0;
        int N = arreglo.length;

        for (int i = 0; i < N - 1; i++) {
            for (int j = N - 1; j > i; j--) {
                contador++; // Contar cada vez que se invoca la sentencia "si"
                if (arreglo[j] < arreglo[j - 1]) {
                    // Intercambio de elementos
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j - 1];
                    arreglo[j - 1] = temp;
                }
            }
        }
        return contador;
    }
}
