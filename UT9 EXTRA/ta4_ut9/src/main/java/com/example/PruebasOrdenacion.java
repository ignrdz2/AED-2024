package com.example;

import java.util.Random;
import java.util.Arrays;

public class PruebasOrdenacion {

    public static void main(String[] args) {
        TClasificador clasificador = new TClasificador();
        int[] tamanios = {300, 10000, 30000};
        Random rand = new Random();

        for (int n : tamanios) {
            int[] datosAscendentes = new int[n];
            int[] datosDescendentes = new int[n];
            int[] datosAleatorios = new int[n];

            for (int i = 0; i < n; i++) {
                datosAscendentes[i] = i;
                datosDescendentes[i] = n - i;
                datosAleatorios[i] = rand.nextInt(n);
            }

            ejecutarPrueba(clasificador, datosAscendentes.clone(), "Ascendente", n);
            ejecutarPrueba(clasificador, datosDescendentes.clone(), "Descendente", n);
            ejecutarPrueba(clasificador, datosAleatorios.clone(), "Aleatorio", n);
        }
    }

    private static void ejecutarPrueba(TClasificador clasificador, int[] datos, String tipo, int n) {
        int[] metodos = {
            TClasificador.METODO_CLASIFICACION_INSERCION,
            TClasificador.METODO_CLASIFICACION_SHELLSORT,
            TClasificador.METODO_CLASIFICACION_BURBUJA,
            TClasificador.METODO_CLASIFICACION_QUICKSORT
        };

        String[] nombresMetodos = {"Inserción", "Shellsort", "Burbuja", "Quicksort"};

        for (int i = 0; i < metodos.length; i++) {
            long inicio = System.nanoTime();
            int[] resultado = clasificador.clasificar(datos.clone(), metodos[i]);
            long fin = System.nanoTime();

            System.out.println("Ordenación " + nombresMetodos[i] + " con datos " + tipo + " de tamaño " + n + ": " + (fin - inicio) + " ns");

            if (!clasificador.estaOrdenado(resultado)) {
                System.err.println("El algoritmo " + nombresMetodos[i] + " no ordenó correctamente los datos " + tipo + " de tamaño " + n);
            }
        }
    }
}
