package org.example;

import java.util.*;

class Grafo {
    private int cantidadNodos;
    private int[][] matrizCostos;

    public Grafo(int cantidadNodos) {
        this.cantidadNodos = cantidadNodos;
        matrizCostos = new int[cantidadNodos][cantidadNodos];
        for (int i = 0; i < cantidadNodos; i++) {
            Arrays.fill(matrizCostos[i], Integer.MAX_VALUE);
        }
    }

    public void agregarArista(int nodo1, int nodo2, int costo) {
        matrizCostos[nodo1][nodo2] = costo;
        matrizCostos[nodo2][nodo1] = costo; // Para grafos no dirigidos
    }

    public int obtenerCosto(int nodo1, int nodo2) {
        return matrizCostos[nodo1][nodo2];
    }

    public List<Integer> obtenerVecinos(int nodo) {
        List<Integer> vecinos = new ArrayList<>();
        for (int i = 0; i < cantidadNodos; i++) {
            if (matrizCostos[nodo][i] != Integer.MAX_VALUE && i != nodo) {
                vecinos.add(i);
            }
        }
        return vecinos;
    }

    public int obtenerCantidadNodos() {
        return cantidadNodos;
    }
}



