package test.grafonodirigido;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import grafos.*;

import org.junit.jupiter.api.Test;

public class PuntosArticulacionTest {
    @Test
    void test_ejemplo_de_la_ppt_de_clase() {
        List<TVertice> vertices = new LinkedList<>();
        // TVertice origen = new TVertice<>("A");
        vertices.add(new TVertice<>("A"));
        vertices.add(new TVertice<>("B"));
        vertices.add(new TVertice<>("C"));
        vertices.add(new TVertice<>("D"));
        vertices.add(new TVertice<>("E"));
        vertices.add(new TVertice<>("F"));
        vertices.add(new TVertice<>("G"));

        List<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("A", "B", 0));
        aristas.add(new TArista("A", "C", 0));
        aristas.add(new TArista("A", "D", 0));
        aristas.add(new TArista("A", "E", 0));

        aristas.add(new TArista("B", "D", 0));
        aristas.add(new TArista("B", "E", 0));

        aristas.add(new TArista("C", "F", 0));
        aristas.add(new TArista("C", "G", 0));

        aristas.add(new TArista("D", "E", 0));
        aristas.add(new TArista("F", "G", 0));

        TGrafoNoDirigido gnd = new TGrafoNoDirigido(vertices, aristas);

        List<TVertice> puntosArt = gnd.puntosArt(gnd.getVertices().get("A"));

        assertEquals(2, puntosArt.size());
        assertEquals(true, puntosArt.contains(gnd.getVertices().get("A")));
        assertEquals(true, puntosArt.contains(gnd.getVertices().get("C")));
        
    }
}
