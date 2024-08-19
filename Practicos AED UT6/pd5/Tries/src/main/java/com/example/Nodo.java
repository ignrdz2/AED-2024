package com.example;

public class Nodo {
    private Nodo[] hijos;
    private final int Tam = 26;
    private boolean esFin;

    public Nodo(){
        hijos = new Nodo[Tam];
        esFin = false;
        for(int i = 0; i < Tam; i++){
            hijos[i] = null;
        }
    }

    public void setFin(boolean esFin){
        this.esFin = esFin;
    }
    public boolean esFin(){
        return this.esFin;
    }
    public boolean esHoja(){
        for(Nodo hijo : hijos){
            if(hijo != null){
                return false;
            }
        }
        return true;
    }
    public void setHijo(int pos, Nodo hijo){
        hijos[pos] = hijo;
    }
    public Nodo getHijo(int pos){
        return hijos[pos];
    }
    public boolean contiene(char ch){
        return hijos[ch - 'a'] != null;
    }
    public Nodo get(char ch){
        return hijos[ch - 'a'];
    }
    public void put(char ch, Nodo nodo){
        hijos[ch - 'a'] = nodo;
    }
}
