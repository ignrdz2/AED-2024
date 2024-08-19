package com.ut9;

public class TClasificador {
    public int[] clasificar(int[] vector) {
        int[] resultado = new int[vector.length];
        for (int i = 0; i < vector.length; i++) {
            resultado[i] = vector[vector.length - i - 1];
        }
        return resultado;
    }
    public int[] OrdenarPorInsercion(int[] vector) {
        for (int i = 1; i < vector.length; i++) {
            int aux = vector[i];
            int j = i - 1;
            while (j >= 0 && vector[j] > aux) {
                vector[j + 1] = vector[j];
                j--;
            }
            vector[j + 1] = aux;
        }
        return vector;
    }
    public boolean estaOrdenado(int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) {
            if (vector[i] > vector[i + 1]) {
                return false;
            }
        }
        return true;
    }
    public int[] shellSort(int[] vector) {
        int n = vector.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = vector[i];
                int j;
                for (j = i; j >= gap && vector[j - gap] > temp; j -= gap) {
                    vector[j] = vector[j - gap];
                }
                vector[j] = temp;
            }
        }
        return vector;
    }
    public int[] burbuja(int[] vector) {
        int n = vector.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    int temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }
        }
        return vector;
    }
}
