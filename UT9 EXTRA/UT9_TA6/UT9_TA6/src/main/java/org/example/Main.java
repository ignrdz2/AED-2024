package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TClasificador clasificador = new TClasificador();

        int[] datosAscendente = generarDatos(10000, "ascendente");
        int[] datosDescendente = generarDatos(10000, "descendente");
        int[] datosAleatorio = generarDatos(10000, "aleatorio");

        long startTime, endTime;

        // Orden Ascendente
        startTime = System.nanoTime();
        clasificador.ordenarPorHeapSort(datosAscendente);
        endTime = System.nanoTime();
        System.out.println("Tiempo Ascendente: " + (endTime - startTime) + " ns");

        // Orden Descendente
        startTime = System.nanoTime();
        clasificador.ordenarPorHeapSort(datosDescendente);
        endTime = System.nanoTime();
        System.out.println("Tiempo Descendente: " + (endTime - startTime) + " ns");

        // Orden Aleatorio
        startTime = System.nanoTime();
        clasificador.ordenarPorHeapSort(datosAleatorio);
        endTime = System.nanoTime();
        System.out.println("Tiempo Aleatorio: " + (endTime - startTime) + " ns");

        // Verificación de orden
        System.out.println("Ordenado Ascendente: " + Arrays.toString(datosAscendente));
        System.out.println("Ordenado Descendente: " + Arrays.toString(datosDescendente));
        System.out.println("Ordenado Aleatorio: " + Arrays.toString(datosAleatorio));
    }

    private static int[] generarDatos(int tamaño, String tipo) {
        int[] datos = new int[tamaño];
        Random random = new Random();

        switch (tipo) {
            case "ascendente":
                for (int i = 0; i < tamaño; i++) {
                    datos[i] = i;
                }
                break;
            case "descendente":
                for (int i = 0; i < tamaño; i++) {
                    datos[i] = tamaño - i;
                }
                break;
            case "aleatorio":
                for (int i = 0; i < tamaño; i++) {
                    datos[i] = random.nextInt(tamaño);
                }
                break;
        }
        return datos;
    }
}
