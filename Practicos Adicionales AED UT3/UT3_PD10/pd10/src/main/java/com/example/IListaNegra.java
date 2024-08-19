package com.example;

public interface IListaNegra<T, U> {
    void agregarIncompatibilidad(T identificadorSuero, U identificadorFarmaco);
    boolean esIncompatible(T identificadorSuero, U identificadorFarmaco);
}