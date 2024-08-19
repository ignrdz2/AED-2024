package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insertar palabras en el Trie
        trie.insertar("hola");
        trie.insertar("mundo");
        trie.insertar("programacion");
        trie.insertar("java");
        trie.insertar("trie");

        // Listar todas las palabras en el Trie
        List<String> palabras = trie.listarTodasLasPalabras();
        System.out.println("Todas las palabras en el Trie: " + palabras);

        // Buscar palabras en el Trie
        System.out.println("hola ->" + trie.buscar("hola"));
        System.out.println("mundo ->" + trie.buscar("mundo"));
        System.out.println("programacion ->" + trie.buscar("programacion"));
        System.out.println("java ->" + trie.buscar("java"));
        System.out.println("trie ->" + trie.buscar("trie"));
        System.out.println("python ->" + trie.buscar("python"));

        // Medir el tiempo de búsqueda de una palabra en el Trie
        trie.medirTiempoBusqueda("hola");
        trie.medirTiempoBusqueda("mundo");
        trie.medirTiempoBusqueda("programacion");
        trie.medirTiempoBusqueda("java");
        trie.medirTiempoBusqueda("trie");
        trie.medirTiempoBusqueda("python");
    }
}