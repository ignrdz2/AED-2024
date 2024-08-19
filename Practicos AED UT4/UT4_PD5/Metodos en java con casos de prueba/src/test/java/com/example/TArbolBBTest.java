package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TArbolBBTest {

    @Test
    public void testBuscarMin() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(50, 50);
        arbol.insertar(30, 30);
        arbol.insertar(70, 70);
        assertEquals(30, (int) arbol.buscarMin());
    }

    @Test
    public void testBuscarMax() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(50, 50);
        arbol.insertar(30, 30);
        arbol.insertar(70, 70);
        assertEquals(70, (int) arbol.buscarMax());
    }

    @Test
    public void testBuscarPredecesor() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(50, 50);
        arbol.insertar(30, 30);
        arbol.insertar(70, 70);
        assertEquals(50, (int) arbol.buscarPredecesor(70));
    }

    @Test
    public void testContarNodosNivel() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(50, 50);
        arbol.insertar(30, 30);
        arbol.insertar(70, 70);
        assertEquals(2, arbol.contarNodosNivel(2));
    }

    @Test
    public void testEsABB() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(50, 50);
        arbol.insertar(30, 30);
        arbol.insertar(70, 70);
        assertTrue(arbol.esABB());
    }
}