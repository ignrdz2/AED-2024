package org.example;

public class TClasificador {
    public int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) {
            armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        for (int i = datosParaClasificar.length - 1; i > 0; i--) {
            intercambiar(datosParaClasificar, 0, i);
            armaHeap(datosParaClasificar, 0, i - 1);
        }
        return datosParaClasificar;
    }

    private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
        int r = primero;
        while (r <= (ultimo - 1) / 2) {
            int hijoIzq = 2 * r + 1;
            int hijoDer = 2 * r + 2;
            int max = r;
            if (hijoIzq <= ultimo && datosParaClasificar[hijoIzq] > datosParaClasificar[max]) {
                max = hijoIzq;
            }
            if (hijoDer <= ultimo && datosParaClasificar[hijoDer] > datosParaClasificar[max]) {
                max = hijoDer;
            }
            if (max == r) {
                break;
            }
            intercambiar(datosParaClasificar, r, max);
            r = max;
        }
    }

    private void intercambiar(int[] datosParaClasificar, int i, int j) {
        int temp = datosParaClasificar[i];
        datosParaClasificar[i] = datosParaClasificar[j];
        datosParaClasificar[j] = temp;
    }
}

