package com.ut;


public class Main {
    public static void main(String[] args) {
        int tamaño = 10000;  // tamaño del vector
        int tiempoResolucion = 1000000000;  // 1 segundo en nanosegundos
        String tipoOrden = "descendente";  // puede ser "ascendente", "descendente" o "aleatorio"
        
        TClasificador clasificador = new TClasificador();

        // Generar el vector original
        int[] vectorOriginal = generarVector(tamaño, tipoOrden);

        // Medir tiempo de ejecución del algoritmo de ordenación
        long tiempoMedioAlgoritmoBase = medirTiempo(clasificador, vectorOriginal, tiempoResolucion, true);

        // Medir tiempo de las cáscaras
        long tiempoMedioCascara = medirTiempo(clasificador, vectorOriginal, tiempoResolucion, false);

        // Calcular el tiempo medio del algoritmo descontando las cáscaras
        long tiempoMedioAlgoritmo = tiempoMedioAlgoritmoBase - tiempoMedioCascara;

        System.out.println("Tiempo medio del algoritmo: " + tiempoMedioAlgoritmo + " ns");
    }

    public static int[] generarVector(int tamaño, String tipoOrden) {
        int[] vector = new int[tamaño];
        switch (tipoOrden) {
            case "ascendente":
                for (int i = 0; i < tamaño; i++) {
                    vector[i] = i;
                }
                break;
            case "descendente":
                for (int i = 0; i < tamaño; i++) {
                    vector[i] = tamaño - i;
                }
                break;
            case "aleatorio":
                for (int i = 0; i < tamaño; i++) {
                    vector[i] = (int) (Math.random() * tamaño);
                }
                break;
        }
        return vector;
    }

    public static long medirTiempo(TClasificador clasificador, int[] vectorOriginal, int tiempoResolucion, boolean ejecutarAlgoritmo) {
        long t1 = System.nanoTime();
        long total = 0;
        int cantLlamadas = 0;
        while (total < tiempoResolucion) {
            cantLlamadas++;
            int[] datosCopia = vectorOriginal.clone();
            if (ejecutarAlgoritmo) {
                clasificador.OrdenarPorQuicksort(datosCopia);  // Ejecuta el método de ordenación
            }
            long t2 = System.nanoTime();
            total = t2 - t1;
        }
        return total / cantLlamadas;
    }
}

class TClasificador {
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
    public int[] OrdenarPorQuicksort(int[] datosParaClasificar) {
        profundidadMaxima = 0;
        quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1, 1);
        return datosParaClasificar;
    }

    private void quicksort(int[] arr, int low, int high, int profundidadActual) {
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