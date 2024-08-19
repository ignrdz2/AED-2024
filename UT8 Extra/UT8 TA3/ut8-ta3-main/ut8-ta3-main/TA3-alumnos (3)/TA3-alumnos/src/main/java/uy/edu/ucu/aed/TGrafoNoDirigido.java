package uy.edu.ucu.aed;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public abstract class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {
    protected TAristas lasAristas = new TAristas();
    
    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        List<TVertice> resultado = new LinkedList<>();
        Queue<TVertice> cola = new LinkedList<>();
        TVertice vertice = this.buscarVertice(etiquetaOrigen);
    
        if (vertice != null) {
            cola.add(vertice);
            while (!cola.isEmpty()) {
                TVertice actual = cola.poll();
                if (!resultado.contains(actual)) {
                    resultado.add(actual);
                    for (Object obj : actual.getAdyacentes()) {
                        TAdyacencia adyacente = (TAdyacencia) obj;
                        cola.add(adyacente.getDestino());
                    }
                }
            }
        }
        return resultado;
    }

    public Collection<TVertice> bea() {
        List<TVertice> resultado = new LinkedList<>();
        for (TVertice vertice : this.getVertices().values()) {
            if (!resultado.contains(vertice)) {
                resultado.addAll(this.bea(vertice.getEtiqueta()));
            }
        }
        return resultado;
    }

    public TVertice buscarVertice(Comparable etiqueta){
        return getVertices().get(etiqueta);
    }
}
