package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TestOrdenaParesImpares {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.agregar(4);
        lista.agregar(71);
        lista.agregar(3);
        lista.agregar(6);
        lista.agregar(12);
        lista.agregar(8);
        lista.agregar(35);
        lista.agregar(11);
        lista.agregar(22);
        lista.agregar(17);

        Lista listaOrdenada = lista.ordenaParesImpares();

        // Comprobar que los números impares están al principio y ordenados
        Nodo nodoActual = listaOrdenada.primero;
        while (nodoActual.valor % 2 != 0 && nodoActual.siguiente != null) {
            assert nodoActual.valor <= nodoActual.siguiente.valor;
            nodoActual = nodoActual.siguiente;
        }

        // Comprobar que los números pares están después y ordenados
        while (nodoActual.siguiente != null) {
            assert nodoActual.valor % 2 == 0;
            assert nodoActual.valor <= nodoActual.siguiente.valor;
            nodoActual = nodoActual.siguiente;
        }

        System.out.println("El caso de prueba ha pasado correctamente.");
    }
}
