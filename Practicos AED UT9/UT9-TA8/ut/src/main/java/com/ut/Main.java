package com.ut;


public class Main {
    public static void main(String[] args) {
        int tamaño = 3000;  // tamaño del vector
        int tiempoResolucion = 1000000000;  // 1 segundo en nanosegundos
        String tipoOrden = "ascendente";  // puede ser "ascendente", "descendente" o "aleatorio"
        
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
                // clasificador.ordenarPorBurbuja(datosCopia);  // Ejecuta el método de ordenación
                // clasificador.ordenarPorSeleccion(datosCopia);  // Ejecuta el método de ordenación
                // clasificador.ordenarPorHeapSort(datosCopia);  // Ejecuta el método de ordenación
            }
            long t2 = System.nanoTime();
            total = t2 - t1;
        }
        return total / cantLlamadas;
    }
}

