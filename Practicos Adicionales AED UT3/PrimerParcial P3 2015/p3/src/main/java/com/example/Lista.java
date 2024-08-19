package com.example;

public class Lista<T> implements ILista<T> {
    protected Nodo<T> primero;

    @Override
    public void insertar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(primero);
        primero = nuevo;
    }

    @Override
    public void imprimir(String separador) {
        Nodo<T> actual = primero;
        while (actual != null) {
            System.out.print(actual.getDato());
            actual = actual.getSiguiente();
            if (actual != null) {
                System.out.print(separador);
            }
        }
        System.out.println();
    }

    @Override
    public void retirarDuplicados() {
        Nodo<T> actual = primero;
        while (actual != null && actual.getSiguiente() != null) {
            Nodo<T> aux = actual;
            while (aux.getSiguiente() != null) {
                if (actual.getDato().equals(aux.getSiguiente().getDato())) {
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                } else {
                    aux = aux.getSiguiente();
                }
            }
            actual = actual.getSiguiente();
        }
    }
}
