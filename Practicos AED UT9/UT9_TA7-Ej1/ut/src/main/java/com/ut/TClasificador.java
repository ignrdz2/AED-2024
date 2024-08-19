package com.ut;

import java.util.Arrays;

public class TClasificador {
    public void ordenarPorCuentaDistribucion(String[] datos, int rango) {
        int[] conteo = new int[rango];
        String[] ordenado = new String[datos.length];
        for (String dato : datos) {
            int clave = Character.getNumericValue(dato.charAt(0));
            conteo[clave]++;
        }
        int acumulacion = 0;
        for (int i = 0; i < rango; i++) {
            acumulacion += conteo[i];
            conteo[i] = acumulacion - conteo[i];
        }
        for (int i = datos.length - 1; i >= 0; i--) {
            int clave = Character.getNumericValue(datos[i].charAt(0));
            ordenado[conteo[clave]] = datos[i];
            conteo[clave]++;
        }
        System.out.println("Vector ordenado: " + Arrays.toString(ordenado));
        System.out.println("Vector de conteo (final): " + Arrays.toString(conteo));
    }   
    //Heapsort
    public void Heapsort (int[] datos) {
        int n = datos.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(datos, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = datos[0];
            datos[0] = datos[i];
            datos[i] = temp;
            heapify(datos, i, 0);
        }
        System.out.println("Vector ordenado: " + Arrays.toString(datos));
    }
    void heapify(int[] datos, int n, int i) {
        int mayor = i;
        int izq = 2 * i + 1;
        int der = 2 * i + 2;
        if (izq < n && datos[izq] > datos[mayor]) {
            mayor = izq;
        }
        if (der < n && datos[der] > datos[mayor]) {
            mayor = der;
        }
        if (mayor != i) {
            int swap = datos[i];
            datos[i] = datos[mayor];
            datos[mayor] = swap;
            heapify(datos, n, mayor);
        }
    }
}
