package com.example;

import java.util.*;

public class GrafoNoDirigido {
    private Map<Comparable, Vertice> vertices;
    private LinkedList<Integer>[] adj;
    private Integer[][] predecesores;

    public GrafoNoDirigido(Collection<Vertice> vertices, Collection<Arista> aristas) {
        this.vertices = new HashMap<>();
        for (Vertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (Arista arista : aristas) {
            insertarArista(arista);
        }
    }

    public Map<Comparable, Vertice> getVertices(){
        return this.vertices;
    }

    public void insertarVertice(Comparable etiqueta) {
        vertices.put(etiqueta, new Vertice<>(etiqueta));
    }

    public void insertarArista(Arista arista) {
        Vertice origen = vertices.get(arista.getOrigen());
        Vertice destino = vertices.get(arista.getDestino());
        if (origen != null && destino != null) {
            origen.insertarAdyacencia(arista.getCosto(), destino);
            destino.insertarAdyacencia(arista.getCosto(), origen); // Agregar arista en la dirección opuesta
        }
    }

    public int numBacon(String actor) {
        Vertice verticeOrigen = vertices.get(actor);
        Vertice verticeKevinBacon = vertices.get("Kevin_Bacon");
        if (verticeOrigen == null || verticeKevinBacon == null) {
            return -1; // Actores no encontrados en el grafo
        }
        return verticeOrigen.numBacon();
    }

    // Otros métodos del grafo
}
