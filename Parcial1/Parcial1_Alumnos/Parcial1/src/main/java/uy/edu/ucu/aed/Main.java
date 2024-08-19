package uy.edu.ucu.aed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main 
{
    @SuppressWarnings("unchecked")
    public static void main( String[] args )
    {
        @SuppressWarnings("rawtypes")
        TArbolBB arbol = new TArbolBB<>();

        // Leer archivo y poner los productos en el arbol
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/productos.txt");
        for (String linea : lineas) {
            String[] parts = linea.split(",");
            int identificador = Integer.parseInt(parts[0]);
            String nombre = parts[1];
            arbol.insertarBalanceado(identificador, nombre);
        }

        // Invocar el método programado
        LinkedList<String> productosSinCategorias = new LinkedList<>();
        LinkedList<String> productosConCategorias = new LinkedList<>();
        arbol.separar(productosConCategorias, productosSinCategorias);
        // Ordenar los productos por nombre
        Collections.sort(productosSinCategorias);

        // Esribir productos
        String[] lineasSalida = new String[productosSinCategorias.size()];
        for (int i = 0; i < productosSinCategorias.size(); i++) {
            String nombreProducto = productosSinCategorias.get(i); // Obtener el nombre del producto de la lista
            lineasSalida[i] = nombreProducto;
        }
        ManejadorArchivosGenerico.escribirArchivo("salida.txt", lineasSalida);
    
    }
}
