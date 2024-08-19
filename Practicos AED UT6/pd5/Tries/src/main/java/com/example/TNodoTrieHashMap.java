package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class TNodoTrieHashMap {
    private HashMap<Character, TNodoTrieHashMap> hijos;
    private boolean esFin;

    public TNodoTrieHashMap(){
        hijos = new HashMap<>();
        esFin = false;
    }

    public void insertar(String palabra){
        TNodoTrieHashMap nodoActual = this;
        for(char ch : palabra.toCharArray()){
            nodoActual.hijos.putIfAbsent(ch, new TNodoTrieHashMap());
            nodoActual = nodoActual.hijos.get(ch);
        }
        nodoActual.esFin = true;
    }

    public boolean buscar(String palabra){
        TNodoTrieHashMap nodoActual = this;
        for(char ch : palabra.toCharArray()){
            nodoActual = nodoActual.hijos.get(ch);
            if(nodoActual == null) return false;
        }
        return true;
    }

    public List<String> buscarPrefijo(String prefijo){
        TNodoTrieHashMap nodoActual = this;
        for(char ch : prefijo.toCharArray()){
            nodoActual = nodoActual.hijos.get(ch);
            if(nodoActual == null) return new ArrayList<>();
        }
        return nodoActual.buscarPalabrasConPrefijo(new StringBuilder(prefijo));
    }

    private List<String> buscarPalabrasConPrefijo(StringBuilder prefijo){
        List<String> palabras = new ArrayList<>();
        if(esFin) palabras.add(prefijo.toString());
        for(char ch : hijos.keySet()){
            prefijo.append(ch);
            palabras.addAll(hijos.get(ch).buscarPalabrasConPrefijo(prefijo));
            prefijo.deleteCharAt(prefijo.length() - 1);
        }
        return palabras;
    }

    public List<Integer> buscarPatrones(String texto) {
        List<Integer> posiciones = new ArrayList<>();
        for (int i = 0; i < texto.length(); i++) {
            TNodoTrieHashMap nodoActual = this;
            for (int j = i; j < texto.length(); j++) {
                nodoActual = nodoActual.hijos.get(texto.charAt(j));
                if (nodoActual == null) break;
                if (nodoActual.esFin) posiciones.add(i);
            }
        }
        return posiciones;
    }
}
