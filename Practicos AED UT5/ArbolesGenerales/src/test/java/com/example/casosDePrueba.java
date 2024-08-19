package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class casosDePrueba {
    @Test
    void testBuscar() {
        Arbol arbol = new Arbol();
        Nodo nodo1 = new Nodo(1);
        Nodo nodo2 = new Nodo(2);
        Nodo nodo3 = new Nodo(3);
        nodo1.setHijo(nodo2);
        nodo2.setHermano(nodo3);
        arbol.setRaiz(nodo1);

        assertEquals(nodo2, arbol.buscar(2));
        assertNull(arbol.buscar(4));
    }

    @Test
    void testAltura() {
        Arbol arbol = new Arbol();
        Nodo nodo1 = new Nodo(1);
        Nodo nodo2 = new Nodo(2);
        Nodo nodo3 = new Nodo(3);
        nodo1.setHijo(nodo2);
        nodo2.setHijo(nodo3);
        arbol.setRaiz(nodo1);

        assertEquals(2, arbol.altura(1));
        assertEquals(1, arbol.altura(2));
        assertEquals(0, arbol.altura(3));
        assertEquals(-1, arbol.altura(4));
    }

    @Test
    void testContarHojas() {
        Arbol arbol = new Arbol();
        Nodo nodo1 = new Nodo(1);
        Nodo nodo2 = new Nodo(2);
        Nodo nodo3 = new Nodo(3);
        nodo1.setHijo(nodo2);
        nodo2.setHermano(nodo3);
        arbol.setRaiz(nodo1);

        assertEquals(2, arbol.contarHojas());
    }

    @Test
    void testNivel() {
        Arbol arbol = new Arbol();
        Nodo nodo1 = new Nodo(1);
        Nodo nodo2 = new Nodo(2);
        Nodo nodo3 = new Nodo(3);
        nodo1.setHijo(nodo2);
        nodo2.setHijo(nodo3);
        arbol.setRaiz(nodo1);

        assertEquals(0, arbol.nivel(1));
        assertEquals(1, arbol.nivel(2));
        assertEquals(2, arbol.nivel(3));
        assertEquals(-1, arbol.nivel(4));
    }

    @Test
    void testInsertarHijo() {
        Arbol arbol = new Arbol();
        Nodo nodo1 = new Nodo(1);
        Nodo nodo2 = new Nodo(2);
        arbol.insertarHijo(1, nodo2);

        assertEquals(nodo2, arbol.buscar(2));
        assertEquals(nodo1, nodo2.getPadre());
    }

    @Test
    void testInsertarHermano() {
        Arbol arbol = new Arbol();
        Nodo nodo1 = new Nodo(1);
        Nodo nodo2 = new Nodo(2);
        Nodo nodo3 = new Nodo(3);
        arbol.insertarHijo(1, nodo2);
        arbol.insertarHermano(2, nodo3);

        assertEquals(nodo3, arbol.buscar(3));
        assertEquals(nodo1, nodo3.getPadre());
    }

    @Test
    void testEliminarNodo() {
        Arbol arbol = new Arbol();
        //Nodo nodo1 = new Nodo(1);
        Nodo nodo2 = new Nodo(2);
        Nodo nodo3 = new Nodo(3);
        arbol.insertarHijo(1, nodo2);
        arbol.insertarHermano(2, nodo3);
        arbol.eliminarNodo(2);

        assertNull(arbol.buscar(2));
        assertEquals(nodo3, arbol.buscar(3));
    }
}