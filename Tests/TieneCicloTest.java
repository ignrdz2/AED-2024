package test.grafodirigido;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.LinkedList;
import java.util.List;
import grafos.*;

import org.junit.Test;

public class TieneCicloTest {
    @Test
    public void test_no_tiene_ciclo() {
        List<TVertice> vertices = new LinkedList<>();
        vertices.add(new TVertice<>("A"));
        vertices.add(new TVertice<>("B"));
        vertices.add(new TVertice<>("C"));
        vertices.add(new TVertice<>("D"));

        List<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("B", "C", 1));
        aristas.add(new TArista("B", "D", 1));
        aristas.add(new TArista("A", "D", 1));

        TGrafoDirigido gd = new TGrafoDirigido(vertices, aristas);
        assertEquals(false, gd.tieneCiclo());
    }

    @Test
    public void test_tiene_ciclo() {
        List<TVertice> vertices = new LinkedList<>();
        vertices.add(new TVertice<>("A"));
        vertices.add(new TVertice<>("B"));
        vertices.add(new TVertice<>("C"));
        vertices.add(new TVertice<>("D"));

        List<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("B", "C", 1));
        aristas.add(new TArista("D", "A", 1));
        aristas.add(new TArista("A", "D", 1));

        TGrafoDirigido gd = new TGrafoDirigido(vertices, aristas);
        assertEquals(true, gd.tieneCiclo());
    }
}
