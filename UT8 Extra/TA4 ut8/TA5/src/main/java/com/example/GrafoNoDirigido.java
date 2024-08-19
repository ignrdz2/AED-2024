package com.example;

import java.util.*;

public class GrafoNoDirigido {
    private Map<Comparable, Vertice> vertices;
    private LinkedList<Integer>[] adj;
    private Integer[][] predecesores;
    private int time = 0;
    private Set<Comparable> articulationPoints = new HashSet<>();

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

    public LinkedList<Vertice> puntosArticulacion(Comparable etOrigen) {
        time = 0;
        articulationPoints.clear();
        Map<Comparable, Integer> visitedTimes = new HashMap<>();
        Map<Comparable, Integer> lowTimes = new HashMap<>();
        Map<Comparable, Comparable> parents = new HashMap<>();
        LinkedList<Vertice> result = new LinkedList<>();
    
        Vertice origen = vertices.get(etOrigen);
        if (origen != null) {
            buscarPuntosArticulacion(origen, visitedTimes, lowTimes, parents);
            for (Comparable etiqueta : articulationPoints) {
                result.add(vertices.get(etiqueta));
            }
        }
    
        return result;
    }

    private void buscarPuntosArticulacion(Vertice vertice, Map<Comparable, Integer> visitedTimes, Map<Comparable, Integer> lowTimes, Map<Comparable, Comparable> parents) {
        visitedTimes.put(vertice.getEtiqueta(), time);
        lowTimes.put(vertice.getEtiqueta(), time);
        time++;
        int childCount = 0;
        boolean isArticulationPoint = false;

        for (Object obj : vertice.getAdyacentes()) {
            if (obj instanceof Adyacencia) {
                Adyacencia adyacencia = (Adyacencia) obj;
                Vertice child = adyacencia.getDestino();

                if (!visitedTimes.containsKey(child.getEtiqueta())) {
                    parents.put(child.getEtiqueta(), vertice.getEtiqueta());
                    childCount++;
                    buscarPuntosArticulacion(child, visitedTimes, lowTimes, parents);

                    if (visitedTimes.get(vertice.getEtiqueta()) <= lowTimes.get(child.getEtiqueta())) {
                        isArticulationPoint = true;
                    } else {
                        lowTimes.put(vertice.getEtiqueta(), Math.min(lowTimes.get(vertice.getEtiqueta()), lowTimes.get(child.getEtiqueta())));
                    }
                } else if (!child.getEtiqueta().equals(parents.get(vertice.getEtiqueta()))) {
                    lowTimes.put(vertice.getEtiqueta(), Math.min(lowTimes.get(vertice.getEtiqueta()), visitedTimes.get(child.getEtiqueta())));
                }
            }
        }
        if ((parents.get(vertice.getEtiqueta()) == null && childCount >= 2) || parents.get(vertice.getEtiqueta()) != null && isArticulationPoint) {
            articulationPoints.add(vertice.getEtiqueta());
        }
    }
}
