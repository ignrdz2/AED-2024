package com.example;

public class TClasificador {
    public static final int METODO_CLASIFICACION_QUICKSORT = 4;
    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_SHELLSORT = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;
    private int maxProfundidad = 0;

    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_QUICKSORT:
                maxProfundidad = 0;
                return ordenarPorQuickSort(datosParaClasificar);
            case METODO_CLASIFICACION_INSERCION:
                return ordenarPorInsercion(datosParaClasificar);
            case METODO_CLASIFICACION_SHELLSORT:
                return ordenarPorShellsort(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                return ordenarPorBurbuja(datosParaClasificar);
            default:
                System.err.println("Este codigo no deberia haberse ejecutado");
                break;
        }
        return datosParaClasificar;
    }

    private int[] ordenarPorInsercion(int[] datosParaClasificar) {
        int n = datosParaClasificar.length;
        for (int i = 1; i < n; ++i) {
            int key = datosParaClasificar[i];
            int j = i - 1;
            while (j >= 0 && datosParaClasificar[j] > key) {
                datosParaClasificar[j + 1] = datosParaClasificar[j];
                j = j - 1;
            }
            datosParaClasificar[j + 1] = key;
        }
        return datosParaClasificar;
    }

    private int[] ordenarPorShellsort(int[] datosParaClasificar) {
        int n = datosParaClasificar.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = datosParaClasificar[i];
                int j;
                for (j = i; j >= gap && datosParaClasificar[j - gap] > temp; j -= gap) {
                    datosParaClasificar[j] = datosParaClasificar[j - gap];
                }
                datosParaClasificar[j] = temp;
            }
        }
        return datosParaClasificar;
    }

    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        int n = datosParaClasificar.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (datosParaClasificar[j] > datosParaClasificar[j + 1]) {
                    int temp = datosParaClasificar[j];
                    datosParaClasificar[j] = datosParaClasificar[j + 1];
                    datosParaClasificar[j + 1] = temp;
                }
            }
        }
        return datosParaClasificar;
    }

    protected int[] ordenarPorQuickSort(int[] datosParaClasificar) {
        quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1, 1);
        System.out.println("Maxima profundidad de llamada recursiva: " + maxProfundidad);
        return datosParaClasificar;
    }

    private void quicksort(int[] entrada, int i, int j, int profundidad) {
        if (i < j) {
            maxProfundidad = Math.max(maxProfundidad, profundidad);
            int posicionPivote = encuentraPivoteCentral(i, j); 
            int pivote = entrada[posicionPivote];
            int izquierda = i;
            int derecha = j;

            while (izquierda <= derecha) {
                while (entrada[izquierda] < pivote) {
                    izquierda++;
                }
                while (entrada[derecha] > pivote) {
                    derecha--;
                }
                if (izquierda <= derecha) {
                    intercambiar(entrada, izquierda, derecha);
                    izquierda++;
                    derecha--;
                }
            }

            if (i < derecha) quicksort(entrada, i, derecha, profundidad + 1);
            if (izquierda < j) quicksort(entrada, izquierda, j, profundidad + 1);
        }
    }

    private void intercambiar(int[] entrada, int i, int j) {
        int temp = entrada[i];
        entrada[i] = entrada[j];
        entrada[j] = temp;
    }

    // Implementaciones de diferentes estrategias de pivote
    private int encuentraPivoteCentral(int i, int j) {
        return (i + j) / 2;
    }

    private int encuentraPivotePrimero(int i, int j) {
        return i;
    }

    private int encuentraPivoteUltimo(int i, int j) {
        return j;
    }

    // Método para verificar que un array está ordenado
    public boolean estaOrdenado(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
