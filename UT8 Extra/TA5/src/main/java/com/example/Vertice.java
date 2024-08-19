package com.example;

import java.util.*;

public class Vertice<T> {
    private Comparable etiqueta;
    private LinkedList<Adyacencia> adyacentes;
    private T datos;
    private boolean visitado;

    public Vertice(Comparable etiqueta){
        this.etiqueta = etiqueta;
        adyacentes = new LinkedList<>();
        visitado = false;
    }

    public Comparable getEtiqueta(){
        return this.etiqueta;
    }

    public T getDatos(){
        return this.datos;
    }

    public Vertice getOrigen(){
        return this;
    }

    public LinkedList<Adyacencia> getAdyacentes(){
        return this.adyacentes;
    }

    public void setVisitado(boolean val){
        this.visitado = val;
    }

    public boolean getVisitado(){
        return this.visitado;
    }

    public Adyacencia buscarAdyacencia(Vertice destino){
        if(destino != null) return buscarAdyacencia(destino.getEtiqueta());
        return null;
    }

    private Adyacencia buscarAdyacencia(Comparable destino){
        for(Adyacencia adyacencia : adyacentes){
            if(adyacencia.getDestino().getEtiqueta().compareTo(destino) == 0){
                return adyacencia;
            }
        }
        return null;
    }

    public Double obtenerCostoAdyacencia(Vertice destino){
        Adyacencia ady = buscarAdyacencia(destino);
        if(ady != null) return ady.getCosto();
        return Double.MAX_VALUE;
    }

    public boolean insertarAdyacencia(Double costo, Vertice destino){
        if(buscarAdyacencia(destino) == null){
            Adyacencia ady = new Adyacencia(costo, destino);
            return adyacentes.add(ady);
        }
        return false;
    }

    public boolean eliminarAdyacencia(Comparable destino){
        Adyacencia ady = buscarAdyacencia(destino);
        if(ady != null){
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    public Vertice primerAdyacente(){
        if(this.adyacentes.getFirst() != null) return this.adyacentes.getFirst().getDestino();
        return null;
    }

    public Vertice siguienteAdyacente(Vertice w){
        Adyacencia ady = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(ady);
        if(index + 1 < adyacentes.size()){
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }


    public int numBacon() {
        Map<Vertice, Integer> distancias = new HashMap<>();
        Queue<Vertice> cola = new LinkedList<>();
        distancias.put(this, 0);
        cola.add(this);

        while (!cola.isEmpty()) {
            Vertice actual = cola.poll();
            int distanciaActual = distancias.get(actual);

            for (Object obj : actual.getAdyacentes()) {
                if (obj instanceof Adyacencia) {
                    Adyacencia adyacencia = (Adyacencia) obj;
                Vertice vecino = adyacencia.getDestino();
                if (!distancias.containsKey(vecino)) {
                    distancias.put(vecino, distanciaActual + 1);
                    cola.add(vecino);
                    if (vecino.getEtiqueta().equals("Kevin_Bacon")) {
                        return distanciaActual + 1;
                    }
                }
            }
            }
        }
        return -1; // Kevin Bacon no es alcanzable desde este vértice
    }
}