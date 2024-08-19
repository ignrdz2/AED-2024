package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public void todosLosCaminos(Comparable etVertDest, Camino caminoPrevio, Caminos losCaminos) {
        if (etiqueta.equals(etVertDest)) {
            losCaminos.caminos.add(caminoPrevio);
        } else {
            for (Adyacencia adyacencia : adyacentes) {
                Vertice adyacente = adyacencia.getDestino();
                if (!caminoPrevio.vertices.contains(adyacente)) {
                    Camino nuevoCamino = new Camino();
                    nuevoCamino.vertices = new ArrayList<>(caminoPrevio.vertices);
                    nuevoCamino.vertices.add(adyacente);
                    adyacente.todosLosCaminos(etVertDest, nuevoCamino, losCaminos);
                }
            }
        }
    }

    public String toString(){
        return etiqueta.toString();
    }

    public void ClasificarArcos(List<Arista> ArcosArbol, List<Arista> ArcosRetroceso, List<Arista> ArcosAvance, List<Arista> ArcosCruzados) {
        for (Adyacencia adyacencia : this.getAdyacentes()) {
            Vertice vecino = adyacencia.getDestino();
            Arista arista = new Arista(this.getEtiqueta(), vecino.getEtiqueta(), adyacencia.getCosto());
    
            if (ArcosArbol.contains(arista)) {
                System.out.println("Arco de árbol: " + arista);
            } else if (ArcosRetroceso.contains(arista)) {
                System.out.println("Arco de retroceso: " + arista);
            } else if (ArcosAvance.contains(arista)) {
                System.out.println("Arco de avance: " + arista);
            } else if (ArcosCruzados.contains(arista)) {
                System.out.println("Arco cruzado: " + arista);
            }
        }
    }
}
