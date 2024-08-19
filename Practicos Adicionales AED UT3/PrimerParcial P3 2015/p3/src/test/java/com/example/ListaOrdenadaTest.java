package com.example;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class ListaOrdenadaTest {

    @Test
    public void testMezclar() {
        // Crear las listas ordenadas
        ListaOrdenada<Integer> unaListaOrdenada = new ListaOrdenada<>();
        ListaOrdenada<Integer> otraListaOrdenada = new ListaOrdenada<>();

        // Insertar elementos en las listas
        unaListaOrdenada.insertarOrdenado(1);
        unaListaOrdenada.insertarOrdenado(2);
        unaListaOrdenada.insertarOrdenado(4);
        unaListaOrdenada.insertarOrdenado(5);
        unaListaOrdenada.insertarOrdenado(8);
        unaListaOrdenada.insertarOrdenado(9);

        otraListaOrdenada.insertarOrdenado(2);
        otraListaOrdenada.insertarOrdenado(3);
        otraListaOrdenada.insertarOrdenado(6);
        otraListaOrdenada.insertarOrdenado(7);

        // Realizar la mezcla de las listas
        IListaOrdenada<Integer> resultadoListaOrdenada = unaListaOrdenada.mezclar(otraListaOrdenada);

        // Verificar el contenido de la lista resultante
        Integer[] expected = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] actual = new Integer[expected.length];

        INodo<Integer> nodoActual = resultadoListaOrdenada.getPrimero();
        int i = 0;
        while (nodoActual != null) {
            actual[i++] = nodoActual.getDato();
            nodoActual = nodoActual.getSiguiente();
        }

        assertArrayEquals(expected, actual);
    }
}
