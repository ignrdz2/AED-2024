package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Prim {
    public static List<int[]> prim(Grafo grafo, int nodoInicial) {
        int cantidadNodos = grafo.obtenerCantidadNodos();
        List<int[]> arbolExpansion = new ArrayList<>();
        List<int[]> costoMinimo = new ArrayList<>();
        boolean[] enArbol = new boolean[cantidadNodos];

        enArbol[nodoInicial] = true;

        for (int nodo = 0; nodo < cantidadNodos; nodo++) {
            if (nodo != nodoInicial) {
                costoMinimo.add(new int[]{nodo, grafo.obtenerCosto(nodoInicial, nodo)});
            }
        }

        while (arbolExpansion.size() < cantidadNodos - 1) {
            // Encontrar el costo mínimo
            int[] minArista = costoMinimo.stream()
                    .filter(arista -> !enArbol[arista[0]])
                    .min(Comparator.comparingInt(arista -> arista[1]))
                    .orElseThrow();

            int nodoActual = minArista[0];
            int costoActual = minArista[1];

            if (!enArbol[nodoActual]) {
                arbolExpansion.add(minArista);
                enArbol[nodoActual] = true;

                for (int vecino : grafo.obtenerVecinos(nodoActual)) {
                    if (!enArbol[vecino] && grafo.obtenerCosto(nodoActual, vecino) < obtenerCosto(costoMinimo, vecino)) {
                        actualizarCostoMinimo(costoMinimo, vecino, grafo.obtenerCosto(nodoActual, vecino));
                    }
                }
            }
        }

        return arbolExpansion;
    }

    private static int obtenerCosto(List<int[]> costoMinimo, int nodo) {
        return costoMinimo.stream()
                .filter(arista -> arista[0] == nodo)
                .mapToInt(arista -> arista[1])
                .findFirst()
                .orElse(Integer.MAX_VALUE);
    }

    private static void actualizarCostoMinimo(List<int[]> costoMinimo, int nodo, int nuevoCosto) {
        for (int[] arista : costoMinimo) {
            if (arista[0] == nodo) {
                arista[1] = nuevoCosto;
                return;
            }
        }
    }
}
