package com.example;

public interface ILista<T> {
    void insertar(T dato);
    void imprimir(String separador);
    void retirarDuplicados();
}