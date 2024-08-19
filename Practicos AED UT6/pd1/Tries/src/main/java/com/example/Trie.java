package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Trie {
    private Nodo raiz;
    private AtomicInteger nodoId;

    public Trie(){
        raiz = new Nodo();
        nodoId = new AtomicInteger();
    }

    public List<String> listarTodasLasPalabras() {
        List<String> palabras = new ArrayList<>();
        listarTodasLasPalabras(raiz, new StringBuilder(), palabras);
        return palabras;
    }
    
    private void listarTodasLasPalabras(Nodo nodo, StringBuilder prefijo, List<String> palabras) {
        if (nodo.esFin()) {
            palabras.add(prefijo.toString());
        }
        if (nodo.esHoja()) {
            return;
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (nodo.contiene(ch)) {
                prefijo.append(ch);
                listarTodasLasPalabras(nodo.get(ch), prefijo, palabras);
                prefijo.deleteCharAt(prefijo.length() - 1);
            }
        }
    }

    public boolean buscar(String palabra) {
        Nodo nodo = raiz;
        for (int i = 0; i < palabra.length(); i++) {
            char ch = palabra.charAt(i);
            if (!nodo.contiene(ch)) {
                return false; // La palabra no está en el Trie.
            }
            nodo = nodo.get(ch);
        }
        return nodo.esFin(); // La secuencia de caracteres está en el Trie.
    }

    public boolean buscarPalabraOPrefijo(String cadena) {
        Nodo nodo = raiz;
        for (int i = 0; i < cadena.length(); i++) {
            char ch = cadena.charAt(i);
            if (!nodo.contiene(ch)) {
                return false; // La cadena no está en el Trie.
            }
            nodo = nodo.get(ch);
        }
        // La cadena está en el Trie y puede ser una palabra completa o un prefijo.
        return true;
    }

    public boolean buscarPrefijo(String prefijo) {
        Nodo nodo = raiz;
        for (int i = 0; i < prefijo.length(); i++) {
            char ch = prefijo.charAt(i);
            if (!nodo.contiene(ch)) {
                return false; // El prefijo no está en el Trie.
            }
            nodo = nodo.get(ch);
        }
        // Verifica si el prefijo es también una palabra completa y no tiene hijos.
        if (nodo.esFin() && nodo.esHoja()) {
            return false;
        }
        return true; // El prefijo está en el Trie y no es una palabra completa o tiene hijos.
    }
    
    public List<String> buscarPalabrasXpref(String prefijo){
        List<String> palabras = new ArrayList<>();
        Nodo nodo = raiz;
        for(int i = 0; i < prefijo.length(); i++){
            char ch = prefijo.charAt(i);
            if(!nodo.contiene(ch)){
                return palabras;
            }
            nodo = nodo.get(ch);
        }
        buscarPalabrasXpref(nodo, new StringBuilder(prefijo), palabras);
        return palabras;
    }
    private void buscarPalabrasXpref(Nodo nodo, StringBuilder prefijo, List<String> palabras){
        if(nodo.esFin()){
            palabras.add(prefijo.toString());
        }
        if(nodo.esHoja()){
            return;
        }
        for(char ch = 'a'; ch <= 'z'; ch++){
            if(nodo.contiene(ch)){
                prefijo.append(ch);
                buscarPalabrasXpref(nodo.get(ch), prefijo, palabras);
                prefijo.deleteCharAt(prefijo.length() - 1);
            }
        }
    }

    public void insertar(String palabra){
        Nodo actual = raiz;
        for(int i = 0; i < palabra.length(); i++){
            char ch = palabra.charAt(i);
            if(!actual.contiene(ch)){
                actual.put(ch, new Nodo());
            }
            actual = actual.get(ch);
        }
        actual.setFin(true);
    }
    
    public boolean eliminar(String palabra) {
        boolean[] palabraEliminada = new boolean[1]; // Array para almacenar el resultado
        eliminar(raiz, palabra, 0, palabraEliminada);
        return palabraEliminada[0];
    }
    
    private boolean eliminar(Nodo nodo, String palabra, int index, boolean[] palabraEliminada) {
        if (index == palabra.length()) {
            // Cuando se ha encontrado el final de la palabra
            if (!nodo.esFin()) {
                return false;
            }
            nodo.setFin(false);
            palabraEliminada[0] = true; // Se ha eliminado una palabra
            // Si el nodo no tiene hijos, entonces se puede eliminar
            return nodo.esHoja();
        }
        char ch = palabra.charAt(index);
        Nodo temp = nodo.get(ch);
        if (temp == null) {
            return false;
        }
        boolean debeEliminarNodoActual = eliminar(temp, palabra, index + 1, palabraEliminada) && !temp.esFin();
    
        // Si el hijo debe ser eliminado
        if (debeEliminarNodoActual) {
            nodo.setHijo(ch, null);
            // Si el nodo no tiene hijos, entonces se puede eliminar
            return nodo.esHoja();
        }
        return false;
    }

    public void medirTiempoBusqueda(String palabra){
        long inicio = System.nanoTime();
        buscar(palabra);
        long fin = System.nanoTime();
        System.out.println("Tiempo de ejecución: " + (fin - inicio) + " nanosegundos");
    }

    // Metodos para graficar el Trie en un archivo externo .dot
    public void generarDot() {
        try (PrintWriter out = new PrintWriter(new FileWriter("trie.dot"))) {
            out.println("digraph Trie {");
            out.println("\"node" + nodoId.get() + "\" [label=\"root\", shape=box];");
            generarDot(raiz, out, "node" + nodoId.getAndIncrement());
            out.println("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void generarDot(Nodo nodo, PrintWriter out, String nombreNodo) {
        if (nodo != null) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (nodo.contiene(ch)) {
                    Nodo hijo = nodo.get(ch);
                    String nombreHijo = "node" + nodoId.getAndIncrement();
                    String nodoConfig = hijo.esFin() ? "[label=\"" + ch + "\", shape=doublecircle, color=red]" : "[label=\"" + ch + "\"]";
                    out.println("\"" + nombreHijo + "\" " + nodoConfig + ";");
                    out.println("\"" + nombreNodo + "\" -> \"" + nombreHijo + "\";");
                    generarDot(hijo, out, nombreHijo);
                }
            }
        }
    }

    
}
