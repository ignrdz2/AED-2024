package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Vector;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class GrafoDirigido {
    private final Map<Comparable, Vertice> vertices;
    private Integer[][] predecesores;
    private final LinkedList<Integer>[] adj;

    public GrafoDirigido(Collection<Vertice> vertices, Collection<Arista> aristas){
        this.vertices = new HashMap<>();
        for(Vertice vertice : vertices){
            insertarVertice(vertice.getEtiqueta());
        }
        for(Arista arista : aristas){
            insertarArista(arista);
        }
        int v = vertices.size();
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public boolean insertarVertice(Comparable etiqueta){
        if((etiqueta != null) && (!existeVertice(etiqueta))){
            Vertice vert = new Vertice<>(etiqueta); // <>
            getVertices().put(etiqueta, vert);
            return getVertices().containsKey(etiqueta);
        }
        return false;
    }

    public boolean insertarVertice(Vertice vertice){
        Comparable etiqueta = vertice.getEtiqueta();
        if(!existeVertice(etiqueta)){
            getVertices().put(etiqueta, vertice);
            return getVertices().containsKey(etiqueta);
        }
        return false;
    }

    public boolean eliminarVertice(Comparable vertice){
        throw new UnsupportedOperationException("No disponible aun");
    }

    public Map<Comparable, Vertice> getVertices(){
        return this.vertices;
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
        return null; // Devuelve null si no se encuentra el índice
    }

    public boolean existeVertice(Comparable etiqueta){
        return getVertices().get(etiqueta) != null;
    }

    public boolean insertarArista(Arista arista){
        if((arista.getOrigen() != null) && (arista.getDestino() != null)){
            Vertice vertOrigen = buscarVertice(arista.getOrigen());
            Vertice vertDestino = buscarVertice(arista.getDestino());
            if((vertOrigen != null) && vertDestino != null){
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    public boolean eliminarArista(Comparable vertOrigen, Comparable vertDestino){
        if((vertOrigen != null) && (vertDestino != null)){
            Vertice vertOrigenAux = buscarVertice(vertOrigen);
            if(vertOrigenAux != null) return vertOrigenAux.eliminarAdyacencia(vertOrigen);
        }
        return false;
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

    public double obtenerExcentricidad(Comparable etiquetaVertice){
        Double[][] distancias = floyd();
        Object[] etiquetas = getEtiquetasOrdenadas();
        int indiceVertice = Arrays.asList(etiquetas).indexOf(etiquetaVertice);
        if(indiceVertice == -1) throw new IllegalArgumentException("Vertice inexistente");
        double maxDistancia = 0.0;
        for(int i = 0; i < distancias.length; i++){
            if(i != indiceVertice && distancias[indiceVertice][i] > maxDistancia){
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
    public void bfs(Comparable etiquetaVerticeInicial) {
        Vertice verticeInicial = buscarVertice(etiquetaVerticeInicial);
        if (verticeInicial == null) {
            throw new IllegalArgumentException("Vertice inexistente");
        }
    
        LinkedList<Vertice> cola = new LinkedList<>();
        Set<Comparable> visitados = new HashSet<>();
    
        cola.add(verticeInicial);
        visitados.add(verticeInicial.getEtiqueta());
    
        while (!cola.isEmpty()) {
            Vertice verticeActual = cola.poll();
            System.out.println("Visitado: " + verticeActual.getEtiqueta());
    
            for (Object obj : verticeActual.getAdyacentes()) {
                if (obj instanceof Adyacencia) {
                    Adyacencia adyacencia = (Adyacencia) obj;
                    Vertice verticeAdyacente = adyacencia.getDestino();
                    if (!visitados.contains(verticeAdyacente.getEtiqueta())) {
                        cola.add(verticeAdyacente);
                        visitados.add(verticeAdyacente.getEtiqueta());
                    }
                }
            }
        }
    }

    // Busqueda en amplitud | Respetando firmas TA3 UT8
    public Collection<Vertice> bea(Comparable etiquetaOrigen) {
        Vertice verticeInicial = buscarVertice(etiquetaOrigen);
        if (verticeInicial == null) {
            throw new IllegalArgumentException("Vertice inexistente");
        }

        LinkedList<Vertice> cola = new LinkedList<>();
        Set<Comparable> visitados = new HashSet<>();
        Collection<Vertice> resultado = new LinkedList<>();

        cola.add(verticeInicial);
        visitados.add(verticeInicial.getEtiqueta());

        while (!cola.isEmpty()) {
            Vertice verticeActual = cola.poll();
            resultado.add(verticeActual);

            for (Object obj : verticeActual.getAdyacentes()) {
                if (obj instanceof Adyacencia) {
                    Adyacencia adyacencia = (Adyacencia) obj;
                    Vertice verticeAdyacente = adyacencia.getDestino();
                    if (!visitados.contains(verticeAdyacente.getEtiqueta())) {
                        cola.add(verticeAdyacente);
                        visitados.add(verticeAdyacente.getEtiqueta());
                    }
                }
            }
        }
        return resultado;
    }

    public Collection<Vertice> bea() {
        if (vertices.isEmpty()) {
            return new LinkedList<>();
        }
        // Elegir un vértice arbitrario como punto de partida
        Comparable etiquetaOrigen = vertices.keySet().iterator().next();
        return bea(etiquetaOrigen);
    }

    public Caminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        Caminos losCaminos = new Caminos();
        Camino caminoPrevio = new Camino();
        caminoPrevio.vertices.add(vertices.get(etiquetaOrigen));
        vertices.get(etiquetaOrigen).todosLosCaminos(etiquetaDestino, caminoPrevio, losCaminos);
        return losCaminos;
    }

    // Agregar un borde al grafo
    void agregarBorde(int v, int w) {
        adj[v].add(w);
    }

    // Verificar si el grafo contiene un ciclo
    public boolean tieneCiclos() {
        boolean[] visitado = new boolean[vertices.size()];
        boolean[] pilaRecursion = new boolean[vertices.size()];
    
        for (int i = 0; i < vertices.size(); i++) {
            if (tieneCiclos(i, visitado, pilaRecursion)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean tieneCiclos(int v, boolean[] visitado, boolean[] pilaRecursion) {
        if (pilaRecursion[v]) {
            return true;
        }
    
        if (!visitado[v]) {
            visitado[v] = true;
            pilaRecursion[v] = true;
    
            LinkedList<Integer> listaAdyacencia = adj[v];
            for (Integer c : listaAdyacencia) {
                if (tieneCiclos(c, visitado, pilaRecursion)) {
                    return true;
                }
            }
        }
        pilaRecursion[v] = false;
        return false;
    }
    

    // Ordenacion Topologica
    public void ordenTopologico() {
        int indegree[] = new int[vertices.size()];

        for (int i = 0; i < vertices.size(); i++) {
            LinkedList<Integer> temp = (LinkedList<Integer>) adj[i];
            for (int node : temp) {
                indegree[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < vertices.size(); i++) {
            if (indegree[i]==0)
                q.add(i);
        }

        Vector<Integer> topOrder=new Vector<Integer>();
        int cnt = 0;
        while (!q.isEmpty()) {
            int u=q.poll();
            topOrder.add(u);

            for (int node : adj[u]) {
                if (--indegree[node] == 0)
                    q.add(node);
            }
            cnt++;
        }
        if (cnt != vertices.size()) {
            System.out.println("Hay un ciclo en el grafo!");
            return;
        }
        for (int i : topOrder) {
            System.out.print(getVerticeIndice(i) + " - ");
        }
    }

    // Funcion para obtener el grafo transpuesto
    public GrafoDirigido getTranspuesto() {
        List<Arista> aristasTranspuestas = new ArrayList<>();
        for (Vertice vertice : vertices.values()) {
            for (Object obj : vertice.getAdyacentes()) {
                Adyacencia adyacencia = (Adyacencia) obj;
                aristasTranspuestas.add(new Arista(adyacencia.getDestino().getEtiqueta(), vertice.getEtiqueta(), adyacencia.getCosto()));
            }
        }
        return new GrafoDirigido(vertices.values(), aristasTranspuestas);
    }
    
    // Metodo para determinar si el grafo es fuertemente conexo
    public boolean esFuertementeConexo() {
        Set<Comparable> visited = new HashSet<>();
        for (Vertice i : vertices.values()) {
            if (!visited.contains(i.getEtiqueta())) {
                dfs(i, visited);
            }
        }
        GrafoDirigido gr = getTranspuesto();
        visited.clear();  
        Vertice v = vertices.values().iterator().next();
        gr.dfs(v, visited);
    
        for (Vertice i : gr.vertices.values()) {
            if (!visited.contains(i.getEtiqueta())) {
                return false;
            }
        }
        return true;
    }

    // Método para obtener un orden parcial de las tareas ####
    public LinkedList<Vertice> ordenParcial() {
        LinkedList<Vertice> orden = new LinkedList<>();
        for (Vertice vertice : vertices.values()) {
            if (!vertice.getVisitado()) {
                ordenParcialRecursivo(vertice, orden);
            }
        }
        return orden;
    }

    private void ordenParcialRecursivo(Vertice vertice, LinkedList<Vertice> orden) {
        vertice.setVisitado(true);
        for (Object obj : vertice.getAdyacentes()) {
                Adyacencia adyacencia = (Adyacencia) obj;    
            Vertice adyacente = adyacencia.getDestino();
            if (!adyacente.getVisitado()) {
                ordenParcialRecursivo(adyacente, orden);
            }
        }
        orden.addFirst(vertice);
    }

    // Método para listar en orden ###
    public void listarTareas(LinkedList<Vertice> orden) {
        for (Vertice vertice : orden) {
            System.out.println(vertice.getEtiqueta());
        }
    }

    public Double[][] floyd() {
        int numVertices = vertices.size();
        Double[][] distancias = new Double[numVertices][numVertices];
        Integer[][] predecesores = new Integer[numVertices][numVertices];
        Object[] etiquetas = getEtiquetasOrdenadas();

        // Inicializar las matrices de distancias y predecesores
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j) {
                    distancias[i][j] = 0.0;
                    predecesores[i][j] = null;
                } else if (existeArista((Comparable) etiquetas[i], (Comparable) etiquetas[j])) {
                    Adyacencia arista = buscarVertice((Comparable) etiquetas[i]).buscarAdyacencia(buscarVertice((Comparable) etiquetas[j]));
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

    // Método para clasificar arcos
    public void ClasificarArcos(Vertice verticeOrigen, List<Arista> ArcosArbol, List<Arista> ArcosRetroceso, List<Arista> ArcosAvance, List<Arista> ArcosCruzados) {
        Map<Vertice, Integer> descubrimiento = new HashMap<>();
        Map<Vertice, Integer> finalizacion = new HashMap<>();
        int tiempo = 0;
    
        Stack<Vertice> pila = new Stack<>();
        pila.push(verticeOrigen);
        descubrimiento.put(verticeOrigen, tiempo);
        tiempo++;
    
        while (!pila.isEmpty()) {
            Vertice actual = pila.peek();
            boolean terminado = true;
    
            for (Object obj : actual.getAdyacentes()) {
                Adyacencia adyacencia = (Adyacencia) obj;                
                Vertice vecino = adyacencia.getDestino();
    
                if (!descubrimiento.containsKey(vecino)) {
                    ArcosArbol.add(new Arista(actual.getEtiqueta(), vecino.getEtiqueta(), adyacencia.getCosto()));
                    pila.push(vecino);
                    descubrimiento.put(vecino, tiempo);
                    tiempo++;
                    terminado = false;
                    break;
                } else if (!finalizacion.containsKey(vecino)) {
                    ArcosRetroceso.add(new Arista(actual.getEtiqueta(), vecino.getEtiqueta(), adyacencia.getCosto()));
                } else if (descubrimiento.get(actual) < descubrimiento.get(vecino)) {
                    ArcosAvance.add(new Arista(actual.getEtiqueta(), vecino.getEtiqueta(), adyacencia.getCosto()));
                } else {
                    ArcosCruzados.add(new Arista(actual.getEtiqueta(), vecino.getEtiqueta(), adyacencia.getCosto()));
                }
            }
    
            if (terminado) {
                finalizacion.put(actual, tiempo);
                tiempo++;
                pila.pop();
            }
        }
    }
}
