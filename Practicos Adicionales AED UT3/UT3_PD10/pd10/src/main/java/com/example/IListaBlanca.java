package com.example;

public interface IListaBlanca<T> {
    void agregarFármaco(T identificador);
    boolean esFármacoBlanco(T identificador);
}
