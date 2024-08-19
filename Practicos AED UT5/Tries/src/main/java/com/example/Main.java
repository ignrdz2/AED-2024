package com.example;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insertar("hola");
        trie.insertar("adios");
        trie.insertar("cabeza");
        trie.insertar("casa");
        trie.insertar("casabo");
        trie.insertar("caso");
        trie.insertar("casita");
        trie.insertar("monografia");
        trie.insertar("automatico");
        trie.insertar("automovil");
        trie.insertar("automovilismo");
        trie.insertar("burguerking"); 

        // Generar archivo .dot con el Trie graficado
        // if(trie.eliminar("cas")) {
        //     System.out.println("Se elimino la palabra");
        // } else {
        //     System.out.println("No se encontro la palabra");
        // }
        // trie.generarDot();

        System.out.println(trie.buscarPalabraOPrefijo("cas"));

        System.out.println(trie.listarTodasLasPalabras());
        System.out.println(trie.buscarPalabrasXpref("ca"));
        
        // System.out.println(trie.buscar("ca"));
        // System.out.println(trie.buscar("casa"));
        // System.out.println(trie.buscar("casab"));
        // System.out.println(trie.buscar("casabo"));
        // System.out.println(" ");
        // System.out.println(trie.buscarPrefijo("ca"));

        // System.out.println(trie.buscarPalabrasXpref("c"));
    }
}