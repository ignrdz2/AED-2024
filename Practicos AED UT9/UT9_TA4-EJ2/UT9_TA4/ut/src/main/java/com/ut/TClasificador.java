package com.ut;


public class TClasificador {

    public int profundidadMaxima;

    // Método principal de Quicksort
    public int[] OrdenarPorQuicksort(int[] datosParaClasificar) {
        profundidadMaxima = 0;
        quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1, 1);
        return datosParaClasificar;
    }

    // Método recursivo de Quicksort
    public void quicksort(int[] arr, int low, int high, int profundidadActual) {
        if (low < high) {
            int pi = encuentraPivote(arr, low, high);
            if (pi - 1 > low) {
                quicksort(arr, low, pi - 1, profundidadActual + 1);
            }
            if (pi + 1 < high) {
                quicksort(arr, pi + 1, high, profundidadActual + 1);
            }
            profundidadMaxima = Math.max(profundidadMaxima, profundidadActual);
        }
    }

    // Método para encontrar el pivote
    public int encuentraPivote(int[] arr, int low, int high) {
        int pivot = arr[high];  
        int i = (low - 1); 
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Método para verificar si un array está ordenado de forma ascendente
    public boolean estaOrdenado(int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) {
            if (vector[i] > vector[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public int getProfundidadMaxima() {
        return profundidadMaxima;
    }
    public int encuentraPivoteUltimo(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    
    public int encuentraPivotePrimero(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = high + 1;
        for (int j = high; j > low; j--) {
            if (arr[j] >= pivot) {
                i--;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i - 1];
        arr[i - 1] = arr[low];
        arr[low] = temp;
        return i - 1;
    }
    
    public int encuentraPivoteMedianaTres(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int pivot = median(arr, low, mid, high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    
    public int median(int[] arr, int a, int b, int c) {
        if ((arr[a] > arr[b]) != (arr[a] > arr[c])) {
            return arr[a];
        } else if ((arr[b] > arr[a]) != (arr[b] > arr[c])) {
            return arr[b];
        } else {
            return arr[c];
        }
    }
    
}
