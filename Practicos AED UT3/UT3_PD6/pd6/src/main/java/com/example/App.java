package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        ListaEnlazada<String> directorioSucursales = new ListaEnlazada<>();

        // Cargar sucursales desde el archivo "sucursales.txt"
        cargarSucursales("./src/sucursales.txt", directorioSucursales);

        // Agregar una sucursal
        directorioSucursales.agregar("Nueva York");

        // Buscar una sucursal
        String sucursalBuscada = directorioSucursales.buscar("Montevideo");
        if (sucursalBuscada != null) {
            System.out.println("Sucursal encontrada: " + sucursalBuscada);
        } else {
            System.out.println("Sucursal no encontrada");
        }

        // Quitar una sucursal
        directorioSucursales.quitar("Londres");

        // Listar todas las sucursales
        System.out.println("Lista de sucursales:");
        directorioSucursales.listar();

        // Indicar la cantidad de sucursales
        System.out.println("Cantidad de sucursales: " + directorioSucursales.cantidad());

        // Indicar si el directorio de sucursales está vacío
        if (directorioSucursales.estaVacia()) {
            System.out.println("El directorio de sucursales está vacío");
        } else {
            System.out.println("El directorio de sucursales no está vacío");
        }
    }

    public static void cargarSucursales(String archivo, ListaEnlazada<String> lista) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.agregar(linea.trim());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + archivo);
        }
    }
}

