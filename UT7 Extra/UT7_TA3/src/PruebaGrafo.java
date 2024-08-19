import java.util.List;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("C:\\Users\\ignrd\\OneDrive\\Escritorio\\TA3-CODIGO BASE\\src\\aeropuertos_1.txt","C:\\Users\\ignrd\\OneDrive\\Escritorio\\TA3-CODIGO BASE\\src\\conexiones_1.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        Double[][] mfloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");

        // Encontrar la distancia más corta entre dos ciudades
        Comparable ciudadOrigen = "Asuncion";
        Comparable ciudadDestino = "Curitiba"; 
        Double distancia = gd.encontrarDistanciaMinima(ciudadOrigen, ciudadDestino);
        System.out.println("La distancia más corta de " + ciudadOrigen + " a " + ciudadDestino + " es: " + distancia);

        // Encontrar la ruta de menor costo entre dos ciudades
        List<Comparable> ruta = gd.encontrarRutaMinima(ciudadOrigen, ciudadDestino);
        System.out.println("La ruta de menor costo de " + ciudadOrigen + " a " + ciudadDestino + " es: " + ruta);

        // Encontrar el centro del grafo
        Comparable centro = gd.encontrarCentroGrafo();
        System.out.println("El centro del grafo es: " + centro);

        // for (int i = 0; i < etiquetasarray.length; i++) {
        //     System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
        // }
        // System.out.println();
        // System.out.println("Centro del grafo: " + gd.centroDelGrafo());
       
       
    }
}
