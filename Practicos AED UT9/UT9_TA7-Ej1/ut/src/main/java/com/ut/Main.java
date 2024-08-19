package com.ut;

public class Main {
    public static void main(String[] args) {
        String[] datos = {"5T", "0C", "5U", "0O", "9!", "1N", "8S", "2R", "6A", "4A", "1G", "5L", "6T", "6I", "7O", "7N"};
        TClasificador clasificador = new TClasificador();
        clasificador.ordenarPorCuentaDistribucion(datos, 10);
        int[] datos2 = {5, 0, 5, 0, 9, 1, 8, 2, 6, 4, 1, 5, 6, 6, 7, 7};
        clasificador.Heapsort(datos2);
        
    }
}