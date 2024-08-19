package test.grafonodirigido;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import grafos.TArista;
import grafos.TGrafoNoDirigido;
import grafos.TVertice;

public class KruskalTest {
    @Test
    void test_Kruskal_con_vertices() {
        List<TVertice> vertices = new LinkedList();
        vertices.add(new TVertice<>("1"));
        vertices.add(new TVertice<>("2"));
        vertices.add(new TVertice<>("3"));
        vertices.add(new TVertice<>("4"));
        vertices.add(new TVertice<>("5"));
        vertices.add(new TVertice<>("6"));

        List<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("3", "1", 1));
        aristas.add(new TArista("4", "3", 5));
        aristas.add(new TArista("6", "3", 4));
        aristas.add(new TArista("5", "3", 6));
        aristas.add(new TArista("2", "3", 5));

        aristas.add(new TArista("5", "2", 3));
        aristas.add(new TArista("2", "1", 6));
        aristas.add(new TArista("5", "6", 6));
        aristas.add(new TArista("4", "6", 2));
        aristas.add(new TArista("1", "4", 5));

        TGrafoNoDirigido gnd = new TGrafoNoDirigido(vertices, aristas);
        TGrafoNoDirigido kruskal = gnd.Kruskal();

        assertEquals(6, kruskal.getVertices().size());
        assertEquals(5*2, kruskal.getLasAristas().size());
        
        for (int i = 1; i <= 6; i++) {
            assertNotEquals(null, kruskal.getVertices().get(Integer.toString(i)));
        }
        assertEquals(Double.valueOf(15.0), Double.valueOf(kruskal.getLasAristas().getCostoTotal()));
        assertEquals(true, kruskal.esConexo());
    }

    @Test
    public void test_Kruskal_sin_vertices() {
        TGrafoNoDirigido gnd = new TGrafoNoDirigido(new LinkedList<>(), new LinkedList<>());
        TGrafoNoDirigido kruskal = gnd.Kruskal();
        assertEquals(0, kruskal.getVertices().size());
        assertEquals(0, kruskal.getLasAristas().size());
    }
}
