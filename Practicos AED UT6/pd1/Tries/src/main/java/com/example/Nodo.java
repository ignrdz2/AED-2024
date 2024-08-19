package com.example;

import java.util.HashMap;

public class Nodo {
    private HashMap<Character, Nodo> hijos;
    private boolean esFin;

    public Nodo(){
        hijos = new HashMap<>();
        esFin = false;
    }

    public void setFin(boolean esFin){
        this.esFin = esFin;
    }

    public boolean esFin(){
        return this.esFin;
    }

    public boolean esHoja(){
        return hijos.isEmpty();
    }

    public void setHijo(char ch, Nodo hijo){
        hijos.put(ch, hijo);
    }

    public Nodo getHijo(char ch){
        return hijos.get(ch);
    }

    public boolean contiene(char ch){
        return hijos.containsKey(ch);
    }

    public Nodo get(char ch){
        return hijos.get(ch);
    }

    public void put(char ch, Nodo nodo){
        hijos.put(ch, nodo);
    }
}