package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GrafoDirigido gd = (GrafoDirigido) UtilGrafos.cargarGrafo("C:\\Users\\ignrd\\OneDrive\\Escritorio\\grafosdirigidos\\src\\main\\java\\com\\example\\aeropuertos_1.txt", "C:\\Users\\ignrd\\OneDrive\\Escritorio\\grafosdirigidos\\src\\main\\java\\com\\example\\conexiones_1.txt",
         false, GrafoDirigido.class);

         Object[] etiquetasarray = gd.getEtiquetasOrdenadas();

         Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
         UtilGrafos.imprimirMatriz(matriz, gd.getVertices(), "Matriz");

         Double[][] mfloyd = gd.floyd();
         UtilGrafos.imprimirMatriz(mfloyd, gd.getVertices(), "Matriz luego de Floyd");

         // Encontrar la distancia mas corta entre dos vertices.
        Comparable vertOrigen = "Asuncion";
        Comparable vertDestino = "Curitiba";
        Double distancia = gd.encontrarMinimaDistancia(vertOrigen, vertDestino);
        System.out.println("La distancia más corta entre " + vertOrigen + " y " + vertDestino + "  es: " + distancia);

        // Encontrar la ruta de menor costo entre dos vertices.
        List<Comparable> ruta = gd.encontrarRutaMinima(vertOrigen, vertDestino);
        System.out.println("La ruta de menor costo entre " + vertOrigen + " y " + vertDestino + "  es: " + ruta);

        // Encontrar el centro del grafo.
        Comparable centro = gd.centroDelGrafo();
        System.out.println("El centro del grafo es: " + centro);

        // Encontrar excentricidad de un vertice.
        Comparable vertice = "Asuncion";
        System.out.println("Excentricidad del vertice " + vertice + ": " + gd.obtenerExcentricidad(vertice));

        // Busqueda en profundidad.
        System.out.println("Busqueda en profundidad:");
        gd.dfs();

        System.out.println();

        // BUsqueda en amplitud.
        System.out.println("Busqueda en amplitud:");
        // gd.bfs(vertOrigen);
        System.out.println("Bea con origen" + gd.bea(vertOrigen));
        System.out.println("Bea sin origen" + gd.bea());

        // Verificar si el grafo tiene ciclos
        System.out.println("Tiene ciclos: " + gd.tieneCiclos());

        // Orden topologico
        System.out.println("Orden topologico: ");
        gd.ordenTopologico();

        // Verificar si es fuertemente conexo
        System.out.println("Es Fuertemente Conexo: " + gd.esFuertementeConexo());


        // Assuming you have a GrafoDirigido instance named 'grafo' and a Vertice instance named 'verticeOrigen'
        List<Arista> ArcosArbol = new ArrayList<>();
        List<Arista> ArcosRetroceso = new ArrayList<>();
        List<Arista> ArcosAvance = new ArrayList<>();
        List<Arista> ArcosCruzados = new ArrayList<>();

        Vertice vertice1 = gd.buscarVertice(vertOrigen);

        gd.ClasificarArcos(vertice1, ArcosArbol, ArcosRetroceso, ArcosAvance, ArcosCruzados);

        // Print the results
        System.out.println("Arcos de árbol: " + ArcosArbol);
        System.out.println("Arcos de retroceso: " + ArcosRetroceso);
        System.out.println("Arcos de avance: " + ArcosAvance);
        System.out.println("Arcos cruzados: " + ArcosCruzados);
    }
}