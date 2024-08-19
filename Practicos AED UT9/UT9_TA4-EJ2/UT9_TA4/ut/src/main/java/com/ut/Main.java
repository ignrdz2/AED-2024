package com.ut;


public class Main {
    public static void main(String[] args) {
        TClasificador clasificador = new TClasificador();
        
        // Conjuntos de datos
        int[] vector300Ascendente = generarVectorAscendente(300);
        int[] vector300Descendente = generarVectorDescendente(300);
        int[] vector300Aleatorio = generarVectorAleatorio(300);
        
        int[] vector10000Ascendente = generarVectorAscendente(10000);
        int[] vector10000Descendente = generarVectorDescendente(10000);
        int[] vector10000Aleatorio = generarVectorAleatorio(10000);
        
        // Pruebas con diferentes conjuntos de datos
        realizarPruebas(clasificador, vector300Ascendente, "Vector 300 Ascendente");
        realizarPruebas(clasificador, vector300Descendente, "Vector 300 Descendente");
        realizarPruebas(clasificador, vector300Aleatorio, "Vector 300 Aleatorio");
        
        realizarPruebas(clasificador, vector10000Ascendente, "Vector 10000 Ascendente");
        realizarPruebas(clasificador, vector10000Descendente, "Vector 10000 Descendente");
        realizarPruebas(clasificador, vector10000Aleatorio, "Vector 10000 Aleatorio");
    }
    
    private static int[] generarVectorAscendente(int size) {
        int[] vector = new int[size];
        for (int i = 0; i < size; i++) {
            vector[i] = i;
        }
        return vector;
    }
    
    private static int[] generarVectorDescendente(int size) {
        int[] vector = new int[size];
        for (int i = 0; i < size; i++) {
            vector[i] = size - i;
        }
        return vector;
    }
    
    private static int[] generarVectorAleatorio(int size) {
        int[] vector = new int[size];
        for (int i = 0; i < size; i++) {
            vector[i] = (int) (Math.random() * size);
        }
        return vector;
    }
    
    private static void realizarPruebas(TClasificador clasificador, int[] vector, String tipoVector) {
        System.out.println("Pruebas con " + tipoVector);
        
        long startTime, endTime;
        
        // Prueba con pivote último
        clasificador = new TClasificador();
        startTime = System.nanoTime();
        clasificador.OrdenarPorQuicksort(vector.clone());
        endTime = System.nanoTime();
        System.out.println("Pivote último: " + (endTime - startTime) + " ns. Profundidad: " + clasificador.getProfundidadMaxima());
        
        // Prueba con pivote primero
        clasificador = new TClasificador() {
            @Override
            public int encuentraPivote(int[] arr, int low, int high) {
                return encuentraPivotePrimero(arr, low, high);
            }
        };
        startTime = System.nanoTime();
        clasificador.OrdenarPorQuicksort(vector.clone());
        endTime = System.nanoTime();
        System.out.println("Pivote primero: " + (endTime - startTime) + " ns. Profundidad: " + clasificador.getProfundidadMaxima());
        
        // Prueba con pivote mediana de tres
        clasificador = new TClasificador() {
            @Override
            public int encuentraPivote(int[] arr, int low, int high) {
                return encuentraPivoteMedianaTres(arr, low, high);
            }
        };
        startTime = System.nanoTime();
        clasificador.OrdenarPorQuicksort(vector.clone());
        endTime = System.nanoTime();
        System.out.println("Pivote mediana de tres: " + (endTime - startTime) + " ns. Profundidad: " + clasificador.getProfundidadMaxima());
    }
}
