package uy.edu.ucu.aed;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class TGrafoDirigidoTest {
    @Test
    void testWarshall() {
        LinkedList<TVertice> vertices = new LinkedList<>();
        vertices.add(new TVertice<>(1));
        vertices.add(new TVertice<>(2));
        vertices.add(new TVertice<>(3));

        LinkedList<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista(1, 1, 2));
        aristas.add(new TArista(1, 2, 8));
        aristas.add(new TArista(1, 3, 5));
        aristas.add(new TArista(2, 1, 3));
        aristas.add(new TArista(3, 2, 2));

        TGrafoDirigido g = new TGrafoDirigido(vertices, aristas);
        boolean[][] warshall = g.warshall();
        for (int i = 0; i < warshall.length; i++) {
            for (int j = 0; j < warshall.length; j++) {
                assertEquals(true, warshall[i][j]);
            }
        }
    }
    
    @Test
    void testFloyd() {
        LinkedList<TVertice> vertices = new LinkedList<>();
        vertices.add(new TVertice<>(1));
        vertices.add(new TVertice<>(2));
        vertices.add(new TVertice<>(3));

        LinkedList<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista(1, 1, 2));
        aristas.add(new TArista(1, 2, 8));
        aristas.add(new TArista(1, 3, 5));
        aristas.add(new TArista(2, 1, 3));
        aristas.add(new TArista(3, 2, 2));

        TGrafoDirigido g = new TGrafoDirigido(vertices, aristas);
        Double[][] floyd = g.floyd();

        assertEquals(Double.valueOf(0.0), floyd[0][0]);
        assertEquals(Double.valueOf(7.0), floyd[0][1]);
        assertEquals(Double.valueOf(5.0), floyd[0][2]);

        assertEquals(Double.valueOf(3.0), floyd[1][0]);
        assertEquals(Double.valueOf(0.0), floyd[1][1]);
        assertEquals(Double.valueOf(8.0), floyd[1][2]);

        assertEquals(Double.valueOf(5.0), floyd[2][0]);
        assertEquals(Double.valueOf(2.0), floyd[2][1]);
        assertEquals(Double.valueOf(0.0), floyd[2][2]);

    }


}
