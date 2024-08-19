package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Programa {
    public static void main(String[] args) {
        // Modificar las rutas segun sea necesario
        GrafoNoDirigido grafo = UtilGrafos.cargarGrafo("C:\\Users\\ignrd\\OneDrive\\Escritorio\\TA5\\src\\main\\java\\com\\example\\actores.csv", "C:\\Users\\ignrd\\OneDrive\\Escritorio\\TA5\\src\\main\\java\\com\\example\\en_pelicula.csv", false, GrafoNoDirigido.class);

        List<String> actores = Arrays.asList("John_Goodman", "Tom_Cruise", "Jason_Statham", "Lukas_Haas", "Djimon_Hounsou");
        List<String> salida = new ArrayList<>();
        
        for (String actor : actores) {
            int numBacon = grafo.numBacon(actor);
            System.out.println("Número de Bacon de " + actor + ": " + numBacon);
            salida.add("Número de Bacon de " + actor + ": " + numBacon);
        }

        String[] salidaArray = new String[salida.size()];
        salida.toArray(salidaArray);
        ManejadorArchivosGenerico.escribirArchivo("salida.txt", salidaArray);
    }
}
