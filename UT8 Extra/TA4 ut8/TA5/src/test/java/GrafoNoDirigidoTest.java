import org.junit.Before;
import org.junit.Test;

import com.example.Arista;
import com.example.GrafoNoDirigido;
import com.example.Vertice;

import static org.junit.Assert.*;

import java.util.Arrays;

public class GrafoNoDirigidoTest {
    private GrafoNoDirigido grafo;

    @Before
    public void setUp() {
        Vertice<String> verticeA = new Vertice<>("Actor_A");
        Vertice<String> verticeB = new Vertice<>("Actor_B");
        Vertice<String> verticeKevinBacon = new Vertice<>("Kevin_Bacon");

        grafo = new GrafoNoDirigido(Arrays.asList(verticeA, verticeB, verticeKevinBacon), Arrays.asList(
            new Arista("Actor_A", "Actor_B", 1.0),
            new Arista("Actor_B", "Kevin_Bacon", 1.0)
        ));
    }

    @Test
    public void testInsertarVertice() {
        grafo.insertarVertice("Actor_C");
        assertNotNull(grafo.getVertices().get("Actor_C"));
    }

    @Test
    public void testInsertarArista() {
        grafo.insertarVertice("Actor_C");
        grafo.insertarArista(new Arista("Actor_A", "Actor_C", 1.0));
        Vertice actorA = grafo.getVertices().get("Actor_A");
        Vertice actorC = grafo.getVertices().get("Actor_C");
        assertNotNull(actorA.buscarAdyacencia(actorC));
    }

    @Test
    public void testNumBacon() {
        int numBacon = grafo.numBacon("Actor_A");
        assertEquals(2, numBacon);
    }
}
