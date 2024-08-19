package com.example;

public interface IListaOrdenada<T extends Comparable<T>> {
    void insertarOrdenado(T dato);
    IListaOrdenada<T> mezclar(IListaOrdenada<T> otraLista);
    void imprimir(String separador);
    INodo<T> getPrimero(); // Método adicional para obtener el primer nodo
    
}
