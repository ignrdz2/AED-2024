package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TNodoTrieHashMap trie = new TNodoTrieHashMap();

        // Prueba de inserción
        trie.insertar("hola");
        trie.insertar("hombre");
        trie.insertar("hombro");
        trie.insertar("casa");
        trie.insertar("caso");

        // Prueba de búsqueda
        System.out.println(trie.buscar("hola")); // Debería imprimir: true
        System.out.println(trie.buscar("hol")); // Debería imprimir: false
        System.out.println(trie.buscar("casa")); // Debería imprimir: true
        System.out.println(trie.buscar("cas")); // Debería imprimir: false

        // Prueba de búsqueda de prefijo
        List<String> palabrasConPrefijoHo = trie.buscarPrefijo("ho");
        System.out.println(palabrasConPrefijoHo); // Debería imprimir: [hola, hombre, hombro]

        List<String> palabrasConPrefijoCas = trie.buscarPrefijo("cas");
        System.out.println(palabrasConPrefijoCas); // Debería imprimir: [casa, caso]

        List<Integer> posiciones = trie.buscarPatrones("holahombrecasoholacasahombre");
        System.out.println(posiciones); // Debería imprimir: [0, 4, 10, 14, 18]
    }
}