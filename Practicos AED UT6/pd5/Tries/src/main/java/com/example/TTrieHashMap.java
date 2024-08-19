package com.example;

import java.util.List;

public class TTrieHashMap {
    private TNodoTrieHashMap raiz;

    public TTrieHashMap(){
        raiz = new TNodoTrieHashMap();
    }

    public void insertar(String palabra){
        raiz.insertar(palabra);
    }

    public boolean buscar(String palabra){
        return raiz.buscar(palabra);
    }

    public List<String> buscarPrefijo(String prefijo) {
        return raiz.buscarPrefijo(prefijo);
    }

    public List<Integer> buscarPatrones(String texto){
        return raiz.buscarPatrones(texto);
    }
}
