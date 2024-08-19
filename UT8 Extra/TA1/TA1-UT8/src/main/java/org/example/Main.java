package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(6);
        grafo.agregarArista(0, 1, 3);
        grafo.agregarArista(0, 2, 5);
        grafo.agregarArista(0, 3, 1);
        grafo.agregarArista(0, 4, 7);
        grafo.agregarArista(0, 5, 2);
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(1, 3, 3);
        grafo.agregarArista(1, 4, 5);
        grafo.agregarArista(1, 5, 6);
        grafo.agregarArista(2, 3, 2);
        grafo.agregarArista(2, 4, 3);
        grafo.agregarArista(2, 5, 5);
        grafo.agregarArista(3, 4, 7);
        grafo.agregarArista(3, 5, 1);
        grafo.agregarArista(4, 5, 4);

        List<int[]> mst = Prim.prim(grafo, 0);
        int costoTotal = 0;

        System.out.println("Nodos conectados en el Árbol de Expansión Mínima:");
        for (int[] arista : mst) {
            System.out.println("Nodo " + arista[0] + " - Nodo " + (arista[0]+1) + " (Costo: " + arista[1] + ")");
            costoTotal += arista[1];
        }

        System.out.println("Costo total del Árbol de Expansión Mínima: " + costoTotal);

    }
}
