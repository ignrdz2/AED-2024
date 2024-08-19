
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, TVertice> vertices; // vertices del grafo.-
    private Integer[][] predecesores; // matriz de predecesores para el algoritmo de Floyd

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    
    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override

    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double[][] floyd() {
        int numVertices = vertices.size();
        Double[][] distancias = new Double[numVertices][numVertices];
        Integer[][] predecesores = new Integer[numVertices][numVertices];
        Object[] etiquetas = getEtiquetasOrdenado();

        // Inicializar las matrices de distancias y predecesores
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j) {
                    distancias[i][j] = 0.0;
                    predecesores[i][j] = null;
                } else if (existeArista((Comparable) etiquetas[i], (Comparable) etiquetas[j])) {
                    TAdyacencia arista = buscarVertice((Comparable) etiquetas[i]).buscarAdyacencia(buscarVertice((Comparable) etiquetas[j]));
                    if (arista != null) {
                        distancias[i][j] = arista.getCosto();
                        predecesores[i][j] = i;
                    } else {
                        distancias[i][j] = Double.POSITIVE_INFINITY;
                        predecesores[i][j] = null;
                    }
                } else {
                    distancias[i][j] = Double.POSITIVE_INFINITY;
                    predecesores[i][j] = null;
                }
            }
        }

        // Actualizar las distancias considerando cada vértice como un vértice intermedio
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                        predecesores[i][j] = predecesores[k][j];
                    }
                }
            }
        }

        // Guardar la matriz de predecesores para reconstruir las rutas más cortas
        this.predecesores = predecesores;

        return distancias;
    }

    /**
     * Encuentra la distancia más corta entre dos vértices usando el algoritmo de Floyd-Warshall.
     */
    public Double encontrarDistanciaMinima(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        Double[][] distancias = floyd();
        Object[] etiquetas = getEtiquetasOrdenado();
        int indiceOrigen = Arrays.asList(etiquetas).indexOf(etiquetaOrigen);
        int indiceDestino = Arrays.asList(etiquetas).indexOf(etiquetaDestino);
        if (indiceOrigen == -1 || indiceDestino == -1) {
            // throw an exception or return a suitable default value
            throw new IllegalArgumentException("Vertice no econtrado en el grafo");
        }
        return distancias[indiceOrigen][indiceDestino];
    }

    /**
     * Encuentra la ruta de menor costo entre dos vértices usando el algoritmo de Floyd-Warshall.
     */
    public List<Comparable> encontrarRutaMinima(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        floyd();
        Object[] etiquetas = getEtiquetasOrdenado();
        int indiceOrigen = Arrays.asList(etiquetas).indexOf(etiquetaOrigen);
        int indiceDestino = Arrays.asList(etiquetas).indexOf(etiquetaDestino);
        List<Comparable> ruta = new LinkedList<>();
        while (indiceDestino != indiceOrigen) {
            ruta.add(0, (Comparable) etiquetas[indiceDestino]);
            indiceDestino = predecesores[indiceOrigen][indiceDestino];
        }
        ruta.add(0, (Comparable) etiquetas[indiceOrigen]);
        return ruta;
    }

    /**
     * Encuentra el vértice que minimiza la suma de las distancias a todos los demás vértices.
     */
    public Comparable encontrarCentroGrafo() {
        Double[][] distancias = floyd();
        int numVertices = vertices.size();
        Double minDistancia = Double.POSITIVE_INFINITY;
        int indiceCentro = -1;
        for (int i = 0; i < numVertices; i++) {
            Double distancia = 0.0;
            for (int j = 0; j < numVertices; j++) {
                distancia += distancias[i][j];
            }
            if (distancia < minDistancia) {
                minDistancia = distancia;
                indiceCentro = i;
            }
        }
        return (Comparable) getEtiquetasOrdenado()[indiceCentro];
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean[][] warshall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
