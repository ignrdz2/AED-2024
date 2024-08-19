package com.ut;
public class TClasificador {
    private int profundidadMaxima;
    public int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        for (int i = 0; i < datosParaClasificar.length - 1; i++) {
            for (int j = 0; j < datosParaClasificar.length - i - 1; j++) {
                if (datosParaClasificar[j] > datosParaClasificar[j + 1]) {
                    int temp = datosParaClasificar[j];
                    datosParaClasificar[j] = datosParaClasificar[j + 1];
                    datosParaClasificar[j + 1] = temp;
                }
            }
        }
        return datosParaClasificar;
    }
    public int[]ordenarPorHeapSort(int[] datosParaClasificar) {
        int n = datosParaClasificar.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(datosParaClasificar, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = datosParaClasificar[0];
            datosParaClasificar[0] = datosParaClasificar[i];
            datosParaClasificar[i] = temp;
            heapify(datosParaClasificar, i, 0);
        }
        return datosParaClasificar;
    }
    private void heapify(int[] arr, int n, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[max]) {
            max = left;
        }
        if (right < n && arr[right] > arr[max]) {
            max = right;
        }
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr, n, max);
        }
    }
    public int[]ordenarPorSeleccion(int[] datosParaClasificar) {
        for (int i = 0; i < datosParaClasificar.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < datosParaClasificar.length; j++) {
                if (datosParaClasificar[j] < datosParaClasificar[min]) {
                    min = j;
                }
            }
            int temp = datosParaClasificar[min];
            datosParaClasificar[min] = datosParaClasificar[i];
            datosParaClasificar[i] = temp;
        }
        return datosParaClasificar;
    }
    public int OrdenarPorQuicksort(int[] datosParaClasificar) {
        int n = datosParaClasificar.length;
        profundidadMaxima = 0;
        quickSort(datosParaClasificar, 0, n - 1);
        return profundidadMaxima;
    }
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = encuentraPivote(arr, low, high);
            if (pi - 1 - low > profundidadMaxima) {
                profundidadMaxima = pi - 1 - low;
            }
            if (high - pi - 1 > profundidadMaxima) {
                profundidadMaxima = high - pi - 1;
            }
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int encuentraPivote(int[] arr, int low, int high) {
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
}