package com.example;

import java.util.Random;

public class PruebaQuicksort {

    public static void main(String[] args) {
        TClasificador clasificador = new TClasificador();

        // Prueba con datos ascendentes
        int[] datosAscendentes = new int[300];
        for (int i = 0; i < 300; i++) {
            datosAscendentes[i] = i;
        }
        System.out.println("Ordenando datos ascendentes de tamaño 300:");
        clasificador.clasificar(datosAscendentes, TClasificador.METODO_CLASIFICACION_QUICKSORT);

        // Prueba con datos descendentes
        int[] datosDescendentes = new int[300];
        for (int i = 0; i < 300; i++) {
            datosDescendentes[i] = 300 - i;
        }
        System.out.println("Ordenando datos descendentes de tamaño 300:");
        clasificador.clasificar(datosDescendentes, TClasificador.METODO_CLASIFICACION_QUICKSORT);

        // Prueba con datos aleatorios
        int[] datosAleatorios = new int[300];
        Random rand = new Random();
        for (int i = 0; i < 300; i++) {
            datosAleatorios[i] = rand.nextInt(1000);
        }
        System.out.println("Ordenando datos aleatorios de tamaño 300:");
        clasificador.clasificar(datosAleatorios, TClasificador.METODO_CLASIFICACION_QUICKSORT);

        // Prueba con 10,000 elementos en diferentes órdenes
        int[] datosGrandesAscendentes = new int[10000];
        for (int i = 0; i < 10000; i++) {
            datosGrandesAscendentes[i] = i;
        }
        System.out.println("Ordenando datos ascendentes de tamaño 10000:");
        clasificador.clasificar(datosGrandesAscendentes, TClasificador.METODO_CLASIFICACION_QUICKSORT);

        int[] datosGrandesDescendentes = new int[10000];
        for (int i = 0; i < 10000; i++) {
            datosGrandesDescendentes[i] = 10000 - i;
        }
        System.out.println("Ordenando datos descendentes de tamaño 10000:");
        clasificador.clasificar(datosGrandesDescendentes, TClasificador.METODO_CLASIFICACION_QUICKSORT);

        int[] datosGrandesAleatorios = new int[10000];
        for (int i = 0; i < 10000; i++) {
            datosGrandesAleatorios[i] = rand.nextInt(10000);
        }
        System.out.println("Ordenando datos aleatorios de tamaño 10000:");
        clasificador.clasificar(datosGrandesAleatorios, TClasificador.METODO_CLASIFICACION_QUICKSORT);
    }
}
