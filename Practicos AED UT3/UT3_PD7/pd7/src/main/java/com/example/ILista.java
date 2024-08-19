package com.example;

public interface ILista<T> {
    void agregar(T elemento);
    boolean eliminar(T elemento);
    boolean contiene(T elemento);
    void limpiar();
    int longitud();
    void listar();
    Nodo<T> obtenerPrimero();
}

