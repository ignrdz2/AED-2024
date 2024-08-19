package com.example;

public class ListaOrdenada<T extends Comparable<T>> extends Lista<T> implements IListaOrdenada<T> {

    @Override
    public INodo<T> getPrimero() {
        if (primero == null) {
            return null;
        }
        return (INodo<T>) primero.getDato();
    }

    @Override
    public void insertarOrdenado(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (primero == null || dato.compareTo(primero.getDato()) < 0) {
            nuevo.setSiguiente(primero);
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null && dato.compareTo(actual.getSiguiente().getDato()) > 0) {
                actual = actual.getSiguiente();
            }
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
        }
    }

    @Override
    public IListaOrdenada<T> mezclar(IListaOrdenada<T> otraLista) {
        ListaOrdenada<T> listaResultante = new ListaOrdenada<>();
        Nodo<T> nodoActual1 = this.primero;
        Nodo<T> nodoActual2 = ((ListaOrdenada<T>) otraLista).primero;

        while (nodoActual1 != null && nodoActual2 != null) {
            if (nodoActual1.getDato().compareTo(nodoActual2.getDato()) < 0) {
                listaResultante.insertarOrdenado(nodoActual1.getDato());
                nodoActual1 = nodoActual1.getSiguiente();
            } else {
                listaResultante.insertarOrdenado(nodoActual2.getDato());
                nodoActual2 = nodoActual2.getSiguiente();
            }
        }

        while (nodoActual1 != null) {
            listaResultante.insertarOrdenado(nodoActual1.getDato());
            nodoActual1 = nodoActual1.getSiguiente();
        }

        while (nodoActual2 != null) {
            listaResultante.insertarOrdenado(nodoActual2.getDato());
            nodoActual2 = nodoActual2.getSiguiente();
        }

        this.primero = null;
        ((ListaOrdenada<T>) otraLista).primero = null;

        return listaResultante;
    }
    
    public String toString() {
        if (esVacia()) {
            return "{}";
        } else {
            StringBuilder sb = new StringBuilder();
            INodo<T> nodoActual = (INodo<T>) primero;
            sb.append("{");
            while (nodoActual != null) {
                sb.append(nodoActual.getDato());
                if (nodoActual.getSiguiente() != null) {
                    sb.append(",");
                }
                nodoActual = nodoActual.getSiguiente();
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public boolean esVacia() {
        return primero == null;
    }
    
}