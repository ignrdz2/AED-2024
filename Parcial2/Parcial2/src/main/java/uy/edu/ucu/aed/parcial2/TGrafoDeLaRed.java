package uy.edu.ucu.aed.parcial2;

import java.util.ArrayList;
import java.util.Collection;

import uy.edu.ucu.aed.*;

@SuppressWarnings({"unchecked", "rawtypes"})
public class TGrafoDeLaRed extends TGrafoNoDirigido<TEstacionDeLaRed> implements IGrafoDeLaRed {

    public TGrafoDeLaRed(Collection<TVerticeDeLaRed> vertices, Collection<IArista> aristas) {
        
        super((Collection<IVertice<TEstacionDeLaRed>>) (Collection<?>) vertices, aristas);
    }

    @Override
    public TCaminos<TEstacionDeLaRed> caminosDesdeHasta(Comparable nodoOrigen, Comparable nodoDestino) {
        TCaminos losCaminos = new TCaminos();
        TVertice vorigen = new TVertice<>(nodoOrigen);
        TCamino caminoPrevio = new TCamino(vorigen);
        IVertice verticeOrigen = vertices.get(nodoOrigen);
        if (verticeOrigen != null) {
            caminoPrevio.getOtrosVertices().add(verticeOrigen);
            verticeOrigen.todosLosCaminos(nodoDestino, caminoPrevio, losCaminos);
        } else {
            throw new IllegalArgumentException("El nodo de origen " + nodoOrigen + " no existe en el grafo.");
        }
        return losCaminos;
    }
}