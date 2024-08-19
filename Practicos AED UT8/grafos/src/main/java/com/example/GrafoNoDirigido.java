package com.example;

import java.util.*;

public class GrafoNoDirigido {
    private Map<Comparable, Vertice> vertices;
    private LinkedList<Integer>[] adj;
    private Integer[][] predecesores;

    public GrafoNoDirigido(Collection<Vertice> vertices, Collection<Arista> aristas) {
        this.vertices = new HashMap<>();
        for (Vertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (Arista arista : aristas) {
            insertarArista(arista);
        }
    }

    private void insertarVertice(Comparable etiqueta) {
        vertices.put(etiqueta, new Vertice<>(etiqueta));
    }

    public Map<Comparable, Vertice> getVertices(){
        return this.vertices;
    }

    public boolean eliminarVertice(Comparable vertice){
        throw new UnsupportedOperationException("No disponible aun");
    }

    public Vertice buscarVertice(Comparable etiqueta){
        return getVertices().get(etiqueta);
    }

    public Vertice getVerticeIndice(int indice) {
        int i = 0;
        for (Vertice vertice : vertices.values()) {
            if (i == indice) {
                return vertice;
            }
            i++;
        }
        return null;
    }

    public boolean existeVertice(Comparable etiqueta){
        return getVertices().get(etiqueta) != null;
    }

    private void insertarArista(Arista arista) {
        Vertice origen = vertices.get(arista.getOrigen());
        Vertice destino = vertices.get(arista.getDestino());
        if (origen != null && destino != null) {
            origen.insertarAdyacencia(arista.getCosto(), destino);
            destino.insertarAdyacencia(arista.getCosto(), origen); // Agregar arista en la dirección opuesta
        }
    }

     public void eliminarArista(Arista arista) {
        Vertice origen = vertices.get(arista.getOrigen());
        Vertice destino = vertices.get(arista.getDestino());
        if (origen != null && destino != null) {
            origen.eliminarAdyacencia(destino.getEtiqueta());
            destino.eliminarAdyacencia(origen.getEtiqueta()); // Eliminar arista en la dirección opuesta
        }
    }

    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino){
        Vertice vertOrigen = buscarVertice(etiquetaOrigen);
        Vertice vertDestino = buscarVertice(etiquetaDestino);
        if((vertOrigen != null) && (vertDestino != null)){
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    public Object[] getEtiquetasOrdenadas(){
        TreeMap<Comparable, Vertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    public Comparable centroDelGrafo() {
        Double[][] distancias = floyd();
        int numVertices = vertices.size();
        Double minDistancia = Double.POSITIVE_INFINITY;
        int indiceCentro = -1;
    
        for (int i = 0; i < numVertices; i++) {
            Double maxDistancia = Double.NEGATIVE_INFINITY;
            for (int j = 0; j < numVertices; j++) {
                if (distancias[i][j] > maxDistancia) {
                    maxDistancia = distancias[i][j];
                }
            }
            if (maxDistancia < minDistancia) {
                minDistancia = maxDistancia;
                indiceCentro = i;
            }
        }
        return (Comparable) getEtiquetasOrdenadas()[indiceCentro];
    }

    public Double[][] floyd() {
        int numVertices = vertices.size();
        Double[][] distancias = new Double[numVertices][numVertices];
        List<Comparable> etiquetas = new ArrayList<>(vertices.keySet());
    
        // Inicializar las distancias
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j) {
                    distancias[i][j] = 0.0;
                } else {
                    Vertice verticeI = vertices.get(etiquetas.get(i));
                    Vertice verticeJ = vertices.get(etiquetas.get(j));
                    if (verticeI.buscarAdyacencia(verticeJ) != null) {
                        distancias[i][j] = verticeI.obtenerCostoAdyacencia(verticeJ);
                    } else {
                        distancias[i][j] = Double.POSITIVE_INFINITY;
                    }
                }
            }
        }
    
        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (distancias[i][j] > distancias[i][k] + distancias[k][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                    }
                }
            }
        }
        return distancias;
    }
    
    public double obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] distancias = floyd();
        Object[] etiquetas = getEtiquetasOrdenadas();
        int indiceVertice = Arrays.asList(etiquetas).indexOf(etiquetaVertice);
        if (indiceVertice == -1) throw new IllegalArgumentException("Vertice inexistente");
        double maxDistancia = 0.0;
        for (int i = 0; i < distancias.length; i++) {
            if (i != indiceVertice && distancias[indiceVertice][i] > maxDistancia) {
                maxDistancia = distancias[indiceVertice][i];
            }
        }
        return maxDistancia;
    }

    // Encuentra la distancia mas corta entre dos vertices usando Floyd
    public double encontrarMinimaDistancia(Comparable etiquetaOrigen, Comparable etiquetaDestino){
        Double[][] distancias = floyd();
        Object[] etiquetas = getEtiquetasOrdenadas();
        int indiceOrigen = Arrays.asList(etiquetas).indexOf(etiquetaOrigen);
        int indiceDestino = Arrays.asList(etiquetas).indexOf(etiquetaDestino);
        if(indiceOrigen == -1 || indiceDestino == -1){
            throw new IllegalArgumentException("Vertice inexistente");
        }
        return distancias[indiceOrigen][indiceDestino];
    }

    // Encuentra la ruta de menor costo entre dos vertices usando Floyd
    public List<Comparable> encontrarRutaMinima(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        floyd();
        Object[] etiquetas = getEtiquetasOrdenadas();
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

    // Busqueda en profundidad
    public void dfs() {
        Set<Comparable> visited = new HashSet<>();
        for (Vertice vertice : vertices.values()) {
            dfs(vertice, visited);
        }
    }
    private void dfs(Vertice vertice, Set<Comparable> visited) {
        if (visited.contains(vertice.getEtiqueta())) {
            return;
        }
    
        visited.add(vertice.getEtiqueta());
        System.out.println("Visitado: " + vertice.getEtiqueta());
    
        for (Object obj : vertice.getAdyacentes()) {
            if (obj instanceof Adyacencia) {
                Adyacencia adyacencia = (Adyacencia) obj;
                dfs(adyacencia.getDestino(), visited);
            }
        }
    }

    // Busqueda en amplitud
    public Collection<Vertice> bea(Comparable etiquetaOrigen) {
        List<Vertice> resultado = new LinkedList<>();
        Queue<Vertice> cola = new LinkedList<>();
        Vertice vertice = this.buscarVertice(etiquetaOrigen);
    
        if (vertice != null) {
            cola.add(vertice);
            while (!cola.isEmpty()) {
                Vertice actual = cola.poll();
                if (!resultado.contains(actual)) {
                    resultado.add(actual);
                    for (Object obj : actual.getAdyacentes()) {
                        Adyacencia adyacente = (Adyacencia) obj;
                        cola.add(adyacente.getDestino());
                    }
                }
            }
        }
        return resultado;
    }

    public Collection<Vertice> bea() {
        List<Vertice> resultado = new LinkedList<>();
        for (Vertice vertice : this.getVertices().values()) {
            if (!resultado.contains(vertice)) {
                resultado.addAll(this.bea(vertice.getEtiqueta()));
            }
        }
        return resultado;
    }

    // Algoritmo de prim
    public GrafoNoDirigido prim() {
        GrafoNoDirigido mst = new GrafoNoDirigido(new ArrayList<>(), new ArrayList<>());
        if (vertices.isEmpty()) {
            return mst;
        }

        PriorityQueue<Arista> edgesQueue = new PriorityQueue<>(Comparator.comparingDouble(Arista::getCosto));
        Map<Comparable, Vertice> mstVertices = new HashMap<>();

        Vertice start = vertices.values().iterator().next();
        mstVertices.put(start.getEtiqueta(), start);
        edgesQueue.addAll(start.getAdyacentes());

        while (!edgesQueue.isEmpty()) {
            Arista minEdge = edgesQueue.poll();
            Vertice v = (Vertice) minEdge.getDestino();

            if (!mstVertices.containsKey(v.getEtiqueta())) {
                mstVertices.put(v.getEtiqueta(), v);
                mst.insertarVertice((Comparable) v);
                mst.insertarArista(minEdge);
                edgesQueue.addAll(v.getAdyacentes());
            }
        }

        return mst;
    }

    // Algoritmo de Kruskal
    public GrafoNoDirigido kruskal() {
        GrafoNoDirigido mst = new GrafoNoDirigido(new ArrayList<>(), new ArrayList<>());
        PriorityQueue<Arista> edgesQueue = new PriorityQueue<>(Comparator.comparingDouble(Arista::getCosto));
        Map<Comparable, Vertice> mstVertices = new HashMap<>();
        Map<Comparable, Vertice> parent = new HashMap<>();

        for (Vertice v : vertices.values()) {
            parent.put(v.getEtiqueta(), v);
            edgesQueue.addAll(v.getAdyacentes());
        }

        while (!edgesQueue.isEmpty()) {
            Arista edge = edgesQueue.poll();
            Vertice v1 = (Vertice) edge.getOrigen();
            Vertice v2 = (Vertice) edge.getDestino();

            Vertice root1 = find(v1, parent);
            Vertice root2 = find(v2, parent);

            if (!root1.getEtiqueta().equals(root2.getEtiqueta())) {
                mstVertices.put(v1.getEtiqueta(), v1);
                mstVertices.put(v2.getEtiqueta(), v2);
                mst.insertarVertice((Comparable) v1);
                mst.insertarVertice((Comparable) v2);
                mst.insertarArista(edge);
                union(root1, root2, parent);
            }
        }

        return mst;
    }

    private Vertice find(Vertice v, Map<Comparable, Vertice> parent) {
        while (!v.getEtiqueta().equals(parent.get(v.getEtiqueta()).getEtiqueta())) {
            v = parent.get(v.getEtiqueta());
        }
        return v;
    }

    private void union(Vertice v1, Vertice v2, Map<Comparable, Vertice> parent) {
        parent.put(v1.getEtiqueta(), v2);
    }
}