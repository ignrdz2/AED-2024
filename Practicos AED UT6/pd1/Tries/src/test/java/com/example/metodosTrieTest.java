package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class metodosTrieTest {
    private Trie trie;

    @Before
    public void setUp(){
        trie = new Trie();
    }

    @Test
    public void testInsertarYBuscar(){
        trie.insertar("hola");
        assertTrue(trie.buscar("hola"));
        assertFalse(trie.buscar("hol"));
    }

    @Test
    public void testBuscarPalabraOPrefijo(){
        trie.insertar("hola");
        assertTrue(trie.buscarPalabraOPrefijo("hola"));
        assertTrue(trie.buscarPalabraOPrefijo("hol"));
        assertFalse(trie.buscarPalabraOPrefijo("hoz"));
    }

    @Test
    public void testBuscarPrefijo(){
        trie.insertar("hola");
        assertTrue(trie.buscarPrefijo("hol"));
        assertFalse(trie.buscarPrefijo("hoz"));
    }

    @Test
    public void testBuscarPalabrasXpref(){
        trie.insertar("hola");
        trie.insertar("holanda");
        List<String> palabras = trie.buscarPalabrasXpref("hol");
        assertTrue(palabras.contains("hola"));
        assertTrue(palabras.contains("holanda"));
    }

    @Test
    public void testEliminar(){
        trie.insertar("hola");
        assertTrue(trie.buscar("hola"));
        trie.eliminar("hola");
        assertFalse(trie.buscar("hola"));
    }

    @Test
    public void testListarTodasLasPalabras(){
        trie.insertar("hola");
        trie.insertar("chau");
        List<String> palabras = trie.listarTodasLasPalabras();
        assertTrue(palabras.contains("hola"));
        assertTrue(palabras.contains("chau"));
    }
}