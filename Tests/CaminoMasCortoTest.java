package test.grafodirigido;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import grafos.*;
import org.junit.Test;

public class CaminoMasCortoTest {
    @Test
    public void test_camino_mas_corto() {
        List<TVertice> vertices = new LinkedList<>();
        vertices.add(new TVertice<>("A"));
        vertices.add(new TVertice<>("B"));
        vertices.add(new TVertice<>("C"));
        vertices.add(new TVertice<>("D"));
        vertices.add(new TVertice<>("Z"));

        List<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("A", "Z", 100));
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("B", "C", 1));
        aristas.add(new TArista("C", "D", 1));
        aristas.add(new TArista("D", "Z", 1));

        TGrafoDirigido gd = new TGrafoDirigido(vertices, aristas);
        TCamino AZ = gd.caminoMasCorto("A", "Z");

        assertEquals("A", AZ.getOrigen().getEtiqueta());
        assertEquals(4, AZ.getOtrosVertices().size());
        assertEquals(Double.valueOf(4.0), AZ.getCostoTotal());

    }
}
