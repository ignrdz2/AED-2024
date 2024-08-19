package com.example;

public class Lista {
    Nodo primero;
    private Nodo ultimo;

    public Lista() {
        this.primero = null;
        this.ultimo = null;
    }

    public void agregar(int valor) {
        Nodo nodo = new Nodo(valor);
        if (primero == null) {
            primero = nodo;
            ultimo = nodo;
        } else {
            ultimo.siguiente = nodo;
            ultimo = nodo;
        }
    }

    public Lista ordenaParesImpares() {
        Lista listaImpar = new Lista();
        Lista listaPar = new Lista();

        // Separar elementos en listas auxiliares
        Nodo nodoActual = primero;
        while (nodoActual != null) {
            if (nodoActual.valor % 2 != 0) {  // Es impar
                listaImpar.agregar(nodoActual.valor);
            } else {
                listaPar.agregar(nodoActual.valor);
            }
            nodoActual = nodoActual.siguiente;
        }

        // Ordenar listas auxiliares
        listaImpar.ordenar();
        listaPar.ordenar();

        // Combinar listas ordenadas
        Lista listaOrdenada = new Lista();
        nodoActual = listaImpar.primero;
        while (nodoActual != null) {
            listaOrdenada.agregar(nodoActual.valor);
            nodoActual = nodoActual.siguiente;
        }

        nodoActual = listaPar.primero;
        while (nodoActual != null) {
            listaOrdenada.agregar(nodoActual.valor);
            nodoActual = nodoActual.siguiente;
        }

        return listaOrdenada;
    }

    private void ordenar() {
        // Implementación de un algoritmo de ordenación eficiente, como QuickSort
        // Este es un ejemplo simple de ordenación burbuja para el propósito de este ejercicio
        if (primero == null) {
            return;
        }

        boolean cambio;
        do {
            cambio = false;
            Nodo nodoActual = primero;
            Nodo nodoAnterior = null;

            while (nodoActual.siguiente != null) {
                if (nodoActual.valor > nodoActual.siguiente.valor) {
                    // Intercambiar nodos
                    if (nodoAnterior != null) {
                        nodoAnterior.siguiente = nodoActual.siguiente;
                    } else {
                        primero = nodoActual.siguiente;
                    }

                    Nodo temp = nodoActual.siguiente;
                    nodoActual.siguiente = temp.siguiente;
                    temp.siguiente = nodoActual;

                    nodoAnterior = temp;
                    cambio = true;
                } else {
                    nodoAnterior = nodoActual;
                    nodoActual = nodoActual.siguiente;
                }
            }
        } while (cambio);
    }

    // Método para imprimir la lista (solo para propósitos de prueba)
    public void imprimir() {
        Nodo nodoActual = primero;
        while (nodoActual != null) {
            System.out.print(nodoActual.valor + " ");
            nodoActual = nodoActual.siguiente;
        }
        System.out.println();
    }
}