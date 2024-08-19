package com.example;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        @SuppressWarnings("rawtypes")
        TArbolBB arbol = new TArbolBB<>();

        arbol.insertar(5, 5);
        arbol.insertar(10, 10);
        arbol.insertar(7, 7);
        arbol.insertar(1, 1);
        arbol.insertar(34, 34);
        arbol.insertar(23, 23);
        arbol.insertar(4, 4);

        
        System.out.println(arbol.preOrden());
        System.out.println(arbol.inOrden());
        System.out.println(arbol.postOrden());

        System.out.println(arbol.buscar(34));

        // System.out.println("El nodo eliminado es: " + arbol.eliminar(5));
        // System.out.println(arbol.inOrden());

        System.out.println("altura: " + arbol.altura());
        System.out.println("tamano: " + arbol.size());
        System.out.println("cantidad hojas: " + arbol.contarHojas());

        int nivel;
        System.out.println((nivel = arbol.buscarNivel(4)) != -1 ? "La clave se encuentra en el nivel: " + nivel : "La clave no se encuentra en el árbol.");

        // String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/entrada.txt");

        // ArrayList<String> lineasEnArbol = new ArrayList<>();

        // for (String linea : lineas) {
        //     if (arbol.buscar(linea) != null) {
        //         // Si la línea está en el árbol, añádela a la lista
        //         lineasEnArbol.add(linea);
        //         System.out.println("Línea encontrada en el árbol: " + linea);
        //     }
        // }
    
        // // Verifica si hay líneas para escribir en el archivo
        // if (!lineasEnArbol.isEmpty()) {
        //     // Escribe las líneas que están en el árbol en un nuevo archivo
        //     ManejadorArchivosGenerico.escribirArchivo("archivoSalida.txt", lineasEnArbol.toArray(new String[0]));
        //     System.out.println("Archivo de salida escrito con éxito.");
        // } else {
        //     System.out.println("No se encontraron líneas en el árbol.");
        // }
        
    }
}
